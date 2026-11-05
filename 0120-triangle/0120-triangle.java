class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n]; 
       return helper(0, 0, triangle, dp);
    }
    public int helper(int i, int j, List<List<Integer>> triangle,Integer[][] dp) {   
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int down = helper(i + 1, j, triangle, dp);
        int diagonal = helper(i + 1, j + 1, triangle, dp);
        dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
        return dp[i][j];
    }
}