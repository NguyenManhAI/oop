
import java.util.List;

public class BubbleSort extends SortAlgo{
    public void sort(List<Double> list)
    {
        int n = list.size();
        for(int j = n; j >= 0; j--)
        {
            for(int i = 0; i < j-1; i++)
            {
                if(list.get(i) <= list.get(i+1))
                {
                    double tmp = list.get(i);
                    list.set(i,list.get(i+1));
                    list.set(i+1,tmp);
                }
            }
        }
    }
}
