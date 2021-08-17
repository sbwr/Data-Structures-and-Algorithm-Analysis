package LC581;

/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1)
            return 0;
        int i = 0, j = nums.length - 1, k = 0;
        for (; i < j; i++) {
            if (nums[i] > nums[i + 1])
                break;
            else if (nums[i] == nums[i+1]) {
                for(k = i; k < j; k++){
                    // 出现连续的相同数字串，寻找其尾部
                    if (nums[k] == nums[i+1]) {
                        continue;
                    } else if (nums[k] > nums[i+1]) {
                        i = k-1;
                    } else {
                        // nums[k] < nums[i+1]
                        // i不变，保持为相等数列头
                    } break;
                }
                if(k == j) { // 相等数列直到整个数组尾部
                    i = j; 
                    break;
                }
                else if(i != k-1) break; // 相等数列后第一个数字更小，i则为相等数列头
            }
        }
        for (; i < j; j--) {
            if (nums[j-1] > nums[j])
                break;
            else if (nums[j-1] == nums[j]) {
                for(k = j; k > i; k--){
                    // 从后向前遍历出现连续的相同数字串，寻找其头部
                    if (nums[k] == nums[j-1]) {
                    } else if (nums[k] > nums[j-1]) {
                        k = i;
                    } else {
                        // nums[k] < nums[j-1]
                        j = k;
                    }
                }
                if (k == i) {
                    break;
                }
            }
        }
        return i == j ? 0 : j - i + 1;
    }
}
// @lc code=end
