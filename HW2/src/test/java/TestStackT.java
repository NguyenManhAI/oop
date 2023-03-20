import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStackT {
    @Test
    public void teststack()
    {
        StackT<String> st = new StackT<>();
        st.push("hello");
        st.pop();
        assertEquals(true,st.isEmpty());
    }
}
