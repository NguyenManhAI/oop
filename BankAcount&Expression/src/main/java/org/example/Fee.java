package org.example;

import org.example.Acount;

public class Fee extends Acount {
    public Fee(double initialBalance) {
        super(initialBalance);
    }
    @Override
    public void fee_endMonth()
    {
        balance -= 5.00;
    }
}
