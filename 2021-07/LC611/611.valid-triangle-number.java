import java.util.Arrays;

/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 */

// @lc code=start
/**O(n2)优化搜索 */
class Solution {
    public int triangleNumber(int[] nums) {
        int len = nums.length, i, j, k, ans = 0;
        if(len < 3) return 0;
        Arrays.sort(nums);
        k = len-1; // 最长边
        for(k = len-1; k > 1; k--) { // i, j, k分别指向短、中、长三边
            i = 0;
            j = k-1;
            while(i < j){ // 在[0, k-1]位置中寻找能够满足条件的短边、中边。
                // 固定中边，短边递增直到满足两边和大于长边。
                if (nums[i] + nums[j] <= nums[k]) {
                    i++;
                }
                else { // (nums[i] + nums[j] > nums[k]) // 满足，则nums[i]~nums[j-1]做短边全部满足
                    ans += j - i;
                    j--;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

