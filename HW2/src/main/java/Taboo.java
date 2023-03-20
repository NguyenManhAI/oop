
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.security.KeyPair;
import java.util.*;

public class Taboo<T> {

    /**
     * Constructs a new Taboo using the given rules (see handout.)
     * @param rules rules for new Taboo
     */
    private List<T> rules = new ArrayList<>();
    public Taboo(List<T> rules) {
        this.rules=rules;
    }

    /**
     * Returns the set of elements which should not follow
     * the given element.
     * @param elem
     * @return elements which should not follow the given element
     */
    public Set<T> noFollow(T elem) {
        Set<T> cpy = new HashSet<>();
        if(elem==null)
        {
            return Collections.emptySet();
        }
        for(int i=0;i<rules.size()-1;i++)
        {
            if(Objects.equals(rules.get(i),elem))
            {
                if(rules.get(i+1)!=null)
                cpy.add(rules.get(i+1));
            }
        }
        return cpy; // YOUR CODE HERE
    }

    /**
     * Removes elements from the given list that
     * violate the rules (see handout).
     * @param list collection to reduce
     */
    public void reduce(List<T> list) {
        Map<T,Set<T>> check = new HashMap<>();
        for(int i=0;i<rules.size();i++)
        {
            check.put(rules.get(i),noFollow(rules.get(i)));
        }
        for(int i=0;i<list.size()-1;)
        {
            boolean chk=true;
            if(check.get(list.get(i))!=null)
            {
                for(T uf : check.get(list.get(i)))
                {
                    if(Objects.equals(list.get(i+1),uf))
                    {
                        list.remove(i+1);
                        chk=false;
                        break;
                    }
                }
            }
            if(chk)
            {
                i++;
            }
        }
    }
}
