
import java.util.List;

public class QuickSort extends SortAlgo{
    public void Sort(List<Double> list, int left, int right)
    {
        if(left >= right) return;
        double p = list.get(right);
        int i = left, j = right -1;
        while(i<=j)
        {
            if(list.get(i) < p && list.get(j) >= p)
            {
                double tmp = list.get(i);
                list.set(i,list.get(j));
                list.set(j,tmp);
                i++;j--;
            }
            else
            {
                if(list.get(i) >= p)
                {
                    i++;
                }
                if(list.get(j) < p)
                {
                    j--;
                }
            }

        }
        double tmp = list.get(i);
        list.set(i,list.get(right));
        list.set(right,tmp);

        Sort(list,left,i-1);
        Sort(list,i+1,right);
    }
    public void sort(List<Double> list) {
        Sort(list,0, list.size()-1);
    }
}
