// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import java.util.Objects;

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int mini= grid.length;
        int minj=grid[0].length;
        int maxi=0;
        int maxj=0;
        for(int i=0;i< grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(Objects.equals(grid[i][j], ch))
                {
                    if(mini>i) mini=i;
                    if(minj>j) minj=j;
                    if(maxi<i) maxi=i;
                    if(maxj<j) maxj=j;
                }
            }
        }
        int a=maxi-mini+1;
        int b=maxj-minj+1;

        return a*b; // YOUR CODE HERE
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     * @return number of + in grid
     */
    private int up(int i,int j,int m,int n)
    {
        //i-- , j
        int cnt=0;
        char c= this.grid[i][j];
        while(i>=1)
        {
            if(c== this.grid[--i][j])
            {
                cnt++;
            }
        }
        return cnt;
    }
    private int down(int i,int j,int m,int n)
    {
        //i-- , j
        int cnt=0;
        char c= this.grid[i][j];
        while(i<m-1)
        {
            if(c== this.grid[++i][j])
            {
                cnt++;
            }
        }
        return cnt;
    }
    private int left(int i,int j,int m,int n)
    {
        //i-- , j
        int cnt=0;
        char c= this.grid[i][j];
        while(j>=1)
        {
            if(c== this.grid[i][--j])
            {
                cnt++;
            }
        }
        return cnt;
    }
    private int right(int i,int j,int m,int n)
    {
        //i-- , j
        int cnt=0;
        char c= this.grid[i][j];
        while(j<n-1)
        {
            if(c== this.grid[i][++j])
            {
                cnt++;
            }
        }
        return cnt;
    }
    public int countPlus() {
        int cnt=0;
        int m=this.grid.length;
        int n=this.grid[0].length;
        for(int i=1;i<m-1;i++)
        {
            for(int j=1;j<n-1;j++)
            {
                int Up=0,Down=0,Left=0,Right=0;
                if(this.grid[i][j]==this.grid[i-1][j])//up
                {
                    Up=up(i,j,m,n);
                }
                if(this.grid[i][j]==this.grid[i+1][j])//down
                {
                    Down=down(i,j,m,n);
                }
                if(this.grid[i][j]==this.grid[i][j-1])//left
                {
                    Left=left(i,j,m,n);
                }
                if(this.grid[i][j]==this.grid[i][j+1])//right
                {
                    Right=right(i,j,m,n);
                }
                if(Objects.equals(Up,Down) && Objects.equals(Up,Right) && Objects.equals(Up,Left) && Up!=0)
                {
                    cnt++;
                }
            }
        }
        return cnt; // YOUR CODE HERE
    }

}
