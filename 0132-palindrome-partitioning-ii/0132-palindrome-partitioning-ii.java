class Solution {
    public int minCut(String s) {
        int [] dp = new int[s.length()];
        Arrays.fill(dp , -1);
        return helper(0 , s , dp)-1;
    }
    public int helper(int start , String s , int[] dp){
        if(start == s.length()){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        if(dp[start] != -1){
            return dp[start];
        }
        for(int end = start ; end < s.length() ; end++){
            if(isPalindrome(s.substring(start , end+1))){
                ans = Math.min(ans , 1+helper(end+1 , s , dp));
            }
        }
        return dp[start] = ans;
    }
    public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        i++;
        j--;
    }

    return true;
}
}