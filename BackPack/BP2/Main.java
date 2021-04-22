package BackPack.BP2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), V = in.nextInt();
        int[] v = new int[N], w = new int[N];
        for(int i = 0; i < N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        in.close();
        System.out.println(maxValue(N, V, v, w));
    }
    private static int maxValue(int N, int V, int[] v, int[] w) {
        if (N == 0 || V == 0) return 0;
        int[][] dp = new int[N+1][V+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= V; j++){ // j=0时dp全为0，j=1时开始考虑
                // if(i == 0) {
                //     if(j < v[i]) {
                //         dp[i][j] = w[i];
                //     }
                //     else {
                //         dp[i][j] = dp[i][j - v[i]] + w[i];
                //     }
                // }
                // // 选择装或不装物品i
                // else{
                    if(j < v[i-1])
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-v[i-1]] + w[i-1]);
                // }
            }
        }
        return dp[N-1][V];
    }
}
