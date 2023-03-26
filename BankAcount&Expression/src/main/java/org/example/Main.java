package org.example;

import java.util.Random;

public class Main {
    static int[] arr()
    {
        int[] a = new int[100];
        Random n = new Random();
        for(int i=0;i<100;i++)
        {
            a[i] = (n.nextInt()) % 100;
        }
        return a;
    }
    public static void main(String[] args) {
        for(int i: Main.arr())
        {
            System.out.print(i + " ");
        }
    }
}