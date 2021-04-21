package LC123;

class Solution1 {
    // start end 为起止下标 包含在数组内
    private static int single(int[] prices, int start, int end) {
        if(start >= end) return 0;
        int len = end - start + 1;
        int[] maxprofit = new int[len];
        for (int i = start; i <= end; i++) {
            for(int j = i + 1; j <= end; j++) {
                int profit = prices[j] - prices[i];
                if(profit > maxprofit[i-start]) {
                    maxprofit[i-start] = profit;
                }
            }
        }
        int max = maxprofit[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, maxprofit[i]);
        }
        return max;
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        int max = 0;
        // 该循环内存在重复冗余的计算
        for(int i = 0; i < len; i++) {
            max = Math.max(max, single(prices, 0, i) 
            + single(prices, i+1, len-1));
        }
        return max;
    }
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int nums[] = {3,3,5,0,0,3,7,1,4};
        System.out.println(s.maxProfit(nums));
    }
}
