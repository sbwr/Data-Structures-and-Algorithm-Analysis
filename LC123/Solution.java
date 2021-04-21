package LC123;

class Solution {
    // start end 为起止下标 包含在数组内
    private int single(int[] prices, int start, int end) {
        if(start >= end) return 0;
        int len = end - start + 1;
        int[] maxprofit = new int[len];
        for (int i = start; i <= end; i++) {
            for(int j = i; i <= end; j++) {
                int profit = prices[j] - prices[i];
                if(profit > maxprofit[i]) {
                    maxprofit[i] = profit;
                }
            }
        }
        int max = maxprofit[start];
        for (int i = start + 1; i <= end; i++) {
            max = Math.max(max, maxprofit[i]);
        }
        return max;
    }
    public int maxProfit(int[] prices) {

    }
}
