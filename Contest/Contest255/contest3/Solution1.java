package Contest.Contest255.contest3;

class Solution1 {
    public int minimizeTheDifference(int[][] mat, int target) {
        return dfs(mat, target, 0);
    }

    private int dfs(int[][] mat, int target, int start) {
        int m = mat.length, n = mat[0].length, diff = Math.abs(target - mat[start][0]);
        if (start == m - 1) { // last row
            for (int i = 1; i < n; i++) {
                diff = Math.min(diff, Math.abs(target - mat[start][i]));
            }
        } else {
            diff = dfs(mat, target - mat[start][0], start + 1);
            for (int i = 1; i < n; i++) {
                diff = Math.min(diff, dfs(mat, target - mat[start][i], start + 1));
            }
        }
        return Math.abs(diff);
    }
}