package MySort;

import org.example.Acount;

public class TransactionCountDescending implements MyComparator<Acount> {
    public boolean less(Acount a,Acount b)
    {
        return a.getcount() < b.getcount();
    }
}
