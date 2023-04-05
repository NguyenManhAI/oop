package MySort;

import org.example.Acount;

public class BalanceDescending implements MyComparator<Acount> {
    @Override
    public boolean less(Acount a, Acount b) {
        return (a.get_value() < b.get_value());
    }
}
