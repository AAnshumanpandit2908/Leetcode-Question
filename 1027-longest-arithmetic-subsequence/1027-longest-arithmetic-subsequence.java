class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int ans = 1;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j < i ; j++){
                int diff = nums[i] - nums[j];
                dp[i][diff + 500] = dp[j][diff+500]+1;
                ans = Math.max(ans , dp[i][diff+500]);
            }
        }
        return ans+1;
    }
}