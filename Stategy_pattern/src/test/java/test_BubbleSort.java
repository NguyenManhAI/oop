import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class test_BubbleSort {
    @Test
    public void test()
    {
        BubbleSort one = new BubbleSort();
        List<Double> list = Arrays.asList(3.0,2.0,9.0,4.0,10.0,6.0);
        one.sort(list);
        assertEquals(list, Arrays.asList(10.0, 9.0, 6.0, 4.0, 3.0, 2.0));
    }
    @Test
    public void test_NumList()
    {
        NumList one = new NumList();
        one.setListOfNum(new double[]{1,2,3});
        assertEquals(Arrays.asList(1.0,2.0,3.0), one.getNumList());
    }
    @Test
    public void test_QuickSort()
    {
        QuickSort one = new QuickSort();
        List<Double> list = Arrays.asList(3.0,2.0,9.0,4.0,10.0,6.0);
        one.sort(list);
        assertEquals(Arrays.asList(10.0, 9.0, 6.0, 4.0, 3.0, 2.0),list);
    }
    @Test
    public void test_all()
    {
        NumList one = new NumList();
        one.setListOfNum(new double[]{3.0,2.0,9.0,4.0,10.0,6.0});
        one.setQuickSort();
        one.setOrder();
        assertEquals(Arrays.asList(10.0, 9.0, 6.0, 4.0, 3.0, 2.0),one.getNumList());

        NumList two = new NumList();
        two.setListOfNum(new double[]{3.0,2.0,9.0,4.0,10.0,6.0});
        two.setBubbleSort();
        two.setOrder();
        assertEquals(Arrays.asList(10.0, 9.0, 6.0, 4.0, 3.0, 2.0),two.getNumList());
    }
}
