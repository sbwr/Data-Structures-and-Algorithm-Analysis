package LC123;

class Solution2 {
    // 利用动态规划计算所有需要考虑的单次买卖的情况。
    // 参数为股票价格 length>=2;
    // 返回[2][length-1]数组
    // 第一行第i+1列(即0,i位置)表示[0, i+1]区间（前区间）内单次交易最大结果；
    // 第二行第i+1列(1,i位置)表示[i, length-1]区间（后区间）内单次交易最大结果.
    private int[][] Single(int[] prices){
        int len = prices.length;
        int[][] profit = new int[2][len-1];
        int max = 0;
        // 前区间[0, i]
        for(int i = 1; i <= len-1; i++){
            // max = 0; // 删去，max不应归0，而应该不断记忆上一个计算结果以实现bp。
            for(int j = 0; j < i; j++){
                int thisprofit = prices[i] - prices[j];
                max = Math.max(max, thisprofit);
            }
            profit[0][i-1] = max;
        }
        // 从后往前求后区间
        max = 0;
        for(int i = len-2; i >= 0; i--){
            for(int j = len-1; j > i; j--){
                int thisprofit = prices[j] - prices[i];
                max = Math.max(max, thisprofit);
            }
            profit[1][i] = max;
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int max = 0, len = prices.length - 1;
        if(len < 0) return 0; // 单独考虑0个数情况
        int[][] profit = Single(prices);
        if(len == 1) return profit[0][0];// bug修复
        for (int i = 0; i < len-1; i ++) {
            max = Math.max(max, profit[0][i] + profit[1][i+1]);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int nums[] = {3,3,5,0,0,3,1,4};
        System.out.println(s.maxProfit(nums));
    }
}
