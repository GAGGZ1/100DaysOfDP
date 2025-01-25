class Solution {
    // minSquares reuired are :-
    int minSquares = Integer.MAX_VALUE;
    public int tilingRectangle(int n, int m) {
        // n=> number of rows and m=> number of columns 
        // greedy will get fail in this question  : try example 3
        if(m == n) return 1; // agar wo pehle se hi square hai toh single square se hi fill ho jaayega 
        // i am making the matrix to store  an important information of about which cell is covered by a rectangle and which is not 
        boolean[][] grid = new boolean[n][m]; // agar koi cell pehle se hi kisi rectangle k andar count ho rahaa hogaa toh uss cell ki value true hogii warna uss particular cell ki value false hogii
        solve(grid,n,m,0); // 0 represents the number of squares used till now 
        return minSquares;
    }
    public void solve(boolean[][] grid, int n, int m, int squaresUsed){
        // base condition 1 : 
        // agar kisi method no. of suares used jyaada ho jaate hai minSquare se toh uss tareeke se filling karna toh bekaar hi hogaa => so directly return 
        if(squaresUsed >= minSquares) return; // ussey chotaa answer toh humein pehle hi mill chukaa hai
        // base condition 2 :  agar poori grid pehle se hi bhar gayi ho ? then, no more squares are required to fill it 
        if( isGridFilled(grid) ){
            minSquares = Math.min(minSquares,squaresUsed) ;
            return;
        }
        // finding the first unfilled place 
        int[] unfilledCell = findUnfilledCell(grid);
        int row = unfilledCell[0];
        int col = unfilledCell[1];
        // try to fill it with all of the possible squares 
        // let us be greedy about this : try with the largest possible square 
        for(int size = Math.min(n-row,m-col);size>=1;size--){
            if(isPossibleToFitSquare(grid,row,col,size)){
                placeSquare(grid,row,col,size);
                solve(grid,n,m,squaresUsed+1); // ek square abhi abhi place kiya hai 
                unplaceSquare(grid,row,col,size);
            }
        }
        return;
    } 
    public boolean isGridFilled(boolean[][] grid){
        for(boolean[] row : grid){
            for(boolean val : row){
                if(!val) return false;
            }
        }
        return true;
    }
    public boolean isPossibleToFitSquare(boolean[][] grid, int row, int col, int size){
       
        for(int i=row;i<=row+size-1;i++){
            for(int j=col;j<=col+size-1;j++){
                if(grid[i][j]) return false;
            }
        }
        return true;
    }
    public void placeSquare(boolean[][] grid, int row, int col, int size){
        for(int i=row;i<=row+size-1;i++){
            for(int j=col;j<=col+size-1;j++){
                grid[i][j] = true;
            }
        }
    }
     public void unplaceSquare(boolean[][] grid, int row, int col, int size){
        for(int i=row;i<=row+size-1;i++){
            for(int j=col;j<=col+size-1;j++){
                grid[i][j] = false;
            }
        }
    }
    public int[] findUnfilledCell(boolean[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!grid[i][j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
