package Contest59.contest2;

class Solution {
    public int countPaths(int n, int[][] roads) {
        // int route = roads.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; dp[0][1] = 1; // 0长度，1种方法
        // 初始化dp
        for (int i = 1; i < n; i++) {
            dp[i][0] = 99999999;
        }
        dfs(roads, dp, 0);
        return dp[n-1][1];
    }
    private void dfs(int[][] roads, int[][] dp, int node){ // 从i结点出发
        int route = roads.length;
        for (int i = 0; i < route; i++) {
            if(roads[i][0] == node) {
                int time = (roads[i][2] + dp[node][0]) % 1000000007;
                if (time > dp[roads[i][1]][0]){
                    continue;
                }
                // 更新距离和路由数
                if (dp[roads[i][1]][0] > time){
                    dp[roads[i][1]][1] = 0;
                    dp[roads[i][1]][0] = time;
                }
                else {
                    dp[roads[i][1]][1] = (dp[roads[i][1]][1]+1) % 1000000007;
                }
                dfs(roads, dp, roads[i][1]);
            } if(roads[i][1] == node) {
                int time = (roads[i][2] + dp[node][0]) % 1000000007;
                if (time > dp[roads[i][0]][0]){
                    continue;
                }
                // 更新距离和路由数
                if (dp[roads[i][0]][0] > time){
                    dp[roads[i][0]][1] = 0;
                    dp[roads[i][0]][0] = time;
                }
                else {
                    dp[roads[i][0]][1] = (dp[roads[i][0]][1]+1) % 1000000007;
                }
                dfs(roads, dp, roads[i][0]);
            }
        }
    }
}