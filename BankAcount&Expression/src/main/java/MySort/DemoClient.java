package MySort;

import org.example.Acount;
import org.example.*;

import java.util.ArrayList;
import java.util.List;

public class DemoClient implements Sort<Acount>{
    public ArrayList<Acount> sort(ArrayList<Acount> list, MyComparator<Acount> Less) {
        for (int i=0;i<list.size();i++)
        {
            for(int j=i+1;j<list.size();j++)
            {
                if(Less.less(list.get(i), list.get(j)))
                {
                    Acount b= list.get(i);
                    Acount c = list.get(j);
                    list.set(i,c);
                    list.set(j,b);
                }
            }
        }
        return list;
    }
    ArrayList<Acount> a;
    Acount n1,n2,n3;
    ArrayList<Acount> b ;
    void SetUp()
    {
        a = new ArrayList<>(List.of(new Fee(2),new Gambler(34.15),new NickleNDime(20.64), new NickleNDime(56.12),new Gambler(-23.34) ));
        n1 = new Fee(2);n1.deposit(3);n1.deposit(3);n1.deposit(3);n1.withdraw(2.3);
        n2 = new Gambler(5.6);n2.deposit(3);n2.deposit(3);n2.withdraw(2.3);
        n3 = new NickleNDime(6.7);n3.deposit(3);n3.deposit(3);n3.withdraw(2.3);n3.withdraw(2.3);n3.withdraw(2.3);n3.withdraw(2.3);
        b = new ArrayList<>(List.of(n1,n2,n3));
    }

    public static void main(String[] args)
    {
        DemoClient one = new DemoClient();one.SetUp();
        ArrayList<Acount> BA = one.sort(one.a, new BalanceAscending());
        DemoClient two = new DemoClient();two.SetUp();
        ArrayList<Acount> BD = two.sort(two.a, new BalanceDescending());
        DemoClient three = new DemoClient();three.SetUp();
        ArrayList<Acount> TCD = three.sort(three.b, new TransactionCountDescending());

        System.out.println();
        System.out.print("BalanceAscending ");
        for(Acount i : BA)
        {
            System.out.print(i.get_value() + " ");
        }
        System.out.println('\n');
        System.out.print("BalanceDescending ");
        for(Acount i : BD)
        {
            System.out.print(i.get_value() + " ");
        }
        System.out.println('\n');
        System.out.print("TransactionCountDescending ");
        for(Acount i : TCD)
        {
            System.out.print(i.getcount() + " ");
        }
        System.out.println('\n');
    }
}
