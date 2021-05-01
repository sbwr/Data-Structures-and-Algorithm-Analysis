package LC347;

// 参考力扣代码链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> times = new HashMap<Integer, Integer>();
        for (int i : nums) {
            times.put(i, times.getOrDefault(i, 0)+1); // getOrDefault() 省去判断是否为null
        }
        PriorityQueue<int[]> order = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (int key : times.keySet()) { // 将数据排列入优先队列
            // System.out.println(key);
            if(order.size() < k){
                order.add(new int[]{key, times.get(key)}); // 为什么一定要new int
            }
            else{
                if(order.peek()[1] < times.get(key)){
                    order.poll();
                    order.add(new int[]{key, times.get(key)});
                }
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = order.poll()[0];
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        Solution s = new Solution();
        nums = s.topKFrequent(nums, 2);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}