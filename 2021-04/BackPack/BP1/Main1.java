package BackPack.BP1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), V = in.nextInt();
        int[] v = new int[N], w = new int[N];
        for(int i = 0; i < N; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        in.close();
        System.out.println(maxValue2(N, V, v, w));
    }
    private static int maxValue(int N, int V, int[] v, int[] w){
        if (N == 0 || V == 0) return 0;
        int[] dp = new int[V+1];
        for (int i = 0; i < N; i++){ // 外循环所有物品，从0开始递增
            for (int j = V; j >= v[i]; j--){ // 内循环每一个剩余空间量，从V开始递减
                dp[j] = Math.max(dp[j], dp[j-v[i]] + w[i]);
            }
        }
        return dp[V];
    }
    private static int maxValue2(int N, int V, int[] v, int[] w) {
        if (N == 0 || V == 0) return 0;
        int[][] dp = new int[N][V+1];
        for(int i = 0; i < N; i++){
            for(int j = v[i]; j <= V; j++){
                if(j == 0) continue;
                if(i == 0) dp[i][j] = w[i];
                // 选择装或不装物品i
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + w[i]);
                }
            }
        }
        return dp[N-1][V];
    }
}
