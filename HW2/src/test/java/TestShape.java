import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShape {
    @Test
    public void testcross()
    {
        Shape a = new Shape(Arrays.asList(0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,1.0 ,1.0 ,0.0 ));
        Shape b = new Shape(Arrays.asList(10.0 ,10.0 ,10.0 ,11.0 ,11.0 ,11.0 ,11.0 ,10.0));
        Shape c = new Shape(Arrays.asList(0.5 ,0.5 ,0.5 ,-10.0 ,1.5 ,0.0 ));
        Shape d = new Shape(Arrays.asList(0.5 ,0.5 ,0.75 ,0.75 ,0.75 ,0.2 ));
        assertEquals(false,a.cross(b));
        assertEquals(true,a.cross(c));
        assertEquals(false,a.cross(d));
    }
    @Test
    public void testencircle()
    {
        Shape a = new Shape(Arrays.asList(0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,1.0 ,1.0 ,0.0 ));
        Shape b = new Shape(Arrays.asList(10.0 ,10.0 ,10.0 ,11.0 ,11.0 ,11.0 ,11.0 ,10.0));
        Shape c = new Shape(Arrays.asList(0.5 ,0.5 ,0.5 ,-10.0 ,1.5 ,0.0 ));
        Shape d = new Shape(Arrays.asList(0.5 ,0.5 ,0.75 ,0.75 ,0.75 ,0.2 ));
        assertEquals(0,a.encircle(b));
        assertEquals(1,a.encircle(c));
        assertEquals(2,a.encircle(d));
    }
}
