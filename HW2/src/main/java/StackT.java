import java.util.LinkedList;
import java.util.List;

public class StackT<T> {
    private List<T> stack = new LinkedList<>();
    private int top=-1;
    public void push(T s)
    {
        this.stack.add(s);
        top++;
    }
    public T pop()
    {
        T s=null;
        if(top>-1)
        {
            s= this.stack.get(top);
            this.stack.remove(top);
            top--;
        }
        return s;
    }
    public boolean isEmpty()
    {
        if(top==-1)
            return true;
        return false;
    }
    public static void main(String[] args)
    {
        StackT<String> st = new StackT<>();
        st.push("thanh hoa cau giay");
        String s = st.pop();
        System.out.println(s);
        System.out.print(st.isEmpty());
    }
}