//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

import java.util.Arrays;
import java.util.LinkedList;

public class TetrisGrid {

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     * @param grid
     */
    private boolean[][] grid;
    public TetrisGrid(boolean[][] grid) {
        this.grid=grid;
    }
    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        LinkedList<boolean[]> a = new LinkedList<>();
        int n=this.grid.length;
        int sizegrid=this.grid[0].length;
        for(int i=0;i<n;i++)
        {
            boolean chk=false;
            for(int j=0;j<sizegrid;j++)
            {
                if(!this.grid[i][j]) chk=true;
            }
            if(chk)
            {
                a.add(this.grid[i]);
            }
        }
        int sizea=a.size();
        boolean[][] grid = new boolean[n][];
        for(int i=0;i<sizea;i++)
        {
            grid[i] = new boolean[sizegrid];
            grid[i]=a.get(i);
        }
        for(int i=sizea;i<n;i++)
        {
            grid[i] = new boolean[sizegrid];
            for(int j=0;j<sizegrid;j++)
            {
                grid[i][j]= false;
            }
        }
        this.grid=grid;
    }

    /**
     * Returns the internal 2d grid array.
     * @return 2d grid array
     */
    public boolean[][] getGrid() {
        return this.grid; // YOUR CODE HERE
    }
}
