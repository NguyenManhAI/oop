package org.example;

import org.example.Acount;

public class Gambler extends Acount {

    public Gambler(double initialBalance) {
        super(initialBalance);
    }
    public void withdraw(double amount)
    {
        super.withdraw(amount);
        if(Acount.probability() == Probability_deducting)
        {
            balance -= amount;
        }
    }
}
