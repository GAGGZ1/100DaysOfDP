class Solution { 
    double memo[][];
    public double soupServings(int n) {
        if(n>5000){
            return 1;
        }
        memo=new double[n+1][n+1];
        for(double []a:memo){
            Arrays.fill(a,-1);
        }
        return solve(n,n);
    }
    public double solve(int a,int b){
        if(a<=0 && b<=0){
        return 0.5;
    }
    if(a<=0){
        return 1.0;
    }
    
    if(b<=0){
        return 0;
    }
    if(memo[a][b]!=-1){
        return memo[a][b];
    }
    double p1=solve(a-100, b-0);
    double p2=solve(a-75, b-25);
    double p3=solve(a-50, b-50);
    double p4=solve(a-25, b-75);
    return memo[a][b]=(0.25)*(p1+p2+p3+p4);
}}
