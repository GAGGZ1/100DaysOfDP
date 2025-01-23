class Solution {
    int[][]memo;
    public int findTargetSumWays(int[] nums, int target) {
        int targetsum=0;
        for(int i=0;i<nums.length;i++){
            targetsum+=nums[i];
        }
       memo=new int[nums.length][2*targetsum+1];
        for(int []arr:memo){
            Arrays.fill(arr,-1);
        }
        return solve(nums,target,0,0,targetsum);
    }
    public int solve(int[]nums,int target,int i,int currsum,int offset){
        if(i==nums.length){
            if(currsum==target){
                return 1;
            }
            return 0;
        }
        if(memo[i][currsum+offset]!=-1){
            return memo[i][currsum+offset];
        }
        int add=solve(nums,target,i+1,currsum+nums[i],offset);

        int sum=solve(nums,target,i+1,currsum-nums[i],offset);
        return memo[i][currsum+offset]= add+sum;
    }
}
