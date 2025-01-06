class Solution {
    double[][][]dp;
    int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        dp=new double[n+1][n+1][k+1];
        for(double [][]d:dp){
            for(double[] a: d){
                Arrays.fill(a,-1);
            }
        }
        return solve(n,k,row,column);
    }
    public double solve(int n,int k,int r,int c){
        if(r<0 || c<0 || r>=n || c>=n ){
            return 0;
        }
        if(k==0){
            return 1;
        }
        if(dp[r][c][k]!=-1){
            return dp[r][c][k];
        }

        double ans=0;
        for(int[] a: moves){
            int nr=a[0]+r;
            int nc=a[1]+c;
            ans+=solve(n,k-1,nr,nc);
        }
        return dp[r][c][k]= (double)(ans/8);
    }
}
