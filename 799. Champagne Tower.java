class Solution {
    public double champagneTower(int poured, int i, int j) {
        double dp[][]=new double[101][101];
        for(double[]d:dp){
            Arrays.fill(d,-1);
        }
        return Math.min(1.0,solve(poured,i,j,dp));
        
    }
    public double solve(int poured,int i,int j,double[][] dp){
        if(i<0 || j<0 || i<j){
            return 0;
        }
        if(i==0 && j==0){
            return poured;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        double left=(solve(poured, i-1, j-1,dp)-1)/2;
        double right=(solve(poured, i-1, j,dp)-1)/2;
        if(left<0){
            left=0;
        }
        if(right<0){
            right=0;
        }
        return dp[i][j]=left+right;
    }
}
