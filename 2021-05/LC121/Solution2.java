package LC121;

// 更优的dp
// 为什么会比使用数组快很多
class Solution2 {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int mincost = prices[0];
        for (int price : prices) {
            if (mincost > price) {
                mincost = price;
            }
            maxprofit = Math.max(price - mincost, maxprofit);
        }
        return maxprofit;
    }
}
