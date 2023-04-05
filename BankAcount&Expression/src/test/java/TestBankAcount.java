import org.example.Acount;
import org.example.Fee;
import org.example.Gambler;
import org.example.NickleNDime;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBankAcount {
    Acount n1,n2,n3;
    ArrayList<Acount> b ;
    void SetUp()
    {
        n1 = new Fee(2);n1.deposit(3);n1.deposit(3);n1.deposit(3);n1.withdraw(2.3);
        n2 = new Gambler(5.6);n2.deposit(3);n2.deposit(3);n2.withdraw(2.3);
        n3 = new NickleNDime(6.7);n3.deposit(3);n3.deposit(3);n3.withdraw(2.3);n3.withdraw(2.3);n3.withdraw(2.3);n3.withdraw(2.3);
        b = new ArrayList<>(List.of(n1,n2,n3));
    }
    @Test
    public void test()
    {
        SetUp();
        assertEquals(4,n1.getcount());
        assertEquals(3,n2.getcount());
        assertEquals(6,n3.getcount());

        assertEquals(8.7,n1.get_value());
    }
}
