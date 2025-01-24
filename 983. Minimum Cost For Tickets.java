class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int [] dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int first=costs[0]+dp[i+1];
            int j=i;
            while(j<days.length && days[j]<days[i]+7){
                j++;
            }
            int seven=costs[1]+dp[j];
            int k=i;
            while(k<days.length && days[k]<days[i]+30){
                k++;
            }
            int last=costs[2]+dp[k];
            dp[i]=Math.min(Math.min(first,last),seven);
        }
        return dp[0];
    }



    ///=======.  ////===
    //  public int mincostTickets(int[] days, int[] costs) {
    //     int[]memo=new int[days.length];
    //     Arrays.fill(memo,-1);
    //     return solve(days,costs,0,memo);
    // }
    // public int solve(int[] days,int[] costs,int i,int []memo){
    //     if(i>=days.length)return 0;
    //     if(memo[i]!=-1){
    //         return memo[i];
    //     }
    //     int first=costs[0]+solve(days,costs,i+1,memo);
    //     int j=i;
    //     while(j<days.length && days[j]<days[i]+7){
    //         j++;
    //     }
    //     int seven=costs[1]+solve(days,costs,j,memo);
    //     int k=i;
    //     while(k<days.length && days[k]<days[i]+30){
    //         k++;
    //     }
    //     int last=costs[2]+solve(days,costs,k,memo);

    //     memo[i]= Math.min(Math.min(first,seven),last);
    //     return memo[i];
    // }
}
