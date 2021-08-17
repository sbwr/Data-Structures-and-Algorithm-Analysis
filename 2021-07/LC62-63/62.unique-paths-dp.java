package LC62;

/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) // 只有一行或一列，则只有一种路线
            return 1;
        // 暴力递归只需一行但是会超时
        // return uniquePaths(m-1, n) + uniquePaths(m, n-1);
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 7));
    }
}
// @lc code=end