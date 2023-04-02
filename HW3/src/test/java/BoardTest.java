import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.Test;
//
//import static junit.framework.TestCase.assertEquals;

public class BoardTest {
    Board b;
    Board B;
    Piece pyr1, pyr2, pyr3, pyr4, s, sRotated;

    Piece stick_0,stick_1,stick_2,stick_3;
    Piece L_0,L_1,L_2, L_3;
    Piece S_0,S_1,S_2,S_3;
    Piece square_0,square_1,square_2,square_3;
    Piece pyramid_0,pyramid_1,pyramid_2,pyramid_3;

    // This shows how to build things in setUp() to re-use across tests.

    // In this case, setUp() makes shapes, and also a 3X6 board, with pyr placed at the bottom,
    // ready to be used by tests.

    @Before
    public void setUp() {
        b = new Board(3, 6);

        pyr1 = new Piece(Piece.PYRAMID_STR);
        pyr2 = pyr1.computeNextRotation();
        pyr3 = pyr2.computeNextRotation();
        pyr4 = pyr3.computeNextRotation();

        s = new Piece(Piece.S1_STR);
        sRotated = s.computeNextRotation();

        b.place(pyr1, 0, 0);
    }

    // Check the basic width/height/max after the one placement
    @Test
    public void testSample1() {
        setUp();
        assertEquals(1, b.getColumnHeight(0));
        assertEquals(2, b.getColumnHeight(1));
        assertEquals(2, b.getMaxHeight());
        assertEquals(3, b.getRowWidth(0));
        assertEquals(1, b.getRowWidth(1));
        assertEquals(0, b.getRowWidth(2));
    }

    // Place sRotated into the board, then check some measures
    @Test
    public void testSample2() {
        setUp();
        b.commit();
        int result = b.place(sRotated, 1, 1);
        assertEquals(Board.PLACE_OK, result);
        assertEquals(1, b.getColumnHeight(0));
        assertEquals(4, b.getColumnHeight(1));
        assertEquals(3, b.getColumnHeight(2));
        assertEquals(4, b.getMaxHeight());
    }

    @Test
    public void test1()
    {
        setUp();
        assertEquals(1, b.getColumnHeight(0));
    }
    // Make  more tests, by putting together longer series of
    // place, clearRows, undo, place ... checking a few col/row/max
    // numbers that the board looks right after the operations.


    //ham place undo
    @Before
    public void SetUp()
    {
         B = new Board(12,10);
         b = new Board(3,3);

//        public static final String STICK_STR = "0 0	0 1	 0 2  0 3";
//        public static final String L1_STR = "0 0	0 1	 0 2  1 0";
//        public static final String L2_STR = "0 0	1 0 1 1	 1 2";
//        public static final String S1_STR = "0 0	1 0	 1 1  2 1";
//        public static final String S2_STR = "0 1	1 1  1 0  2 0";
//        public static final String SQUARE_STR = "0 0  0 1  1 0  1 1";
//        public static final String PYRAMID_STR = "0 0  1 0  1 1  2 0";

        stick_0 = new Piece(Piece.STICK_STR);
        stick_1 = stick_0.computeNextRotation();stick_2 = stick_1.computeNextRotation();stick_3 = stick_2.computeNextRotation();

        L_0 = new Piece(Piece.L1_STR);
        L_1 = L_0.computeNextRotation();L_2 = L_1.computeNextRotation();L_3 = L_2.computeNextRotation();

        S_0 = new Piece(Piece.S1_STR);
        S_1 = S_0.computeNextRotation();S_2 = S_1.computeNextRotation();S_3 = S_2.computeNextRotation();

        square_0 = new Piece(Piece.SQUARE_STR);
        square_1 = square_0.computeNextRotation();square_2 = square_1.computeNextRotation();square_3 = square_2.computeNextRotation();

        pyramid_0 = new Piece(Piece.PYRAMID_STR);
        pyramid_1 = pyramid_0.computeNextRotation();pyramid_2 = pyramid_1.computeNextRotation();pyramid_3 = pyramid_2.computeNextRotation();

    }
    @Test
    public void test_place()
    {
        SetUp();
        boolean[][] grid = {
                            //  0      1      2      3      4      5      6      7      8      9
                new boolean[]{true ,true ,true ,true ,false ,false ,false ,false ,false ,false },// 0
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 1
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 2
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 3
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 4
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 5
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 6
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 7
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 8
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 9
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 10
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false } // 11
        };
        boolean[][] grid2 = {
                            //  0      1      2      3      4      5      6      7      8      9
                new boolean[]{true ,true ,true ,true ,false ,false ,false ,false ,false ,false },// 0
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 1
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 2
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 3
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 4
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 5
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 6
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 7
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 8
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 9
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 10
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false } // 11
        };
        boolean[][] grid3 = {
                //  0      1      2      3      4      5      6      7      8      9
                new boolean[]{true ,true ,true ,true ,false ,false ,false ,false ,false ,false },// 0
                new boolean[]{true ,true ,false ,true ,false ,false ,false ,false ,false ,false },// 1
                new boolean[]{true ,true ,true ,true ,true ,false ,false ,false ,false ,false },// 2
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 3
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 4
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 5
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 6
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 7
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 8
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 9
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 10
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false } // 11
        };
        B.place(stick_0,0,0);
        for(int i=0 ; i < 10 ;i++)
        {
            assertArrayEquals(grid[i],B.Get_grid()[i]);
        }
        assertArrayEquals(grid,B.Get_grid());
        assertEquals(4,B.getMaxHeight());
        assertArrayEquals(new int[]{4,0,0,0,0,0,0,0,0,0,0,0},B.getHeights());
        assertArrayEquals(new int[]{1,1,1,1,0,0,0,0,0,0},B.getWidths());
        assertEquals(12,B.getWidth());
        assertEquals(10,B.getHeight());
        assertEquals(0,B.getColumnHeight(5));
        assertEquals(1,B.getRowWidth(0));
        B.sanityCheck();

        B.committed = true;
        B.place(L_0,0,2);
        assertArrayEquals(grid,B.Get_grid());

        B.committed = true;
        B.place(square_0,1,0);
        assertArrayEquals(grid2,B.Get_grid());
        assertEquals(4,B.getMaxHeight());
        assertArrayEquals(new int[]{4,2,2,0,0,0,0,0,0,0,0,0},B.getHeights());
        assertArrayEquals(new int[]{3,3,1,1,0,0,0,0,0,0},B.getWidths());
        assertEquals(12,B.getWidth());
        assertEquals(10,B.getHeight());
        assertEquals(4,B.getColumnHeight(0));
        assertEquals(3,B.getRowWidth(0));
        B.sanityCheck();

        B.undo();
        assertArrayEquals(grid,B.Get_grid());
        assertEquals(4,B.getMaxHeight());
        assertArrayEquals(new int[]{4,0,0,0,0,0,0,0,0,0,0,0},B.getHeights());
        assertArrayEquals(new int[]{1,1,1,1,0,0,0,0,0,0},B.getWidths());
        assertEquals(12,B.getWidth());
        assertEquals(10,B.getHeight());
        assertEquals(0,B.getColumnHeight(5));
        assertEquals(1,B.getRowWidth(0));
        B.sanityCheck();

        B.committed = true;
        B.place(square_0,1,0);
        B.committed = true;
        B.place(pyramid_1,1,2);
        assertArrayEquals(grid3,B.Get_grid());
        assertEquals(5,B.getMaxHeight());
        assertArrayEquals(new int[]{4,4,5,0,0,0,0,0,0,0,0,0},B.getHeights());
        assertArrayEquals(new int[]{3,3,2,3,1,0,0,0,0,0},B.getWidths());
        assertEquals(12,B.getWidth());
        assertEquals(10,B.getHeight());
        assertEquals(0,B.getColumnHeight(5));
        assertEquals(2,B.getRowWidth(2));
        B.sanityCheck();
        //B.committed = true;
        B.undo();
        assertArrayEquals(grid2,B.Get_grid());
    }
    @Test
    public void test_place2()
    {
        SetUp();
        boolean[][] grid = {
                            //  0      1      2      3      4      5      6      7      8      9
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 0
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 1
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 2
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 3
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 4
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 5
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 6
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 7
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 8
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 9
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 10
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false } // 11
        };
        B.place(pyramid_3,0,0);
        assertEquals(3,B.getMaxHeight());
        assertArrayEquals(new int[]{3,2,0,0,0,0,0,0,0,0,0,0},B.getHeights());
        assertArrayEquals(new int[]{1,2,1,0,0,0,0,0,0,0},B.getWidths());
        assertEquals(12,B.getWidth());
        assertEquals(10,B.getHeight());
        assertEquals(2,B.getColumnHeight(1));
        assertEquals(1,B.getRowWidth(2));
        B.sanityCheck();

        B.committed = true;
        B.place(new Piece(Piece.L2_STR),1,0);
        assertArrayEquals(grid,B.Get_grid());
        assertEquals(3,B.getMaxHeight());
        assertArrayEquals(new int[]{3,2,3,0,0,0,0,0,0,0,0,0},B.getHeights());
        assertArrayEquals(new int[]{3,3,2,0,0,0,0,0,0,0},B.getWidths());
        assertEquals(12,B.getWidth());
        assertEquals(10,B.getHeight());
        assertEquals(2,B.getColumnHeight(1));
        assertEquals(3,B.getRowWidth(1));
        B.sanityCheck();
    }
    @Test
    public void test_clearRows()
    {
        SetUp();
        boolean[][] grid = {
                            //  0      1      2      3      4      5      6      7      8      9
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 0
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 1
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 2
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 3
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 4
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 5
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 6
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 7
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 8
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 9
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 10
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false } // 11
        };
        boolean[][] grid2 = {
                            //  0      1      2      3      4      5      6      7      8      9
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 0
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 1
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 2
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 3
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 4
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 5
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 6
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 7
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 8
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 9
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 10
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false } // 11
        };
        boolean[][] grid3 = {
                            //  0      1      2      3      4      5      6      7      8      9
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 0
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 1
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 2
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 3
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 4
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 5
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 6
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 7
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 8
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 9
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 10
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false } // 11
        };
        B.place(stick_1,0,0);B.commit();
        B.place(stick_1,4,0);B.commit();
        B.place(stick_1,8,0);B.commit();
        B.place(square_0,1,1);B.commit();
        B.place(pyramid_0,3,1);

        assertArrayEquals(grid,B.Get_grid());
        B.clearRows();
        assertArrayEquals(grid2,B.Get_grid());
        assertArrayEquals(new int[]{5,3,0,0,0,0,0,0,0,0},B.getWidths());
        assertArrayEquals(new int[]{0,2,2,1,2,1,0,0,0,0,0,0},B.getHeights());
        assertEquals(2,B.getMaxHeight());

        B.undo();
        assertArrayEquals(grid3,B.Get_grid());

    }
    @Test
    public void test_clearRow2()
    {
        boolean[][] grid4 = new boolean[5][5];

        boolean[][] grid = new boolean[][]{
                new boolean[]{true,true,true,true,true},
                new boolean[]{true,true,true,true,true},
                new boolean[]{true,true,true,true,true},
                new boolean[]{true,true,true,true,true},
                new boolean[]{true,true,true,true,true}
        };
        Board NB = new Board(5,5);
        NB.reduce_true(0);
        assertArrayEquals(grid, NB.Get_grid());
        NB.clearRows();
        assertArrayEquals(grid4,NB.Get_grid());
    }
    @Test
    public void test_drop_height()
    {

        SetUp();
        boolean[][] grid = {
                            //  0      1      2      3      4      5      6      7      8      9
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 0
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 1
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 2
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 3
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 4
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 5
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 6
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 7
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 8
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 9
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 10
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false } // 11
        };
        boolean[][] grid2 = {
                //  0      1      2      3      4      5      6      7      8      9
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 0
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 1
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 2
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 3
                new boolean[]{true ,true ,false ,false ,false ,false ,false ,false ,false ,false },// 4
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 5
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 6
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 7
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 8
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 9
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 10
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false } // 11
        };
        boolean[][] grid3 = {
                            //  0      1      2      3      4      5      6      7      8      9
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 0
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 1
                new boolean[]{true ,true ,true ,false ,false ,false ,false ,false ,false ,false },// 2
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 3
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 4
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 5
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 6
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 7
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 8
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 9
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },// 10
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false } // 11
        };
        boolean[][] grid4 = new boolean[][]{
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{true ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false },
                new boolean[]{false ,false ,false ,false ,false ,false ,false ,false ,false ,false }
        };
        B.place(stick_1,0,0);B.commit();
        B.place(stick_1,4,0);B.commit();
        B.place(stick_1,8,0);B.commit();
        B.place(square_0,1,1);B.commit();
        B.place(pyramid_0,3,1);

        Board NB = new Board(12,10);
        assertEquals(2,B.dropHeight(S_1,4));
        assertEquals(0,NB.dropHeight(S_1,0));
        assertEquals(0,NB.dropHeight(S_1,3));
        assertEquals(2,B.dropHeight(stick_0,3));
        assertEquals(1,B.dropHeight(pyramid_0,9));
        assertEquals(1,B.dropHeight(L_0,6));

        Board NNB = new Board(12,10);
        NNB.place(stick_1,0,0);NNB.commit();
        NNB.place(stick_1,4,0);NNB.commit();
        NNB.place(stick_1,8,0);NNB.commit();
        assertEquals(1,NNB.dropHeight(S_1,0));
        assertEquals(1,NNB.dropHeight(S_1,3));

        Board C = new Board(12,10);
        C.place(stick_1,0,0);C.commit();
        assertArrayEquals(grid4,C.Get_grid());
        assertEquals(1,NNB.dropHeight(S_1,7));
    }
}
