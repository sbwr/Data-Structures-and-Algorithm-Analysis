package LC121;

// dynamic planning
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 记录截止至每天时 [已购入(0)/已售出(1)] 状态下可以获得的最大利润/最小花费
        // prices[i] <-> dp[i+1][], dp[0]为哨兵位
        int[][] dp = new int[len+1][2];
        dp[0][0] = -999999; // 设置初始值为负无穷
        for (int i=1; i<=len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i-1]);
            // 比较 [最优购买情况下第i天卖掉，第i天前已卖掉]
            dp[i][1] = Math.max(dp[i-1][0]+prices[i-1], dp[i-1][1]);
        }
        return dp[len][1];
    }
}
