class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length() + 1][s.length() + 1];
        return helper(s, 0, 0, dp);
    }
    public boolean helper(String s, int i, int count, Boolean[][] dp) {
        if (count < 0) {
            return false;
        }
        if (i == s.length()) {
            return count == 0;
        }
        if (dp[i][count] != null) {
            return dp[i][count];
        }
        char ch = s.charAt(i);
        if (ch == '(') {
            return dp[i][count] = helper(s, i + 1, count + 1, dp);
        }
        if (ch == ')') {
            return dp[i][count] = helper(s, i + 1, count - 1, dp);
        }
        dp[i][count] = helper(s, i + 1, count + 1, dp)|| helper(s, i + 1, count - 1, dp)|| helper(s, i + 1, count, dp);

        return dp[i][count];
    }
}