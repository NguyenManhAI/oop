package Expression_;

import static java.lang.Math.*;

public abstract class Expression {
    private int value;
    public int getValue()
    {
        return value;
    }
    public int evaluate()
    {
        return value;
    }
    public Expression(int value)
    {
        this.value = value;
    }
    public String toString()
    {
        return Integer.toString(value);
    }
}
