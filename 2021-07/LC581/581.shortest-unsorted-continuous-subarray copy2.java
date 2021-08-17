package LC581;

/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution1 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1)
            return 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            Boolean flag = false;
            if (nums[i] <= nums[j] && nums[i] <= nums[i + 1]) {
                i++;
                flag = true;
            }
            if (nums[i] <= nums[j] && nums[j] >= nums[j - 1]) {
                j--;
            } else if (flag == false) {// i, j均无变化
                break;
            }
        }
        return i==j? 0 : j-i+1;
    }
}
// @lc code=end
