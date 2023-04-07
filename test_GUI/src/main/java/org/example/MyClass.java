package org.example;

public class MyClass implements MySingleClass{
    public void print(int a)
    {
        System.out.println(a);
    }
    @Override
    public int main(int x) {
        return x+x;
    }
}
