class Solution {
     int maxLen = 0;
     int start = 0;
    public String longestPalindrome(String s) {
        for(int i = 0 ; i < s.length(); i++){
            expand(s , i , i);
            expand(s, i , i+1);

        }
       return s.substring(start , start + maxLen);

    }
    void expand (String s , int left , int right){
        if(left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)){
            return;
        }
        int len = right - left +1;
        if(len > maxLen){
            maxLen = len;
            start = left;
        }
        expand (s,left-1 , right+1);

    }
}