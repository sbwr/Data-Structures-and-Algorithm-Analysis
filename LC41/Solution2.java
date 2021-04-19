package LC41;

import java.util.HashMap;
// 正经哈希表
class Solution2 {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if(map.get(i) == null) return i;
        }
        return nums.length+1;
    }
}
