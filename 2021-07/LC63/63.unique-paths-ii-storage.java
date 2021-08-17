package LC63;
/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
/**空间优化版
 * 考虑不额外用到dp数组的情况
 */
class Solution { 
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;   // 单独考虑起点、终点不可达的情况
        
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                else if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                }
                else { //(obstacleGrid[i][j] == 0) 
                    int upper = i > 0 ? obstacleGrid[i-1][j] : 0;
                    int left = j > 0 ? obstacleGrid[i][j-1] : 0;
                    obstacleGrid[i][j] = upper + left;
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(s.uniquePathsWithObstacles(nums));
    }
}
// @lc code=end
