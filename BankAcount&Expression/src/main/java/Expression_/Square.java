package Expression_;

public class Square extends Expression{
    private Expression expression;
    public Square(Expression expression)
    {
        super(expression.getValue());
        this.expression = expression;
    }
    public int evaluate()
    {
        return getValue()*getValue();
    }
    public String toString()
    {
        String Square_To_string = new String("");
        Square_To_string += expression.toString() + "^" + "2";
        return Square_To_string;
    }
}
