package LC70;

// 爬楼梯/跳台阶 问题
public class Solution {
    public static int climbStairs2(int n) {
        if(n < 0) return 0;
        if(n == 1 || n == 0) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }
    public static int climbStairs(int n){
        if(n < 0) return 0;
        if(n == 1 || n == 0) return 1;
        int[] dp = new int[3];
        dp[0] = 1; dp[1] = 1; // 到第i级台阶的方法数滚动存放在dp[i]中
        for(int i = 2; i <= n; i++){
            dp[i%3] = dp[(i-1)%3] + dp[(i-2)%3];
        }
        return dp[n%3];
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(100));
    }
}
