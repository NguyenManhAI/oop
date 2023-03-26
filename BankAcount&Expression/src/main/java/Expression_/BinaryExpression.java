package Expression_;

public class BinaryExpression extends Expression {
    private Expression left;
    private Expression right;
    public BinaryExpression(Expression left, Expression right) {
        super(left.getValue());
        this.right = right;
        this.left = left;
    }
    public int evaluate()
    {
        return left.evaluate()+right.evaluate();
    }
    public String toString()
    {
        String Num_to_String = new String("");
        Num_to_String += "(" + left.toString() + " + " + right.toString() + ")";
        return Num_to_String;
    }
}
