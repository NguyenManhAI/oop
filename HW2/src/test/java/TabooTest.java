// TabooTest.java
// Taboo class tests -- nothing provided.

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabooTest {
    @Test
    public void tabootest()
    {
        Taboo<Character> tab = new Taboo<>(Arrays.asList('a','c','a','b'));
        Taboo<Character> tab2 = new Taboo<>(Arrays.asList('a','b',null,'c','d'));
        assertEquals(Set.of('c','b'),tab.noFollow('a'));
        assertEquals(Set.of('d'),tab2.noFollow('c'));
        assertEquals(Collections.emptySet(),tab.noFollow('b'));
    }
    @Test
    public void tabootest_returnnull()
    {
        Taboo<Character> tab = new Taboo<>(Arrays.asList('a','c','a','b'));
        assertEquals(Collections.emptySet(),tab.noFollow('d'));
    }
    @Test
    public void tabootest_null()
    {
        Taboo<Character> tab = new Taboo<>(Arrays.asList('a','c',null,'c','b'));
        assertEquals(Set.of('b'),tab.noFollow('c'));
        assertEquals(Collections.emptySet(),tab.noFollow(null));
    }

    //test reduce
    @Test
    public void reducetest_basic()
    {
        Taboo<Character> tab = new Taboo<>(Arrays.asList('a','c','a','b'));
        List<Character> list = new ArrayList<>(Arrays.asList('a','c','b','x','c','a'));
        tab.reduce(list);
        assertEquals(Arrays.asList('a','x','c'),list);
    }
    @Test
    public void reducetest_null()
    {
        Taboo<Character> tab = new Taboo<>(Arrays.asList('a','c',null,'a','b'));
        List<Character> list1 = new ArrayList<>(Arrays.asList('a','c','b','x','c','a'));
        List<Character> list2 = new ArrayList<>(Arrays.asList('a','c','b',null,'x','c','a'));
        tab.reduce(list1);tab.reduce(list2);
        assertEquals(Arrays.asList('a','x','c','a'),list1);
        assertEquals(Arrays.asList('a',null,'x','c','a'),list2);
    }
    @Test
    public void reducetest_nullrule()
    {
        Taboo<Character> tab = new Taboo<>(Arrays.asList());
        List<Character> list = new ArrayList<>(Arrays.asList('a','c','b','x','c','a'));
        tab.reduce(list);
        assertEquals(Arrays.asList('a','c','b','x','c','a'),list);
    }
}
