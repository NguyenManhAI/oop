//import org.junit.Before;
//import org.junit.Test;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertTrue;

/*
  Unit test for Piece class -- starter shell.
 */
public class PieceTest {
    // You can create data to be used in the your test cases like this.
    // For each run of a test method, a new PieceTest object is created
    // and setUp() is called automatically by JUnit.
    // For example, the code below sets up some pyramid and s pieces
    // in instance variables that can be used in tests.
    private Piece pyr1, pyr2, pyr3, pyr4,mypyr = new Piece(Piece.PYRAMID_STR);
    private Piece s, sRotated;
    @Before
    public void setUp() {
        pyr1 = new Piece(Piece.PYRAMID_STR);
        pyr2 = pyr1.computeNextRotation();
        pyr3 = pyr2.computeNextRotation();
        pyr4 = pyr3.computeNextRotation();

        s = new Piece(Piece.S1_STR);
        sRotated = s.computeNextRotation();
    }
        final private Piece STICK = new Piece(Piece.STICK_STR);
        final private Piece S = new Piece(Piece.S1_STR);
        final private Piece L = new Piece(Piece.L1_STR);
        final private Piece SQUARE = new Piece(Piece.SQUARE_STR);
        final private Piece PURAMID = new Piece(Piece.PYRAMID_STR);
    // Here are some sample tests to get you started
    @Test
    public void testSampleSize() {
        setUp();
        // Check size of pyr piece
        assertEquals(3, pyr1.getWidth());
        assertEquals(2, pyr1.getHeight());

        // Now try after rotation
        // Effectively we're testing size and rotation code here
        assertEquals(2, pyr2.getWidth());
        assertEquals(3, pyr2.getHeight());

        // Now try with some other piece, made a different way
        Piece l = new Piece(Piece.STICK_STR);
        assertEquals(1, l.getWidth());
        assertEquals(4, l.getHeight());
    }


    // Test the skirt returned by a few pieces
    @Test
    public void testSampleSkirt() {
        setUp();
        // Note must use assertTrue(Arrays.equals(... as plain .equals does not work
        // right for arrays.
        assertTrue(Arrays.equals(new int[]{0, 0, 0}, pyr1.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0, 1}, pyr3.getSkirt()));

        assertTrue(Arrays.equals(new int[]{0, 0, 1}, s.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0}, sRotated.getSkirt()));
    }
    @Test
    public void testcontructor()
    {
        setUp();
        assertEquals(3,mypyr.getWidth());
        assertEquals(2,mypyr.getHeight());
        //check body
        assertEquals((Arrays.asList(new TPoint[]{new TPoint(1,0),new TPoint(1,1),new TPoint(0,1),new TPoint(1,2)})),Arrays.asList(mypyr.computeNextRotation().getBody()));
        //check skirt
        assertTrue(Arrays.equals(new int[]{0,0,0},mypyr.getSkirt()));
        assertArrayEquals(((new int[]{0, 0, 1})),(s.getSkirt()));
        assertArrayEquals(new int[]{1, 0}, sRotated.getSkirt());
        assertArrayEquals(new TPoint[]{TPoint.make_TPoint(1,0),TPoint.make_TPoint(1,1),TPoint.make_TPoint(0,1),TPoint.make_TPoint(0,2)},sRotated.getBody());
    }
    @Test
    public void testComputeNextRotation()
    {
        //SKIRT
        assertArrayEquals( (new Piece("3 0 2 0 1 0 0 0")).getBody(),(new Piece("0 0 0 1 0 2 0 3")).computeNextRotation().getBody() );
        //SQUARE
        assertArrayEquals((new Piece("1 0 1 1 0 1 0 0").getBody()) , (new Piece("0 0 1 0 1 1 0 1")).computeNextRotation().getBody());
        //s1
        assertArrayEquals((new Piece("1 0 1 1 0 1 0 2").getBody()) , (new Piece("0 0 1 0 1 1 2 1")).computeNextRotation().getBody());
        //L
        assertTrue(new Piece("0 1 0 0 1 0 2 0").computeNextRotation().equals(new Piece("0 0 1 0 1 1 1 2")));
        //pyramid
        assertTrue(new Piece("0 0 1 0 2 0 1 1").computeNextRotation().equals(new Piece("0 1 1 1 1 0 1 2")));
    }
    @Test
    public void testequals()
    {
        //assertEquals((new Piece("1 0 1 1 0 1 0 0")),(new Piece("1 1 0 0 0 1 1 0")));
        assertEquals(true,(new Piece("1 0 1 1 0 1 0 0")).equals((new Piece("1 1 0 0 0 1 1 0"))));
        assertEquals(true,(new Piece("1 0 1 1 0 1 0 0")).equals((new Piece("1 0 1 1 0 1 0 0"))));
        assertEquals(false,(new Piece("1 0 1 1 0 1 0 0 2 0")).equals((new Piece("1 1 0 0 0 1 1 0"))) );
        assertEquals(false,(new Piece("1 0 1 1 0 1 0 0")).equals((new Piece("2 1 0 0 0 1 1 0"))));
        assertTrue((new Piece("0 0 0 2 0 1 1 1").equals(new Piece("0 2 0 0 1 1 0 1"))));

    }
    @Test
    public void testfastRotation()
    {
        setUp();
        Piece.getPieces();
        //assertArrayEquals(pyr2.getBody(),pyr1.fastRotation().getBody());
        Piece ptr = pyr1;
        assertArrayEquals(pyr2.getBody(),ptr.fastRotation().getBody());
        ptr = ptr.fastRotation();
        assertEquals(true,ptr.fastRotation().equals(new Piece("0 1 1 1 2 1 1 0")));
        ptr = ptr.fastRotation();
        assertEquals(true,ptr.fastRotation().equals(new Piece("0 0 0 2 0 1 1 1")));
        ptr = ptr.fastRotation();
        assertArrayEquals(pyr1.getBody(), ptr.fastRotation().getBody());
        assertEquals(true,(new Piece("1 0 1 1 0 1 0 2")).equals((new Piece("0 0 1 0 1 1 2 1")).fastRotation()));
        assertArrayEquals((new Piece(" 0 1 0 0 1 0 2 0")).getBody(),(new Piece("0 0 0 1 0 2 1 2")).fastRotation().getBody());
        assertTrue((new Piece(" 0 0 0 1 1 0 2 0")).equals(new Piece("0 0 0 1 0 2 1 2").fastRotation()));
    }
    @Test
    public void testheight()
    {
        assertEquals(4,STICK.getHeight());
        assertEquals(3,L.getHeight());
        assertEquals(2,S.getHeight());
        assertEquals(2,SQUARE.getHeight());
        assertEquals(2,PURAMID.getHeight());
    }
    @Test
    public void testwidth()
    {
        assertEquals(1,STICK.getWidth());
        assertEquals(2,L.getWidth());
        assertEquals(3,S.getWidth());
        assertEquals(2,SQUARE.getWidth());
        assertEquals(3,PURAMID.getWidth());
    }
    @Test
    public void testskirt()
    {
        assertArrayEquals(new int[]{0},STICK.getSkirt());
        assertArrayEquals(new int[]{0,0}, L.getSkirt());
        assertArrayEquals(new int[]{0,0,1}, S.getSkirt());
        assertArrayEquals(new int[]{0,0}, SQUARE.getSkirt());
        assertArrayEquals(new int[]{0,0,0}, PURAMID.getSkirt());
    }
}
