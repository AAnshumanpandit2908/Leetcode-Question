class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        return helper(m , n , s , p);
    }
    public boolean helper (int m , int n , String s , String p){
        if(m == 0 && n == 0){
            return true;
        }
           if(n == 0){
            return false;
        }
        if (n >= 2 && p.charAt(n - 1) == '*') {
            boolean zero = helper(m, n - 2, s, p);
            boolean oneOrMore = false;
            if (m > 0 && (s.charAt(m - 1) == p.charAt(n - 2) || p.charAt(n - 2) == '.')) {
                oneOrMore = helper(m - 1, n, s, p);
            }
            return zero || oneOrMore;
        }
         if (m > 0 && (s.charAt(m - 1) == p.charAt(n - 1) ||p.charAt(n - 1) == '.')) {
            return helper(m - 1, n - 1, s, p);
        }
        return false;
    }
}