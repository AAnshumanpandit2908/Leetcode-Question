class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean [] dp = new Boolean[s.length()];
        return helper(s , wordDict , 0 , dp);
    }
    public boolean helper(String s , List<String> wordDict , int index , Boolean [] dp){
        if(index == s.length()){
            return true;
        }
        if(dp[index] != null){
            return dp[index];
        }
        for(int i = index+1 ; i <=s.length() ; i++){
            String word = s.substring(index , i);

            if(wordDict.contains(word)){
                if(helper(s , wordDict , i ,dp)){
                    return true;
                }
            }
        }
        return dp[index] = false;

    }
}