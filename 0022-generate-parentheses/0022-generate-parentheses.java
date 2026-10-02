class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll = new ArrayList<>();
        helper(n ,0 , 0 , "" , ll);
        return ll;
    }
    public void helper(int n , int open , int close , String str , List<String> ll){
        if(str.length() == 2*n){
            ll.add(str);
            return;
        }
        if(open < n){
            helper( n , open+1 , close , str + "(" , ll);
        }
        if(close < open){
            helper(n , open , close+1 , str + ")" , ll);

        }
    }
}