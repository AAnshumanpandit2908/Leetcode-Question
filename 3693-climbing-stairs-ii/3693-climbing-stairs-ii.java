class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(n, costs, 0 , dp);
    }
    public int helper(int n, int[] costs, int i , int[]dp) {
        if (i == n) {
           return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int oneStep = Integer.MAX_VALUE;
        int twoStep = Integer.MAX_VALUE;
        int threeStep = Integer.MAX_VALUE;
        if (i + 1 <= n) {
            oneStep = costs[i] + 1 + helper(n, costs, i + 1 ,dp);
        }
        if (i + 2 <= n) {
            twoStep = costs[i + 1] + 4 + helper(n, costs, i + 2 , dp);
        }
        if (i + 3 <= n) {
            threeStep = costs[i + 2] + 9 + helper(n, costs, i + 3 ,dp);
        }
        dp[i] = Math.min(oneStep, Math.min(twoStep, threeStep));
        return dp[i];
    }
}