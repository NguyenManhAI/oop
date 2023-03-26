package sort;

import java.util.List;

public class Sort<T> implements MyComparator {
    private List<T> list ;
    public Sort(List list)
    {
        this.list = list;
    }
    public List getList()
    {
        return list;
    }
    //Selection_sort
    public void sort()
    {
        for(int i=0;i<list.size();i++)
        {
            T t = list.get(i);
            for (int j = i+1; j<list.size() ; i++)
            {
                if(!less(list.get(j),list.get(i)))
                {
                    t = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,t);
                }
            }
        }
    }

    @Override
    public boolean less(Object a, Object b) {
        return false;
    }
}
