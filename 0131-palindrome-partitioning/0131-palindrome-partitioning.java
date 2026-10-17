import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        solve(0, 0, s, path, ans);
        return ans;
    }

    public void solve(int start, int end, String s,
                      List<String> path,
                      List<List<String>> ans) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (end == s.length()) {
            return;
        }

        if (isPalindrome(s, start, end)) {
            path.add(s.substring(start, end + 1));

            solve(end + 1, end + 1, s, path, ans);

            path.remove(path.size() - 1);
        }

        solve(start, end + 1, s, path, ans);
    }

    public boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindrome(s, left + 1, right - 1);
    }
}