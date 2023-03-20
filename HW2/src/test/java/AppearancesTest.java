//import org.junit.Test;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static junit.framework.TestCase.assertEquals;

public class AppearancesTest {
    // utility -- converts a string to a list with one
    // elem for each char.
    private List<String> stringToList(String s) {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
            // note: String.valueOf() converts lots of things to string form
        }
        return list;
    }

    @Test
    public void testSameCount_Basic_Character() {
        List<String> a = stringToList("abbccc");
        List<String> b = stringToList("cccbba");
        assertEquals(3, Appearances.sameCount(a, b));
    }

    @Test
    public void testSameCount_Basic_Integer() {
        List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
        assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
        assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
        assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
    }
    // Add more tests
    @Test
    public void testSameCount_char()
    {
        List<Character> a = Arrays.asList('a','2',',','f','y','?');
        List<Character> b = Arrays.asList('b','c','d','a','2','r','.','-');
        assertEquals(2,Appearances.sameCount(a,b));
    }
    @Test
    public void testSameCount_zero()
    {
        List<Character> a = Arrays.asList('a','b','b','g','g','k');
        List<Character> b = Arrays.asList('a','a','b','k','g','k');
        assertEquals(0,Appearances.sameCount(a,b));
    }
    @Test
    public void testSameCount_differentKind()
    {
        List<String> a= stringToList("abbcfggj");
        List<String> b = Arrays.asList("a","b","b","c","f","g","g","j");
        assertEquals(6,Appearances.sameCount(a,b));
    }
    @Test
    public void testSameCount_nullset()
    {
        Set<Integer> a = Collections.emptySet();
        Set<Integer> b = Set.of(1,2,3,4,5,6,7,8,9);
        assertEquals(0,Appearances.sameCount(a,b));
    }
    @Test
    public void testSameCount_containnullvector()
    {
        List<String> a = Arrays.asList("abbn","assd","fhdg1","",null,"d","f");
        List<String> b = Arrays.asList("assd",null,"");
        assertEquals(3,Appearances.sameCount(a,b));
    }
}
