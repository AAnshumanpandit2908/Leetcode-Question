class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxVal = 0;
        for (int[] row : grid) {
            for (int val : row) {
                maxVal = Math.max(maxVal, val);
            }
        }
        int bits = 32 - Integer.numberOfLeadingZeros(maxVal);
        int limit = 1 << bits;
        boolean[][] dp = new boolean[m * n][limit];
        dp[0][grid[0][0]] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int idx = i * n + j;
                int val = grid[i][j];
                if (i > 0) {
                    for (int x = 0; x < limit; x++) {
                        if (dp[idx - n][x]) {
                            dp[idx][x ^ val] = true;
                        }
                    }
                }
                if (j > 0) {
                    for (int x = 0; x < limit; x++) {
                        if (dp[idx - 1][x]) {
                            dp[idx][x ^ val] = true;
                        }
                    }
                }
            }
        }
        for (int x = 0; x < limit; x++) {
            if (dp[m * n - 1][x]) {
                return x;
            }
        }

        return 0;
    }
}