class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0); 
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                st.push(0); 
            } else {
                int top = st.pop();
                int newScore = (top == 0) ? 1 : 2 * top;
                st.push(st.pop() + newScore);
            }
        }
        return st.pop();
    }
}
