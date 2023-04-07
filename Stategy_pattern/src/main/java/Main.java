import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NumList one = new NumList();
        one.setListOfNum(new double[]{1,2,5,9,1,10,45,23,7,3,90,3});
        System.out.println("Bubble Sort: Before :");
        one.getNumList().forEach(e -> System.out.print(e+ " "));
        System.out.println();
        one.setBubbleSort();
        one.setOrder();
        System.out.println("Bubble Sort: After :");
        one.getNumList().forEach(e -> System.out.print(e+" "));
        System.out.println();

        NumList two = new NumList();
        two.setListOfNum(new double[]{3.0,2.0,9.0,4.0,10.0,6.0});
        System.out.println("Quick Sort: Before :");
        two.getNumList().forEach(e -> System.out.print(e+ " "));
        System.out.println();
        two.setQuickSort();
        two.setOrder();
        System.out.println("Quick Sort: After :");
        two.getNumList().forEach(e -> System.out.print(e+ " "));
    }
}