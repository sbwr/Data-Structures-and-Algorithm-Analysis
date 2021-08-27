package LC16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length, ans, i, j, k;
        Arrays.sort(nums);
        ans = nums[0] + nums[1] + nums[2];
        for (i = 0; i < len - 2; i++) {
            j = i + 1;
            k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k], diff1 = sum - target, diff2 = Math.abs(ans - target);
                if (diff1 == 0) return target;
                if (diff1 >= 0 && diff1 < diff2 || diff1 < 0 && -diff1 < diff2) { // |diff1| < |diff2|
                    ans = sum;
                }
                if (diff1 > 0) // sum过大
                    k--;
                else // sum<target
                    j++; // <0
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,2,1,-3};
        int target = 1;
        s.threeSumClosest(nums, target);
    }
}