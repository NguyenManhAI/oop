// Board.java

import java.util.Arrays;

/**
 * CS108 Tetris Board.
 * Represents a Tetris board -- essentially a 2-d grid
 * of booleans. Supports tetris pieces and row clearing.
 * Has an "undo" feature that allows clients to add and remove pieces efficiently.
 * Does not do any drawing or have any idea of pixels. Instead,
 * just represents the abstract 2-d board.
 */
public class Board {
    // Some ivars are stubbed out for you:
    private int maxHeight;
    private int[] widths;
    private int[] heights;
    private int width;//final
    private int height;//final
    private boolean[][] grid;

    //pre
    private int pre_maxHeight;
    private int[] pre_widths;
    private int[] pre_heights;
    private boolean[][] pre_grid;

    private boolean DEBUG = true;
    boolean committed;


    // Here a few trivial methods are provided:

    /**
     * Creates an empty board of the given width and height
     * measured in blocks.
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new boolean[width][height];
        committed = true;
        maxHeight = 0;
        widths = new int[height];
        heights = new int[width];

        pre_widths = new int[height];
        pre_heights = new int[width];
        pre_grid = new boolean[width][height];
        // YOUR CODE HERE
    }

    public void reduce_true(int y)
    {
        for(int i=0; i<width; i++)
        {
            for(int j=0;j<height;j++)
            {
                grid[i][j] = true;
                widths[j]++;
                heights[i]++;
            }
        }
        maxHeight = height;
    }

    /**
     * Returns the width of the board in blocks.
     */
    public int getWidth() {
        return width;
    }


    /**
     * Returns the height of the board in blocks.
     */
    public int getHeight() {
        return height;
    }


    /**
     * Returns the max column height present in the board.
     * For an empty board this is 0.
     */
    public int getMaxHeight() {
        return maxHeight; // YOUR CODE HERE
    }

    public int[] getWidths()
    {
        return widths;
    }
    public int[] getHeights()
    {
        return heights;
    }

    /**
     * Checks the board for internal consistency -- used
     * for debugging.
     */
    public void sanityCheck() {
        if (DEBUG) {
            int[] cpy_heights = new int[width];
            int[] cpy_widths = new int[height];
            int cpy_maxHeight = 0;
            for(int i = 0; i < width; i++)
            {
                for(int j = 0; j < height; j++)
                {
                    if(grid[i][j])
                    {
                        cpy_widths[j] ++;
                        if(cpy_heights[i] < j+1)
                        {
                            cpy_heights[i] = j+1;
                        }
                    }
                }
            }

            for(int i : cpy_heights)
            {
                if(cpy_maxHeight < i)
                {
                    cpy_maxHeight = i;
                }
            }

            if(!(Arrays.equals(cpy_widths,widths) && Arrays.equals(cpy_heights,heights ) && cpy_maxHeight == maxHeight)) {
                DEBUG = false;
                throw new RuntimeException("description");
            }

            // YOUR CODE HERE
        }
    }

    /**
     * Given a piece and an x, returns the y
     * value where the piece would come to rest
     * if it were dropped straight down at that x.
     *
     * <p>
     * Implementation: use the skirt and the col heights
     * to compute this fast -- O(skirt length).
     */
    public int dropHeight(Piece piece, int x) {
        // xac dinh diem tiep xuc
        int max = 0;
        int maxi = 0;
        for(int i = 0; i < piece.getSkirt().length; i++)
        {
            if(max < heights[x+i] - piece.getSkirt()[i])
            {
                max = heights[x+i] - piece.getSkirt()[i];
                maxi = i;
            }
        }

        return max; // YOUR CODE HERE
    }


    /**
     * Returns the height of the given column --
     * i.e. the y value of the highest block + 1.
     * The height is 0 if the column contains no blocks.
     */
    public int getColumnHeight(int x) {

        return heights[x]; // YOUR CODE HERE
    }


    /**
     * Returns the number of filled blocks in
     * the given row.
     */
    public int getRowWidth(int y) {

        return widths[y]; // YOUR CODE HERE
    }


    /**
     * Returns true if the given block is filled in the board.
     * Blocks outside of the valid width/height area
     * always return true.
     */
    public boolean getGrid(int x, int y) {

        return grid[x][y]; // YOUR CODE HERE
    }

    public boolean[][] Get_grid()
    {
        return grid;
    }
    public static final int PLACE_OK = 0;
    public static final int PLACE_ROW_FILLED = 1;
    public static final int PLACE_OUT_BOUNDS = 2;
    public static final int PLACE_BAD = 3;

    /**
     * Attempts to add the body of a piece to the board.
     * Copies the piece blocks into the board grid.
     * Returns PLACE_OK for a regular placement, or PLACE_ROW_FILLED
     * for a regular placement that causes at least one row to be filled.
     *
     * <p>Error cases:
     * A placement may fail in two ways. First, if part of the piece may falls out
     * of bounds of the board, PLACE_OUT_BOUNDS is returned.
     * Or the placement may collide with existing blocks in the grid
     * in which case PLACE_BAD is returned.
     * In both error cases, the board may be left in an invalid
     * state. The client can use undo(), to recover the valid, pre-place state.
     */
    public int place(Piece piece, int x, int y) {
        // flag !committed problem
        if (!committed) throw new RuntimeException("place commit problem");

        //truoc khi dat copy sang pre
        pre_maxHeight = maxHeight;
        System.arraycopy(widths,0,pre_widths,0,height);
        System.arraycopy(heights,0,pre_heights,0,width);
        for(int i=0; i < width; i++)
        {
            System.arraycopy(grid[i],0,pre_grid[i],0,height);
        }

        int result = PLACE_OK;
        int X=0;
        int Y=0;


        //mot phan manh nam ngoai bang, de len cac khoi trong mang da lap tu truoc
        for(TPoint i : piece.getBody())
        {
            X = i.x + x;
            Y = i.y + y;
            //ngoai bang
            if((X >= width || X<0) || (Y >= height || Y<0))
            {
                result = PLACE_OUT_BOUNDS;
            }
            else
            //de
            if(grid[X][Y])
            {
                result = PLACE_BAD;
            }
        }

        // dung
        if(result == PLACE_OK)
        {
            for(TPoint i : piece.getBody())
            {
                X = i.x + x;
                Y = i.y + y;

                widths[Y] ++;

                if(heights[X] < Y+1)
                {
                    heights[X] = Y+1;
                }

                grid[X][Y] = true;
                if(maxHeight < heights[X])
                {
                    maxHeight = heights[X];
                }
                if(widths[Y] == height)
                {
                    result = PLACE_ROW_FILLED;
                }
            }
            sanityCheck();
        }
        committed = false;
        // YOUR CODE HERE

        return result;
    }


    /**
     * Deletes rows that are filled all the way across, moving
     * things above down. Returns the number of rows cleared.
     */
    public int clearRows() {
        int rowsCleared = 0;
        int y = -1;
        // cap nhat widths grid[][]   heights maxHeight
        // cu moi hang lap day heights maxHeight giam di mot

        for(int i=0 ; i < height ;i++)
        {
            if(i > y && y!=-1)
            {
                widths[i-rowsCleared] = widths[i];
                for(int j = 0; j < width ; j++)
                {
                    grid[j][i-rowsCleared] = grid[j][i];
                }
            }
            if(widths[i] == width)
            {
                rowsCleared ++;
                y = i;
            }
        }
        for(int i=height-1 ; i > height -1 -rowsCleared; i--)
        {
            widths[i] = 0;
            for(int j = 0; j < width ; j++)
            {
                grid[j][i] = false;
            }
        }

        heights = new int[width];
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                if(grid[i][j])
                {
                    if(heights[i] < j+1)
                    {
                        heights[i] = j+1;
                    }
                }
            }
        }
        maxHeight = -1;
        for(int i : heights)
        {
            if(maxHeight < i)
            {
                maxHeight = i;
            }
        }

//        maxHeight -= rowsCleared;
//        for(int i : heights)
//        {
//            i -= rowsCleared;
//        }
        committed = false;
        // YOUR CODE HERE
        sanityCheck();
        return rowsCleared;
    }


    /**
     * Reverts the board to its state before up to one place
     * and one clearRows();
     * If the conditions for undo() are not met, such as
     * calling undo() twice in a row, then the second undo() does nothing.
     * See the overview docs.
     */
    public void undo() {
        if(!committed)
        {
            maxHeight = pre_maxHeight;
            System.arraycopy(pre_widths,0,widths,0,height);
            System.arraycopy(pre_heights,0,heights,0,width);
            for(int i=0; i < width; i++)
            {
                System.arraycopy(pre_grid[i],0,grid[i],0,height);
            }
            committed = true;
            sanityCheck();
        }
        // YOUR CODE HERE
    }


    /**
     * Puts the board in the committed state.
     */
    public void commit() {
        committed = true;
    }


    /*
     Renders the board state as a big String, suitable for printing.
     This is the sort of print-obj-state utility that can help see complex
     state change over time.
     (provided debugging utility)
     */
    public String toString() {
        StringBuilder buff = new StringBuilder();
        for (int y = height - 1; y >= 0; y--) {
            buff.append('|');
            for (int x = 0; x < width; x++) {
                if (getGrid(x, y)) buff.append('+');
                else buff.append(' ');
            }
            buff.append("|\n");
        }
        for (int x = 0; x < width + 2; x++) buff.append('-');
        return (buff.toString());
    }
}


