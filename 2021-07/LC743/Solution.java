package LC743;

import java.util.Arrays;

class Solution {
    int INF = 0x3f3f3f3f;
    public int networkDelayTime(int[][] times, int n, int k) {
        int m = times.length; // m条边
        // 记录哪些点已经被更新过
        boolean[] visited = new boolean[n];
        // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
        int[] distance = new int[n];
        Arrays.fill(visited, false);
        Arrays.fill(distance, INF);
        distance[k-1] = 0;
        // 初始化邻接矩阵
        int[][] w = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = i == j ? 0 : INF;
            }
        }
        for (int i = 0; i < m; i++) {
            w[times[i][0]-1][times[i][1]-1] = times[i][2];
        }
        // D算法
        for (int i = 0; i < n; i++) { // 进行n轮：找到最小的未被更新结点l作为中继节点
            int l = -1;
            for (int j = 0; j < n; j++) {
                // 找到l
                if (!visited[j] && (l == -1 || distance[j] < distance[l])) l = j;
            } visited[l] = true;
            for (int j = 0; j < n; j++) {
                // 更新经过l的路径
                distance[j] = Math.min(distance[j], distance[l] + w[l][j]);
            }
        }
        int max = -1;
        for (int i : distance) {
            max = Math.max(max, i);
        } return max >= INF ? -1 : max;
    }public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(new Solution().networkDelayTime(times, n, k));
    }
}
