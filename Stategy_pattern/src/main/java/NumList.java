
import java.util.ArrayList;
import java.util.List;

public class NumList {
    private SortAlgo sortAlgorithm;
    private int sizeOfList = 0;
    private List<Double> listOfNum = new ArrayList<>();

    public void setListOfNum(double[] list)
    {
        int n = list.length;
        for(int i = 0;i<n;i++)
        {
            listOfNum.add(list[i]);
        }
        sizeOfList = n;
    }
    public int add(double num) {
        listOfNum.add(num);
        sizeOfList++;
        return sizeOfList;
    }

    public List<Double> getNumList() {
        return listOfNum;
    }

    public void setBubbleSort() {
        sortAlgorithm = new BubbleSort();
    }

    public void setQuickSort()
    {
        sortAlgorithm = new QuickSort();
    }
    public void setOrder()
    {
        sortAlgorithm.sort(listOfNum);
    }
}
