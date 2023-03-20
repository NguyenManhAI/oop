import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStack {
    @Test
    public void teststack()
    {
        Stack st = new Stack();
        st.push("hello");
        assertEquals(false,st.isEmpty());
    }
}
