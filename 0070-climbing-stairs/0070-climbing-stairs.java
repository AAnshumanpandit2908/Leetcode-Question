class Solution {
    public int climbStairs(int n) {
        Integer[]dp = new Integer[n+1];
        return helper(n , dp);
    }
    public int helper(int n , Integer[] dp){
        if(n <= 1){
            return 1 ;
        }
        if(dp[n] != null){
            return dp[n];
        }
        int oneStep = helper(n-1 ,dp);
        int twoStep = helper(n-2 , dp);

        dp[n] = oneStep + twoStep;
        return dp[n];

    }
}