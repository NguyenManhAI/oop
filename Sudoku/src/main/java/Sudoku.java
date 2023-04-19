public class Sudoku {
    public static final int SIZE = 9;
    public static final int SIZE_SQUARE = 3;
    protected int[][] grid;
    public int[][] getGrid()
    {
        return grid;
    }
    public Sudoku(int[][] grid)
    {
        this.grid = grid;
    }
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        for(int i = 0;i < SIZE; i++)
        {
            for(int j = 0;j < SIZE; j++)
            {
                string.insert(i*SIZE + j, grid[i][j] + ' ');
            }
        }
        return string.toString();
    }
    boolean solve()
    {
        Solve solve = new Solve(grid);
        for(int i = 0; i < SIZE; i++)
        {
            System.arraycopy(solve.getGrid()[i],0,grid[i],0,SIZE);
        }
        return solve.solve();
    }
}
