import java.util.*;

public class Appearances {

    /**
     * Returns the number of elements that appear the same number
     * of times in both collections. Static method. (see handout).
     * @return number of same-appearance elements
     */
    public static <T> int sameCount(Collection<T> a, Collection<T> b) {
        Map<T,Integer> hashmap1 = new HashMap<>();
        Map<T,Integer> hashmap2 = new HashMap<>();
        int cnt=0;
        for(T i : a)
        {
            if(hashmap1.get(i)==null)
            hashmap1.put(i,1);
            else
            hashmap1.replace(i,hashmap1.get(i)+1);
        }
        for(T i : b)
        {
            if (hashmap2.get(i) == null)
                hashmap2.put(i, 1);
            else
                hashmap2.replace(i, hashmap2.get(i) + 1);
        }
        for(T i : hashmap1.keySet())
        {
            if((hashmap1.get(i)).equals(hashmap2.get(i)))
            {
                cnt+=1;
            }
        }
        return cnt; // YOUR CODE
    }
}
