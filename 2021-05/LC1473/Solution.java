package LC1473;

/**
 * bug1：使用二维数组滚动更新时没有考虑到数组更新顺序
 */

public class Solution {
    public static int minCost(int[] h, int[][] cost, int m, int n, int target) {
        final int INF = 0x3f3f3f3f;
        int[][] dp = new int [n][target+1]; 
        for (int j=0; j<n; j++) {
                dp[j][0] = INF; // 初始化
            for (int k=0; k<target; k++) {
            }
        }
        for (int i=0; i<m; i++){
            /************遍历到的房子已涂色**************/
            if (h[i] != 0){ // 
                for (int j=0; j<n; j++){
                    if (j == h[i]-1){
                        for (int k=1; k<=target; k++){ // k=0时不需要比较
                            if (k > i+1){ // k>i即街区数大于房屋数不可能发生
                                dp[j][k] = INF;
                                continue;
                            }
                            // 比较前一轮的dp[j][k]和所有dp[p][k-1] (p!=j), 其中的最小值为新的dp[j][k]
                            // dp[j][k] = dp[j][k];
                            for (int p=0; p<n; p++){
                                if (p == j)continue;
                                dp[j][k] = Math.min(dp[j][k], dp[p][k-1]);
                            }
                        }   
                    }
                }
                for (int j=0; j<n; j++){
                    if (j != h[i]-1) { // 所有非h[i]颜色情况不可达
                        for (int k=0; k<=target; k++){
                            dp[j][k] = INF;
                        }
                    }
                }
            }/********************************************/
                    

            /************ 遍历到的房子未涂色 **************/
            // h[i] = 0
            else {
                for (int j=0; j<n; j++){
                    for (int k=1; k<=target; k++){
                        if (k > i+1){ // k>i即街区数大于房屋数不可能发生
                            dp[j][k] = INF;
                            continue;
                        }
                        // bug：此处的参量在这一轮i循环中被修改过！！
                        for(int q=0; q<n; q++){
                            dp[j][k] = Math.min(dp[j][k], dp[q][k-1]);
                        }
                        dp[j][k] += cost[i][j];
                    }
                }
            }
        }
        int ans = INF;
        for (int j=0; j<n; j++) {
            ans = Math.min(ans, dp[j][target]);
        }
        return ans == INF ? -1 : ans;
    }
    public static void main(String[] args) {
        int[] houses = {0,0,0,0,0}; int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}}; int m = 5; int n = 2; int target = 3;
        System.out.println(minCost(houses, cost, m, n, target));
    }
}
