import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Solve {
    public int[][] grid;
    public Solve solve;
    @Before
    void SetUp()
    {
        grid = new int[][]
                {
                        new int[]{9,4,2,  1,6,3,  8,5,7},
                        new int[]{5,3,6,  2,8,7,  9,4,1},
                        new int[]{8,7,1,  9,5,4,  2,3,6},

                        new int[]{3,2,7,  8,1,9,  4,6,5},
                        new int[]{1,5,4,  3,2,6,  7,9,8},
                        new int[]{6,9,8,  7,4,5,  1,2,3},

                        new int[]{2,6,5,  4,7,1,  3,8,9},
                        new int[]{7,8,9,  6,3,2,  5,1,4},
                        new int[]{4,1,3,  5,9,8,  6,7,2},
                };
        solve = new Solve(grid);
    }
    void SetUp2()
    {
        grid = new int[][]
                {
                        new int[]{ 0, 9, 0,   4, 6, 0,   0, 0, 0},
                        new int[]{ 0, 4, 0,   0, 0, 0,   0, 1, 6},
                        new int[]{ 0, 0, 0,   0, 0, 0,   0, 5, 9},

                        new int[]{ 0, 0, 0,   3, 0, 9,   2, 0, 7},
                        new int[]{ 0, 0, 0,   0, 0, 0,   3, 0, 0},
                        new int[]{ 3, 7, 0,   0, 8, 0,   0, 0, 0},

                        new int[]{ 2, 0, 0,   0, 1, 8,   0, 0, 0},
                        new int[]{ 0, 6, 0,   7, 0, 0,   0, 2, 0},
                        new int[]{ 8, 0, 4,   6, 0, 0,   0, 0, 5},
                };
        solve = new Solve(grid);
    }
    void SetUp3()
    {
        grid = new int[][]
                {
                        new int[]{0,7,9,  8,0,2,  0,6,3},
                        new int[]{6,0,0,  9,0,0,  0,1,0},
                        new int[]{8,0,3,  0,7,0,  0,0,2},

                        new int[]{0,9,0,  0,0,0,  3,7,1},
                        new int[]{0,6,8,  7,0,0,  0,9,0},
                        new int[]{0,3,1,  0,2,0,  5,8,0},

                        new int[]{2,8,6,  5,0,0,  1,3,0},
                        new int[]{0,0,0,  0,0,0,  0,0,0},
                        new int[]{9,0,4,  3,0,0,  8,2,7},
                };
        solve = new Solve(grid);
    }
    @Test
    public void test()
    {
        SetUp();
        assertArrayEquals(new int[][]
                {
                     new int[]{8,5,7},
                     new int[]{9,4,1},
                     new int[]{2,3,6}
                },solve.getSquare()[2]);
        assertArrayEquals(new int[]{
                2,6,1,7,4,8,5,9,3
        },solve.getCols()[2]);
        assertArrayEquals(new int[]
                {
                        2,6,5,4,7,1,3,8,9
                },solve.getRows()[6]);
    }
    @Test
    public void test_getIndex_Square()
    {
        SetUp();
        //
        assertEquals(0,solve.getIndex_Square(0,0));
        assertEquals(0,solve.getIndex_Square(0,1));
        assertEquals(0,solve.getIndex_Square(0,2));

        assertEquals(0,solve.getIndex_Square(1,0));
        assertEquals(0,solve.getIndex_Square(1,1));
        assertEquals(0,solve.getIndex_Square(1,2));

        assertEquals(0,solve.getIndex_Square(2,0));
        assertEquals(0,solve.getIndex_Square(2,1));
        assertEquals(0,solve.getIndex_Square(2,2));

        //
        assertEquals(1,solve.getIndex_Square(0,3));
        assertEquals(1,solve.getIndex_Square(0,4));
        assertEquals(1,solve.getIndex_Square(0,5));

        assertEquals(1,solve.getIndex_Square(1,3));
        assertEquals(1,solve.getIndex_Square(1,4));
        assertEquals(1,solve.getIndex_Square(1,5));

        assertEquals(1,solve.getIndex_Square(2,3));
        assertEquals(1,solve.getIndex_Square(2,4));
        assertEquals(1,solve.getIndex_Square(2,5));

        //
        assertEquals(2,solve.getIndex_Square(0,6));
        assertEquals(2,solve.getIndex_Square(0,7));
        assertEquals(2,solve.getIndex_Square(0,8));

        assertEquals(2,solve.getIndex_Square(1,6));
        assertEquals(2,solve.getIndex_Square(1,7));
        assertEquals(2,solve.getIndex_Square(1,8));

        assertEquals(2,solve.getIndex_Square(2,6));
        assertEquals(2,solve.getIndex_Square(2,7));
        assertEquals(2,solve.getIndex_Square(2,8));

        assertEquals(3,solve.getIndex_Square(4,2));

        assertEquals(4,solve.getIndex_Square(3,3));
        assertEquals(4,solve.getIndex_Square(5,5));
        assertEquals(4,solve.getIndex_Square(4,5));

        assertEquals(5,solve.getIndex_Square(4,6));

        assertEquals(6,solve.getIndex_Square(6,2));

        assertEquals(7,solve.getIndex_Square(7,5));

        assertEquals(8,solve.getIndex_Square(8,6));
    }

    @Test
    public void test_point()
    {
        SetUp();
        assertEquals(5,solve.getIndex_Square(5,8));
        assertEquals(8,solve.getIndex_rows(2,8));
        assertEquals(7,solve.getIndex_cols(1,2));
    }
    @Test
    public void test_hash_getGrid()
    {
        SetUp();
        assertEquals(0,solve.hash_indexGrid(0,0));
        assertEquals(9,solve.hash_indexGrid(1,0));
        assertEquals(11,solve.hash_indexGrid(1,2));
        assertEquals(29,solve.hash_indexGrid(3,2));
    }
    @Test
    public void test_SetCell()
    {
        SetUp2();
        solve.Set_Cell();
        assertArrayEquals(new int[]{1,5,7},solve.get_NumOfCell(0,0));
        assertArrayEquals(null,solve.get_NumOfCell(0,1));
        assertArrayEquals(new int[]{1,2,3,5,7,8},solve.get_NumOfCell(0,2));
        assertArrayEquals(new int[]{1,2,4,5,6},solve.get_NumOfCell(5,5));
        assertArrayEquals(new int[]{1,4,5,6,9},solve.get_NumOfCell(5,6));
        assertArrayEquals(null,solve.get_NumOfCell(8,8));
        assertArrayEquals(new int[]{2,3,5,7,8},solve.get_NumOfCell(1,2));
    }
    @Test
    public void test_SetGrid()
    {
        SetUp2();
        solve.Set_Cell();
        solve.setGrid(4,2,6);
        assertArrayEquals(new int[][]
                {
                        new int[]{ 0, 9, 0,   4, 6, 0,   0, 0, 0},
                        new int[]{ 0, 4, 0,   0, 0, 0,   0, 1, 6},
                        new int[]{ 0, 0, 0,   0, 0, 0,   4, 5, 9},

                        new int[]{ 0, 0, 0,   3, 0, 9,   2, 0, 7},
                        new int[]{ 0, 0, 0,   0, 0, 0,   3, 0, 0},
                        new int[]{ 3, 7, 0,   0, 8, 0,   0, 0, 0},

                        new int[]{ 2, 0, 0,   0, 1, 8,   0, 0, 0},
                        new int[]{ 0, 6, 0,   7, 0, 0,   0, 2, 0},
                        new int[]{ 8, 0, 4,   6, 0, 0,   0, 0, 5},
                },solve.getGrid());
        assertArrayEquals(new int[]{1,5,6,9},solve.get_NumOfCell(5,6));
        assertArrayEquals(new int[]{6,7,9},solve.get_NumOfCell(6,6));
        assertArrayEquals(new int[]{1,8,9},solve.get_NumOfCell(7,6));
        assertArrayEquals(new int[]{1,7,9},solve.get_NumOfCell(8,6));
        assertArrayEquals(new int[]{1,2,3,5,7,8},solve.get_NumOfCell(0,2));
    }
    @Test
    public void test_Set_OnlyNum()
    {
        SetUp2();
        solve.Set_Cell();
        assertEquals(1,solve.getCount_numValidSquare(2,4));
        assertEquals(2,solve.getIndex_rows(2,2));
        assertEquals(6,solve.getIndex_cols(0,2));
        assertEquals(24,solve.hash_indexGrid(solve.getIndex_rows(2,2),solve.getIndex_cols(0,2)));
        assertEquals(true,solve.get_NumIndex(24,4));

        // index i = 8 j = 6;

        solve.Set_OnlyNum();
        //assertArrayEquals(null,solve.get_NumOfCell(8,6));
        //assertEquals(null,solve.getGrid());

    }
    @Test
    public void get_count()
    {
        SetUp2();
        solve.Set_Cell();
        //solve.setGrid(4,2,6);
        assertEquals(0,solve.getCount_numValidSquare(2,1));
        assertEquals(1,solve.getCount_numValidSquare(2,2));
        assertEquals(2,solve.getCount_numValidSquare(2,3));
        assertEquals(1,solve.getCount_numValidSquare(2,4));
        assertEquals(0,solve.getCount_numValidSquare(2,5));
        assertEquals(0,solve.getCount_numValidSquare(2,6));
        assertEquals(4,solve.getCount_numValidSquare(2,7));
        assertEquals(5,solve.getCount_numValidSquare(2,8));
        assertEquals(0,solve.getCount_numValidSquare(2,9));

        // test get numIndex
        assertEquals(true,solve.get_NumIndex(solve.hash_indexGrid(2,6),4));
        assertEquals(false,solve.get_NumIndex(solve.hash_indexGrid(2,6),6));

        solve.setGrid(4,2,6);
    }
    @Test
    public void test_setGrid()
    {
        SetUp2();
        solve.Set_Cell();
//        solve.setGrid(4,2,6);
//        solve.setGrid(2,0,8);
//        solve.setGrid(5,5,5);
//        solve.setGrid(7,6,2);
        solve.Set_OnlyNum();
        assertEquals(4,solve.getCount_numValidCol(6,7));
        assertEquals(2,solve.getCount_numValidSquare(8,7));
        assertEquals(2,solve.getCount_numValidRow(8,7));
        assertArrayEquals(new int[]{1,7,9},solve.get_NumOfCell(8,6));
        assertArrayEquals(new int[]{3,7,9},solve.get_NumOfCell(8,7));
        assertEquals(0,solve.getGrid()[6][6]);
        //assertEquals(new int[]{2,0,0,0,1,8,0,0,0},solve.getGrid()[6]);
        assertArrayEquals(new int[]{6,9},solve.get_NumOfCell(6,6));
        solve.solve();
    }
    @Before
    void SetUp4()
    {
        grid = new int[][]
                {
                        new int[]{ 0, 9, 0,   4, 6, 0,   0, 0, 0},
                        new int[]{ 0, 4, 0,   0, 0, 0,   0, 1, 6},
                        new int[]{ 0, 0, 0,   0, 0, 0,   0, 5, 9},

                        new int[]{ 0, 0, 0,   3, 0, 9,   2, 0, 7},
                        new int[]{ 0, 0, 0,   0, 0, 0,   3, 0, 0},
                        new int[]{ 3, 7, 0,   0, 8, 0,   0, 0, 0},

                        new int[]{ 2, 0, 0,   0, 1, 8,   0, 0, 0},
                        new int[]{ 0, 6, 0,   7, 0, 0,   0, 2, 0},
                        new int[]{ 8, 0, 4,   6, 0, 0,   0, 0, 5},
                };
        solve = new Solve(grid);
    }
    @Test
    public void test_solve()
    {
        SetUp4();
        solve.Set_Cell();
        solve.solve();
        assertEquals(new int[][]{
                new int[]{1,2,3},
                new int[]{2,3,4}
        },solve.getGrid());
    }
    public static void main(String args[])
    {
        int[][] grid;
        Solve solve;
        grid = new int[][]
                {
                        new int[]{0,7,9,  8,0,2,  0,6,3},
                        new int[]{6,0,0,  9,0,0,  0,1,0},
                        new int[]{8,0,3,  0,7,0,  0,0,2},

                        new int[]{0,9,0,  0,0,0,  3,7,1},
                        new int[]{0,6,8,  7,0,0,  0,9,0},
                        new int[]{0,3,1,  0,2,0,  5,8,0},

                        new int[]{2,8,6,  5,0,0,  1,3,0},
                        new int[]{0,0,0,  0,0,0,  0,0,0},
                        new int[]{9,0,4,  3,0,0,  8,2,7},
                };
//                {
//                        new int[]{ 0, 9, 0,   4, 6, 0,   0, 0, 0},
//                        new int[]{ 0, 4, 0,   0, 0, 0,   0, 1, 6},
//                        new int[]{ 0, 0, 0,   0, 0, 0,   0, 5, 9},
//
//                        new int[]{ 0, 0, 0,   3, 0, 9,   2, 0, 7},
//                        new int[]{ 0, 0, 0,   0, 0, 0,   3, 0, 0},
//                        new int[]{ 3, 7, 0,   0, 8, 0,   0, 0, 0},
//
//                        new int[]{ 2, 0, 0,   0, 1, 8,   0, 0, 0},
//                        new int[]{ 0, 6, 0,   7, 0, 0,   0, 2, 0},
//                        new int[]{ 8, 0, 4,   6, 0, 0,   0, 0, 5},
//                };
//                {
//                        new int[]{0,0,4,  7,1,0,  0,0,0},
//                        new int[]{0,7,2,  8,0,6,  5,0,0},
//                        new int[]{0,0,0,  0,0,5,  0,0,7},
//
//                        new int[]{0,1,0,  6,9,0,  2,0,0},
//                        new int[]{3,9,0,  0,5,0,  0,0,0},
//                        new int[]{0,0,0,  0,0,0,  0,8,5},
//
//                        new int[]{0,0,1,  2,3,0,  8,0,4},
//                        new int[]{0,0,3,  5,0,4,  0,0,2},
//                        new int[]{2,4,0,  9,0,0,  0,0,0},
//                };
//        {
//                    new int[]{ 0, 0, 0,   0, 9, 0,   0, 0, 4},
//                    new int[]{ 4, 6, 0,   0, 2, 0,   0, 8, 1},
//                    new int[]{ 0, 0, 1,   0, 0, 0,   5, 0, 7},
//
//                    new int[]{ 0, 0, 0,   0, 4, 1,   7, 0, 0},
//                    new int[]{ 2, 0, 0,   0, 0, 0,   0, 3, 8},
//                    new int[]{ 8, 0, 0,   0, 7, 0,   0, 0, 0},
//
//                    new int[]{ 7, 0, 0,   0, 0, 0,   0, 0, 0},
//                    new int[]{ 0, 0, 0,   0, 0, 4,   6, 0, 9},
//                    new int[]{ 0, 5, 4,   0, 0, 8,   0, 0, 0},
//        };

        solve = new Solve(grid);
        for(int[] i : solve.getGrid())
        {
            for(int j : i)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();System.out.println();
        solve.solve();
        for(int[] i : solve.getGrid())
        {
            for(int j : i)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
//        System.out.println(solve.getGrid()[1][6]);
//        System.out.println(solve.get_CountNumOfCell(solve.hash_indexGrid(1,6)));

//        for(int i = 0; i < Sudoku.SIZE; i++)
//        {
//            for(int j = 1; j <= Sudoku.SIZE;j++)
//            {
//                if(solve.getCount_numValidRow(i,j) == 1)
//                {
//                    System.out.println("row "+ i+ ' ' + "num" + j);
//                }
//            }
//        }
    }
    @Before
    public void setUp5()
    {
        grid = new int[][]
                {
                        new int[]{0,0,4,  7,1,0,  0,0,0},
                        new int[]{0,7,2,  8,0,6,  5,0,0},
                        new int[]{0,0,0,  0,0,5,  0,0,7},

                        new int[]{0,1,0,  6,9,0,  2,0,0},
                        new int[]{3,9,0,  0,5,0,  0,0,0},
                        new int[]{0,0,0,  0,0,0,  0,8,5},

                        new int[]{0,0,1,  2,3,0,  8,0,4},
                        new int[]{0,0,3,  5,0,4,  0,0,2},
                        new int[]{2,4,0,  9,0,0,  0,0,0},
                };
        solve = new Solve(grid);
    }
    @Test
    public void test_undo_EmptyNum()
    {
        setUp5();
        solve.Set_Cell();
        assertEquals(2,solve.getCount_numValidRow(1,3));
        assertEquals(5,solve.getCount_numValidCol(7,3));
        boolean[] cpy = new boolean[Sudoku.SIZE];
        assertArrayEquals(new int[]{3,6,8,9},solve.get_NumOfCell(0,8));
        assertArrayEquals(new int[]{3,7,8},solve.get_NumOfCell(3,5));
        assertArrayEquals(new int[]{1,3,4,6,7,9},solve.get_NumOfCell(5,6));
        assertArrayEquals(new int[]{5,7,8},solve.get_NumOfCell(3,2));

        System.arraycopy(solve.get_NumIndex(solve.hash_indexGrid(3,8)),0,cpy,0,Sudoku.SIZE);
        solve.setGrid(3,3,8);

        assertArrayEquals(new int[]{6,8,9},solve.get_NumOfCell(0,8));
        assertArrayEquals(new int[]{7,8},solve.get_NumOfCell(3,5));
        assertArrayEquals(new int[]{1,4,6,7,9},solve.get_NumOfCell(5,6));

        solve.undo_EmptyCell(3,8,cpy);
        assertArrayEquals(new int[]{3},solve.get_NumOfCell(3,8));
        assertArrayEquals(new int[]{3,6,8,9},solve.get_NumOfCell(0,8));//col
        assertArrayEquals(new int[]{3,7,8},solve.get_NumOfCell(3,5));//row
        assertArrayEquals(new int[]{1,3,4,6,7,9},solve.get_NumOfCell(5,6));//square
        assertArrayEquals(new int[]{5,7,8},solve.get_NumOfCell(3,2));

        System.arraycopy(solve.get_NumIndex(solve.hash_indexGrid(3,5)),0,cpy,0,Sudoku.SIZE);
        solve.setGrid(3,3,5);
        assertArrayEquals(new int[]{1,2,7},solve.get_NumOfCell(5,5));//row
        solve.undo_EmptyCell(3,5,cpy);
        assertArrayEquals(new int[]{3,7,8},solve.get_NumOfCell(3,5));//row
        assertArrayEquals(new int[]{1,2,3,7},solve.get_NumOfCell(5,5));//row
        assertArrayEquals(new int[]{4,5,7,8},solve.get_NumOfCell(3,0));//row

        assertEquals(4,solve.getCount_numValidRow(3,7));
        assertEquals(3,solve.getCount_numValidRow(3,3));
        assertEquals(4,solve.getCount_numValidSquare(4,7));
        assertEquals(3,solve.getCount_numValidSquare(4,3));
        assertEquals(3,solve.getCount_numValidCol(5,3));
        assertEquals(3,solve.getCount_numValidCol(5,2));

        System.arraycopy(solve.get_NumIndex(solve.hash_indexGrid(1,7)),0,cpy,0,Sudoku.SIZE);
        solve.setGrid(3,1,7);
        assertEquals(1,solve.getCount_numValidRow(1,4));
        assertEquals(0,solve.getCount_numValidRow(1,3));
        assertEquals(4,solve.getCount_numValidCol(7,9));
        assertEquals(0,solve.getCount_numValidCol(7,3));
        assertEquals(0,solve.getCount_numValidSquare(2,3));
        assertEquals(2,solve.getCount_numValidSquare(2,4));
        solve.undo_EmptyCell(1,7,cpy);
        assertEquals(2,solve.getCount_numValidRow(1,4));
        assertEquals(2,solve.getCount_numValidRow(1,3));
        assertEquals(5,solve.getCount_numValidCol(7,9));
        assertEquals(5,solve.getCount_numValidCol(7,3));
        assertEquals(7,solve.getCount_numValidSquare(2,3));
        assertEquals(3,solve.getCount_numValidSquare(2,4));

    }

}
