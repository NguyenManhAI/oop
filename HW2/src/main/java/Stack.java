import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stack {
    private List<String> stack = new LinkedList<>();
    private int top=-1;
    public void push(String s)
    {
        this.stack.add(s);
        top++;
    }
    public String pop()
    {
        String s = new String();
        if(top>-1)
        {
            s=this.stack.get(top);
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
        Stack st = new Stack();
        st.push("uet-vnu");
        String s = st.pop();
        System.out.println(s);
        System.out.print(st.isEmpty());
    }
}

