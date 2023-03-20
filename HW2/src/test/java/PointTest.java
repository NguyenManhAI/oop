// Provided testing for simple Point class.

//import org.junit.Test;

//import static junit.framework.TestCase.assertEquals;
//import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PointTest {

    @Test
    public void testConstructor() {
        Point p = new Point(1, 2);
        assertEquals(1.0, p.getX());
        assertEquals(2.0, p.getY());
    }

    @Test
    public void testConstructor_Copy() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(p1);
        assertEquals(1.0, p2.getX());
        assertEquals(2.0, p2.getY());
    }

    @Test
    public void testShiftedPoint_Basic() {
        Point p = new Point(1, 2);
        Point p2 = p.shiftedPoint(10, -10);
        assertEquals(11.0, p2.getX());
        assertEquals(-8.0, p2.getY());
    }

    @Test
    public void testEquals() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(1, 4);
        assertEquals(p1, p2);   //this one calls p1.equals(p2)
        assertEquals(p1, p1);
        assertNotEquals(p1, p3);  //this one calls p1.equals(p3)
    }

    @Test
    public void testDistance() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 4);
        assertEquals(3.0, p1.distance(p2));
        assertEquals(3.0, p2.distance(p1));
    }
}
