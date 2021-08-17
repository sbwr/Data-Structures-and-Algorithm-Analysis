package LC63;
/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1]; // 0号的行、列为哨兵
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;   // 单独考虑起点、终点不可达的情况
        else
            dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1)
                    continue;
                else if (obstacleGrid[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end
