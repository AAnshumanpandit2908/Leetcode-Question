class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return Math.min(helper(cost ,0 , dp) , helper(cost , 1 , dp));
    }
    public int helper(int []cost , int i , int[] dp){
        if(i >= cost.length ){
            return 0 ;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int oneStep =  helper(cost , i+1 , dp) ;
        int twoStep =  helper(cost , i+2 , dp) ;
        
        dp[i] = cost[i] + Math.min(oneStep , twoStep);
        return dp[i];
    }
}