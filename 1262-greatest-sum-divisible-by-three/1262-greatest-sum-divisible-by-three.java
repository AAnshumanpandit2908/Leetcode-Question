class Solution {
    public int maxSumDivThree(int[] nums) {
        Integer[][] dp = new Integer[nums.length][3];
        return solve(0, 0, nums ,dp);
    }
    public int solve(int i, int rem, int[] nums , Integer[][] dp) {
        if (i == nums.length) {
            return rem == 0 ? 0 : -1000000000;
        }
        if(dp[i][rem] != null){
            return dp[i][rem];
        }
        int notTake = solve(i + 1, rem, nums , dp);
        int newRem = (rem + nums[i]) % 3;
        int take = nums[i] + solve(i + 1, newRem, nums , dp);

          dp[i][rem] = Math.max(take, notTake);
          return dp[i][rem];
    }
}