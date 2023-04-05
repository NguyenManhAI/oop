package MySort;

import java.util.ArrayList;

public interface Sort<T> {
    ArrayList<T> sort(ArrayList<T> list, MyComparator<T> less);
}
