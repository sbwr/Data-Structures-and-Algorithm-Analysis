package LC1104;

import java.util.*;

class Solution {
    private List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> pathInZigZagTree(int label) {
        int n = 0; // label大于2的n次幂，小于n+1次幂，即在第n层
        for (int tmp = label; tmp > 1; tmp /= 2)
            n++;
        if (label != 1)
            parent(label, n);
        ans.add(label);
        return ans;
    }

    /** 获取label的父结点 */
    private void parent(int label, int n) {
        int parent, tmp;
        tmp = (int) Math.pow(2, n);
        parent = tmp - (label - tmp) / 2 - 1;
        if (parent != 1)
            parent(parent, n - 1);
        ans.add(parent);
    }
}