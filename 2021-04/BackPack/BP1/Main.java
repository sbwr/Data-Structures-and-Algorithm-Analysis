package BackPack.BP1;
// 逻辑与Main1 中的 maxValue() 方法相同，区别在使用ArrayList存储，适合大数据量。
import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    static class ValueHolder{
        int v,w;
        public ValueHolder(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for (int i = 0; i < N; i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(maxValue(N, V, v, w));
    }
    private static int maxValue(int N, int V, int[] v, int[] w){
        if (N == 0 || V == 0) return 0;
        int[] dp = new int[V+1];
        ArrayList<ValueHolder> list = new ArrayList<>();
        for (int i = 0; i < N; i++){ // 外循环从0开始递增
            list.add(new ValueHolder(v[i], w[i]));
        }
        for (ValueHolder holder : list){ 
            for (int j = V; j >= holder.v; j--){ // 内循环从V开始递减
                dp[j] = Math.max(dp[j], dp[j - holder.v] + holder.w);
            }
        }
        return dp[V];
    }
}

