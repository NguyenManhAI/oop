package org.example;

import org.example.Acount;

public class NickleNDime extends Acount {
    public NickleNDime(double initialBalance)
    {
        super(initialBalance);
    }
    public void fee_endMonth()
    {
        balance -= 0.5 * countwithdraw;
    }
}
