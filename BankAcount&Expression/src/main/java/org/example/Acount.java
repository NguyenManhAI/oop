package org.example;

import java.util.Random;

// tao ra mot ham sao cho xac xuat de rut tien khong tinh phi la 0.49, xac suat
//so tien bi tru gap doi so tien rut la 0.51
public abstract class Acount {
    protected double balance;
    protected int countdeposit;
    protected int countwithdraw;
    private int count;
    public int getcount()
    {
        return count = countdeposit + countwithdraw;
    }
    public Acount(double initialBalance)//concrete
    {
        balance = initialBalance;
    }
    public void deposit(double amount)//concrete
    {
        balance += amount;
        countdeposit++;
    }
    public void withdraw(double amount)
    {
        balance -= amount;
        countwithdraw++;
    }
    public void fee_endMonth(){}
    public void print(){
        System.out.println("Times of Depositing: " + countdeposit);
        System.out.println("Times of Withdrawing: " + countwithdraw);
        System.out.println("Balance: "  + balance);
    }
    public void resetcount(){
        countwithdraw = 0;
        countdeposit = 0;
    }
    public final void endMonth()
    {
        fee_endMonth();
        print();
        resetcount();
    }
    public static final int Probability_nofee = 1;
    public static final int Probability_deducting = 0;
    public static int probability()
    {
        Random a = new Random();
        int n =Math.abs(a.nextInt()) %100;
        if(n >= 49)
        {
            // probability 0.51
            return Probability_deducting;
        }
        else return Probability_nofee;
    }

}
