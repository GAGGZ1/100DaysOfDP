class Solution {
    int dp[]=new int[50];
    public int minExtraChar(String s, String[] dict) {
        HashSet<String> set=new HashSet<>(Arrays.asList(dict));
        Arrays.fill(dp,-1);
        return helper(s,set,0);
    }
    public int helper(String s,HashSet<String>dict,int idx){
        if(idx==s.length()){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        StringBuilder sb=new StringBuilder();
        int minChar=Integer.MAX_VALUE;
        for(int i=idx;i<s.length();i++){
            sb.append(s.charAt(i));
            int extraChar=0;
            if(!dict.contains(sb.toString())){
                extraChar=sb.length();
            }
            int currExtra=helper(s,dict,i+1);
            minChar=Math.min(minChar,extraChar+currExtra);
        }
        return dp[idx]=minChar;
    }
}
