class Solution {
    public int maxRepeating(String sequence, String word) {
        int m = sequence.length();
        int n = word.length();
        int maxCount = m / n;
        int[][] dp = new int[m + 1][maxCount + 1];
        return helper(sequence, word, 0, 0, dp);
    }
    public int helper(String sequence, String word, int start, int count, int[][] dp) {
        int m = sequence.length();
        int n = word.length();
        if (start + n > m) {
            return count;
        }
        if (dp[start][count] != 0) {
            return dp[start][count];
        }
        int skip = helper(sequence, word, start + 1, 0, dp);
        int ans = Math.max(count, skip);
        if (sequence.startsWith(word, start)) {
            int take = helper(sequence, word,  start + n, count + 1, dp);
            ans = Math.max(ans, take);
        }
        dp[start][count] = ans;
        return ans;
    }
}
