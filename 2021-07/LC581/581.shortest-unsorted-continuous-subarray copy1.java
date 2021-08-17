package LC581;

/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution0 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1)
            return 0;
        int i = 0, j = nums.length - 1, h = -1, r = -1;
        while (i < j) {
            if (nums[i] > nums[j]) {
                h = h > i || h == -1 ? i : h;
                r = r < j || r == -1 ? j : r;
                break;
            } else if (nums[i] > nums[i + 1]) {
                h = h > i || h == -1 ? i : h;
            }
            i++;
            if (nums[i] > nums[j]) {
                h = h > i || h == -1 ? i : h;
                r = r < j || r == -1 ? j : r;
                break;
            } else if (nums[j] < nums[j - 1]) {
                r = r < j || r == -1 ? j : r;
            }
            j--;
        }
        return r == -1 && h == -1 ? 
            0 : r == -1 || h == -1 ? 
            2 : r - h + 1;
    }
    
}
// @lc code=end
