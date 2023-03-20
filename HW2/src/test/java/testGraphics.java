import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testGraphics {
    @Test
    public void testunit()
    {
        TextGraphics graphics = TextGraphics.getInstance();
        graphics.init(12,13);
        assertTrue(true);
    }
    @Test
    public void testrender()
    {
        TextGraphics graphics = TextGraphics.getInstance();
        graphics.init(12,13);
        graphics.render();
        assertTrue(true);
    }
    @Test
    public void testdrawPoint()
    {
        TextGraphics graphics = TextGraphics.getInstance();
        graphics.init(12,13);
        graphics.drawPoint('p',5,6);
        graphics.render();
        assertTrue(true);
    }
    @Test
    public void testfill()
    {
        TextGraphics graphics = TextGraphics.getInstance();
        graphics.init(12,13);
        graphics.drawPoint('p',5,6);
        graphics.fillRect('o',0,0,5,5);
        graphics.render();
        assertTrue(true);
    }
}
