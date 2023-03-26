package sort;

import org.example.Acount;
import org.example.Fee;
import org.example.Gambler;
import org.example.NickleNDime;

import java.util.ArrayList;
import java.util.List;

public class DemoClient implements MyComparator<Acount>{
    public static void main(String[] args) {
        List<Acount> list = new ArrayList<>();
        Acount one = new Fee(12);
        Acount two = new Gambler(2);
        Acount three = new NickleNDime(23);
        list.add(one);
        list.add(two);
        list.add(three);
        for(Acount i : list)
        {
            System.out.print(i.getcount()+ " ");
        }
        Sort selectionsort = new Sort(list);
        selectionsort.sort();
        list = selectionsort.getList();
        System.out.println('\n');
        for(Acount i : list)
        {
            System.out.print(i.getcount()+ " ");
        }
    }
    @Override
    public boolean less(Acount first,Acount second) {
        if(first.getcount()<second.getcount()) return true;
        return false;
    }
}
