package LC502;

import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length, INF = 0x3f3f3f3f;
        int[][] netPrft = new int[len][2];
        for (int i = 0; i < len; i++) {
            netPrft[i][0] = profits[i];
            netPrft[i][1] = capital[i];
        }
        // 按成本从小到大排序, 相同成本则按利润反序.
        Arrays.sort(netPrft, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < len && k > 0; i--) {
            if (w >= netPrft[i][1]) {
                w += netPrft[i][0];
                netPrft[i][1] = INF;
                k--;
            }
        }
        return w;
    }

    public static void main(String[] args) {
        int k, w;
        k = 3;
        w = 1;
        int[] profits = { 1, 2, 3, 4, 5 };
        int[] capital = { 0, 1, 2, 2, 3 };
        System.out.println(new Solution().findMaximizedCapital(k, w, profits, capital));
    }
}
