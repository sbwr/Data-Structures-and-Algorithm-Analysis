package Contest.Contest255.contest3;

public class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = target = mat[0][i];
        }
        return 0;
    }
}
