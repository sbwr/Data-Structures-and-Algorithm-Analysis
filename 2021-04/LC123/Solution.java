package LC123;

class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = prices[0], sell1 = 0, buy2 = prices[0], sell2 = 0;
        for (int i : prices) {
            buy1 = Math.min(buy1, i); // buy1的物理意义为第一次买花的钱
            sell1 = Math.max(sell1, i - buy1); // sell1的物理意义为第一次卖时赚的钱
            buy2 = Math.min(buy2, i - sell1); // buy2为第二次买时累计花的钱（赚的钱的相反数）
            sell2 = Math.max(sell2, i - buy2); // sell2为第二次卖时累计赚的钱
        }
        return Math.max(sell1, sell2);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int nums[] = {3,3,5,0,0,3,1,4};
        System.out.println(s.maxProfit(nums));
    }
}
