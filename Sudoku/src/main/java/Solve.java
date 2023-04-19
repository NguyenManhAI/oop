
public class Solve {

    private int[][] grid;/** 9x9 , 81 cell, each cell has 9 numbers from 1 to 9*/
    private int[][] rows;/** rows[1],row[2], ... each rows[i] is one of grid*/
    private int[][] cols;/** cols[1],cols[2], ... each cols[i] is one of grid*/
    /**
    grid divide to 9 square, each square is 3x3
     */
    private int[][][] square;
    /**
    count of numbers of non-zero digits in the array
     */
    private int[] NumOfRows;
    private int[] NumOfCols;
    private int[] NumOfSquare;
    /**
    count of numbers may be valid in one cell of this array
     */
    private int[] NumOfCell;
    /**
    *index first: num is checked in a row,col,or square
    *index second: rows, cols, square is checked
     */

    private boolean[][] check_rows;
    private boolean[][] check_cols;
    private boolean[][] check_square;

    /**
     each cell contains numbers from 1 to 9, check the cell with the selected number
     */
    private boolean[][] Num_Index = new boolean[Sudoku.SIZE * Sudoku.SIZE][Sudoku.SIZE];

    /**
     * the quantity of valid num in Square,Row,Col
     */
    private int[][] count_numValidSquare ;
    private int[][] count_numValidRow;
    private int[][] count_numValidCol;

    private void Set_count_numInvalidSquare(int num,int index)
    {
        count_numValidSquare[index][num-1] ++;
    }
    private void Set_count_numInvalidRow(int num,int index)
    {
        count_numValidRow[index][num-1] ++;
    }
    private void Set_count_numInvalidCol(int num,int index)
    {
        count_numValidCol[index][num-1] ++;
    }

    /**
    the function, which converts x index row of grid, y index col of grid to one integer ,is used for Num_Index
     */
    public int hash_indexGrid(int x,int y)
    {
        return x * Sudoku.SIZE + y;
    }

    /**
     set count of valid number in a cell, this num is valid?
     */
    private void set_CheckNumOfCell(int num,int index_cell,boolean check)
    {
        if(check)
        {
            if(grid[index_cell/Sudoku.SIZE][index_cell%Sudoku.SIZE] == 0)
            {
                if(!Num_Index[index_cell][num-1])
                {
                    Num_Index[index_cell][num - 1] = true;
                    NumOfCell[index_cell]++;
                    count_numValidSquare[getIndex_Square(index_cell / Sudoku.SIZE, index_cell % Sudoku.SIZE)][num - 1]++;
                    count_numValidRow[index_cell / Sudoku.SIZE][num - 1]++;
                    count_numValidCol[index_cell % Sudoku.SIZE][num - 1]++;
                }
            }
        }
        else {
            if(Num_Index[index_cell][num-1])
            {
                Num_Index[index_cell][num - 1] = false;
                if (NumOfCell[index_cell] > 0) {
                    NumOfCell[index_cell]--;
                }

                if (count_numValidSquare[getIndex_Square(index_cell / Sudoku.SIZE, index_cell % Sudoku.SIZE)][num - 1] > 0) {
                    count_numValidSquare[getIndex_Square(index_cell / Sudoku.SIZE, index_cell % Sudoku.SIZE)][num - 1]--;
                }

                if (count_numValidRow[index_cell / Sudoku.SIZE][num - 1] > 0) {
                    count_numValidRow[index_cell / Sudoku.SIZE][num - 1]--;
                }

                if (count_numValidCol[index_cell % Sudoku.SIZE][num - 1] > 0) {
                    count_numValidCol[index_cell % Sudoku.SIZE][num - 1]--;
                }
            }
        }
    }

    /**
     get valid number in a cell, true or false
     */
    public boolean get_CheckNumOfCell(int num,int index_cell)
    {
        return Num_Index[index_cell][num-1];
    }

    public int get_CountNumOfCell(int index_cell)
    {
        if(grid[index_cell/Sudoku.SIZE][index_cell % Sudoku.SIZE] == 0) return NumOfCell[index_cell];
        else throw new RuntimeException("num in cell is zero, so can't get count num");
    }

    /**
     set num is in rows?
     */
    private void set_checkRows(int num,int index_rows,boolean check)
    {
        check_rows[num-1][index_rows] = check;
    }
    public boolean get_checkRows(int num,int index_rows)
    {
        return check_rows[num-1][index_rows];
    }

    /**
     set num is in cols?
     */
    private void set_checkCols(int num,int index_cols,boolean check)
    {
        check_cols[num-1][index_cols] = check;
    }
    public boolean get_checkCols(int num,int index_cols)
    {
        return check_cols[num-1][index_cols];
    }

    /**
     set num is in square?
     */
    private void set_checkSquare(int num,int index_square,boolean check)
    {
        check_square[num-1][index_square] = check;
    }
    public boolean get_checkSquare(int num,int index_square)
    {
        return check_square[num-1][index_square];
    }

    public int[][] getRows()
    {
        return rows;
    }
    public int[][] getCols()
    {
        return cols;
    }
    public int[][][] getSquare()
    {
        return square;
    }

    /**
     *
     * @param num is added in the cell
     * @param x index row
     * @param y index col
     *  change: checkSquare, checkCols, checkRows,
     *          checkNumOfCell: in a row, col, square
     */
    public void setGrid(int num,int x,int y)//usually check = true
    {
        if(grid[x][y] != 0 ) return;
        grid[x][y] = num;
        //fix rows , cols , square

        //set check
        set_checkSquare(num,getIndex_Square(x,y),true);
        set_checkCols(num,y,true);
        set_checkRows(num,x,true);

        // cells of square row col don't have this num

        for(int i = 0; i < Sudoku.SIZE; i++)
        {
            //cols
            set_CheckNumOfCell(num,hash_indexGrid(i,y),false);
            //rows
            set_CheckNumOfCell(num,hash_indexGrid(x,i),false);
        }
        //square
        int index_square = getIndex_Square(x,y);
        for(int i = 0; i < Sudoku.SIZE_SQUARE; i++)
        {
            for(int j = 0; j < Sudoku.SIZE_SQUARE; j++)
            {
                set_CheckNumOfCell(num,hash_indexGrid(getIndex_rows(i,index_square),getIndex_cols(j,index_square)),false);
            }
        }
        //in this cell, all num was valid is deleted, count--
        for(int j = 1; j <= Sudoku.SIZE; j++)
        {
            set_CheckNumOfCell(j,hash_indexGrid(x,y),false);
        }
        count++;
    }

    public Solve(int[][] grid)
    {
        this.grid = grid;

        count_numValidSquare = new int[Sudoku.SIZE][Sudoku.SIZE];
        count_numValidCol = new int[Sudoku.SIZE][Sudoku.SIZE];
        count_numValidRow = new int[Sudoku.SIZE][Sudoku.SIZE];

        rows = new int[Sudoku.SIZE][Sudoku.SIZE];
        cols = new int[Sudoku.SIZE][Sudoku.SIZE];
        square = new int[Sudoku.SIZE][Sudoku.SIZE/Sudoku.SIZE_SQUARE][Sudoku.SIZE/Sudoku.SIZE_SQUARE];

        NumOfCols = new int[Sudoku.SIZE];
        NumOfRows = new int[Sudoku.SIZE];
        NumOfSquare = new int[Sudoku.SIZE];
        NumOfCell = new int[Sudoku.SIZE * Sudoku.SIZE];

        check_rows = new boolean[Sudoku.SIZE][Sudoku.SIZE];
        check_cols = new boolean[Sudoku.SIZE][Sudoku.SIZE];
        check_square = new boolean[Sudoku.SIZE][Sudoku.SIZE];
        //rows
        for(int i = 0; i < Sudoku.SIZE; i++)
        {
            System.arraycopy(grid[i],0,rows[i],0,Sudoku.SIZE);
        }
        //cols
        for(int i = 0; i < Sudoku.SIZE; i++)
        {
            for(int j = 0; j < Sudoku.SIZE; j++)
            {
                cols[i][j] = grid[j][i];
                if(grid[i][j] != 0)
                {
                    NumOfSquare[getIndex_Square(i,j)] ++;
                    NumOfRows[i] ++;
                    NumOfCols[j] ++;

                    set_checkCols(grid[i][j],j,true);
                    set_checkRows(grid[i][j],i,true);
                    set_checkSquare(grid[i][j],getIndex_Square(i,j),true);

                    count++;
                }
            }
        }
        //square
        for(int k = 0; k < Sudoku.SIZE; k++)
        {
            for(int i = 0; i < Sudoku.SIZE / Sudoku.SIZE_SQUARE; i++)
            {
                System.arraycopy(grid[k / Sudoku.SIZE_SQUARE * Sudoku.SIZE_SQUARE + i], k % 3 * 3 , square[k][i], 0, Sudoku.SIZE / Sudoku.SIZE_SQUARE);
            }
        }
    }
    public int getIndex_Square(int x,int y)
    {
        return (x/Sudoku.SIZE_SQUARE) * Sudoku.SIZE_SQUARE + (y/Sudoku.SIZE_SQUARE);
    }
    public int getIndex_rows(int i,int Index_Square)// by index_square and index i of square
    {
        return (Index_Square/Sudoku.SIZE_SQUARE) * Sudoku.SIZE_SQUARE + i;
    }
    public int getIndex_cols(int j,int Index_Square)//by index_square and index j of square
    {
        return (Index_Square % Sudoku.SIZE_SQUARE) * Sudoku.SIZE_SQUARE + j;
    }

    private int count = 0;
    public int getCount_numValidSquare(int indexSquare,int num)
    {
        return count_numValidSquare[indexSquare][num - 1];
    }
    public int getCount_numValidRow(int indexRow,int num)
    {
        return count_numValidRow[indexRow][num - 1];
    }
    public int getCount_numValidCol(int indexCol,int num)
    {
        return count_numValidCol[indexCol][num - 1];
    }

    public static final int EmptyCell = 2;
    public static final int Ok = 1;
    public static final int non_case = 0;
    public int Set_OnlyNum()
    {
        int cnt = 0;
        for(int i = 0; i < Sudoku.SIZE; i++)
        {
            for(int j = 1; j <= Sudoku.SIZE; j++)
            {
                if(getCount_numValidSquare(i,j) == 1)
                {
                    for(int m = 0; m < Sudoku.SIZE_SQUARE; m++)
                    {
                        for(int n = 0; n < Sudoku.SIZE_SQUARE; n++)
                        {
                            if(get_NumIndex(hash_indexGrid(getIndex_rows(m,i),getIndex_cols(n,i)),j) && grid[getIndex_rows(m,i)][getIndex_cols(n,i)] == 0)
                            {
                                boolean check = true;
                                boolean[] cpy_numIndex = new boolean[Sudoku.SIZE];
                                System.arraycopy(Num_Index[hash_indexGrid(getIndex_rows(m,i),getIndex_cols(n,i))],0,cpy_numIndex,0,Sudoku.SIZE);

                                setGrid(j,getIndex_rows(m,i),getIndex_cols(n,i));//
                                for(int l = 0; l < Sudoku.SIZE*Sudoku.SIZE; l++) {
                                    if (grid[l / Sudoku.SIZE][l % Sudoku.SIZE] == 0) {
                                        if (NumOfCell[l] == 0) check = false;
                                    }
                                }

                                if(check)
                                    cnt++;//
                                else {
                                    undo_EmptyCell(getIndex_rows(m, i), getIndex_cols(n, i), cpy_numIndex);
                                    return EmptyCell;
                                }
                            }
                        }
                    }
                }
                if(getCount_numValidRow(i,j) == 1)
                {
                    for(int k = 0; k < Sudoku.SIZE; k++)
                    {
                        if(get_NumIndex(hash_indexGrid(i,k),j) && grid[i][k] == 0)
                        {
                            boolean check = true;
                            boolean[] cpy_numIndex = new boolean[Sudoku.SIZE];
                            System.arraycopy(Num_Index[hash_indexGrid(i,k)],0,cpy_numIndex,0,Sudoku.SIZE);
                            setGrid(j,i,k);//

                            for(int l = 0; l < Sudoku.SIZE*Sudoku.SIZE; l++) {
                                if (grid[l / Sudoku.SIZE][l % Sudoku.SIZE] == 0) {
                                    if (NumOfCell[l] == 0) check = false;
                                }
                            }

                            if(check)
                                cnt++;//
                            else {
                                undo_EmptyCell(i, k, cpy_numIndex);
                                return EmptyCell;
                            }
                        }
                    }
                }
                if(getCount_numValidCol(i,j) == 1)
                {
                    for(int k = 0; k < Sudoku.SIZE; k++)
                    {
                        if(get_NumIndex(hash_indexGrid(k,i),j) && grid[k][i] == 0)
                        {
                            boolean check = true;
                            boolean[] cpy_numIndex = new boolean[Sudoku.SIZE];
                            System.arraycopy(Num_Index[hash_indexGrid(k,i)],0,cpy_numIndex,0,Sudoku.SIZE);

                            setGrid(j,k,i);//

                            for(int l = 0; l < Sudoku.SIZE*Sudoku.SIZE; l++) {
                                if (grid[l / Sudoku.SIZE][l % Sudoku.SIZE] == 0) {
                                    if (NumOfCell[l] == 0) check = false;
                                }
                            }

                            if(check)
                                cnt++;//
                            else {
                                undo_EmptyCell(k, i, cpy_numIndex);
                                return EmptyCell;
                            }
                        }
                    }
                }
            }
        }
        return (cnt == 0)? non_case : Ok;
    }
    public void Set_Cell()
    {
        for(int k = 1; k <= Sudoku.SIZE; k++)
        {
            for(int i = 0; i < Sudoku.SIZE; i++)
            {
                if(!get_checkSquare(k,i))
                {
                    for(int m = 0; m < Sudoku.SIZE_SQUARE; m++)
                    {
                        if(!get_checkRows(k,getIndex_rows(m,i)))
                        {
                            int x = getIndex_rows(m,i);
                            for(int n = 0; n < Sudoku.SIZE_SQUARE; n++)
                            {
                                if(!get_checkCols(k,getIndex_cols(n,i)))
                                {
                                    int y = getIndex_cols(n,i);
                                    if(grid[x][y] == 0)
                                    {
                                        set_CheckNumOfCell(k,hash_indexGrid(x,y),true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private int Set_SureNum()
    {
        int cnt = 0;
        for(int i = 0; i < Sudoku.SIZE*Sudoku.SIZE; i++) {
            if (grid[i / Sudoku.SIZE][i % Sudoku.SIZE] == 0) {
                if (NumOfCell[i] == 1) {
                    for (int j = 1; j <= Sudoku.SIZE; j++) {
                        if (get_NumIndex(i, j) ) {

                            boolean check = true;
                            boolean[] cpy_numIndex = new boolean[Sudoku.SIZE];
                            System.arraycopy(Num_Index[i],0,cpy_numIndex,0,Sudoku.SIZE);

                            setGrid(j, i / Sudoku.SIZE, i % Sudoku.SIZE);//

                            for(int l = 0; l < Sudoku.SIZE*Sudoku.SIZE; l++) {
                                if (grid[l / Sudoku.SIZE][l % Sudoku.SIZE] == 0) {
                                    if (NumOfCell[l] == 0) check = false;
                                }
                            }

                            if(check) {
                                cnt++;//
                            }
                            else {
                                undo_EmptyCell(i / Sudoku.SIZE, i % Sudoku.SIZE, cpy_numIndex);
                                return EmptyCell;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return (cnt == 0)? non_case : Ok;
    }
    private boolean check_setCell = false;
    public boolean solve()
    {
        if(!check_setCell)
        {
            Set_Cell();
            check_setCell = true;
        }

        if(count == Sudoku.SIZE*Sudoku.SIZE) return true;
        int SureNum = Set_SureNum();
        int OnlyNum = Set_OnlyNum();
        if(SureNum == EmptyCell || OnlyNum == EmptyCell) return false;
        else {
            //use 2 rules of Sudoku
            if (SureNum == non_case && OnlyNum == non_case) {
                //add code
                // when we can't use rules of Sudoku
                //use backtrack
                for (int i = 0; i < Sudoku.SIZE * Sudoku.SIZE; i++) {
                    if (grid[i / Sudoku.SIZE][i % Sudoku.SIZE] == 0) {
                        if(NumOfCell[i] == 0) return false;
                        for (int j = 1; j <= Sudoku.SIZE; j++) {
                            if (get_NumIndex(i, j)) {
                                boolean[] cpy_numIndex = new boolean[Sudoku.SIZE];
                                System.arraycopy(Num_Index[i], 0, cpy_numIndex, 0, Sudoku.SIZE);
                                setGrid(j, i / Sudoku.SIZE, i % Sudoku.SIZE);
                                if (!solve()) {
                                    undo_EmptyCell(i / Sudoku.SIZE, i % Sudoku.SIZE, cpy_numIndex);
                                } else return true;
                            }
                        }
                    }
                }
                return false;
            }
            else return solve();
        }
    }
    public int[] get_NumOfCell(int x,int y)
    {
        if(grid[x][y] != 0) return null;
        int index = hash_indexGrid(x,y);
        int[] arr = new int[Sudoku.SIZE];
        int j = 0;
        for(int i = 1; i <= Sudoku.SIZE; i++ )
        {
            if(get_CheckNumOfCell(i,index))
            {
                arr[j] = i;
                j ++;
            }
        }
        int[] newArr = new int[j];
        System.arraycopy(arr,0,newArr,0,j);
        return newArr;
    }
    public int[][] getGrid()
    {
        return grid;
    }
    public boolean get_NumIndex(int index_cell,int num)
    {
        return Num_Index[index_cell][num-1];
    }
    public void undo_EmptyCell(int x,int y,boolean[] numIndex)
    {
        if(grid[x][y] == 0 ) return;

        int num = grid[x][y];
        grid[x][y] = 0;
        //fix rows , cols , square

        //set check
        set_checkSquare(num,getIndex_Square(x,y),false);
        set_checkCols(num,y,false);
        set_checkRows(num,x,false);

        // cells of square row col don't have this num

        for(int i = 0; i < Sudoku.SIZE; i++)
        {
            //cols
            if(!get_checkRows(num,i) && !get_checkSquare(num,getIndex_Square(i,y))) {
                set_CheckNumOfCell(num,hash_indexGrid(i,y),true);
            }
            //rows
            if(!get_checkCols(num,i) && !get_checkSquare(num,getIndex_Square(x,i))) {
                set_CheckNumOfCell(num, hash_indexGrid(x, i), true);
            }
        }
        //square
        int index_square = getIndex_Square(x,y);
        for(int i = 0; i < Sudoku.SIZE_SQUARE; i++)
        {
            for(int j = 0; j < Sudoku.SIZE_SQUARE; j++)
            {
                if(!get_checkCols(num,getIndex_cols(j,index_square)) && !get_checkRows(num,getIndex_rows(i,index_square))) {
                    set_CheckNumOfCell(num, hash_indexGrid(getIndex_rows(i, index_square), getIndex_cols(j, index_square)), true);
                }
            }
        }
        //undo valid num of cell
        for(int j = 0; j < Sudoku.SIZE; j++)
        {
            if(numIndex[j])
            {
                set_CheckNumOfCell(j+1,hash_indexGrid(x,y),true);
            }
        }
        count--;
    }
    public boolean[] get_NumIndex(int indexCell)
    {
        return Num_Index[indexCell];
    }
}
