import java.util.Arrays;

/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 */

// @lc code=start
/**O(n3)暴力搜索，列举判断所有三边长情况 */
class Solution {
    public int triangleNumber(int[] nums) {
        int len = nums.length, sum2, ans = 0;
        if(len < 3) return 0;
        Arrays.sort(nums);
        for(int i = 0; i < len-2; i++) { // i, j, k分别指向三边
            for(int j = i+1; j < len-1; j++) {
                sum2 = nums[i] + nums[j];
                int k;
                for (k = j+1; k < len && nums[k] < sum2; k++) {
                    // 找到第一个不满足的长边
                } ans += k-j-1;
            }
        }
        return ans;
    }
}
// @lc code=end

