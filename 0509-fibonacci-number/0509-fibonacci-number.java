class Solution {
    public int fib(int n) {
        Integer [] dp = new Integer[n+1];
        return helper(n ,dp);
    }
    public int helper(int n , Integer[] dp){
        if(n==0 || n == 1){
            return n;
        }
        if(dp[n] != null){
            return dp[n];
        }
        dp[n] =  helper(n-1 , dp) + helper(n-2 , dp);
        return dp[n];
    }
}