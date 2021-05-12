package LC121;

class DFS { // 简单暴力DFS，超时
    public int maxProfit(int[] prices) {
        int last = prices.length-1;
        return buy(0, last, prices);
    }
    public static int buy(int num, int last, int[] prices) { // 输入num为当前的日期
        if(num>=last) return 0;
        return Math.max(sell(num+1, last, prices)-prices[num], buy(num+1, last, prices));
    }
    public static int sell(int num, int last, int[] prices) { // 在num、len中寻找高卖价
        if(num>=last) return 0;
        return Math.max(num, sell(num+1, last, prices));
    }
}