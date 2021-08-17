package LC11;
/** 暴力搜索所有情况 */
class Solution0 {
    public int maxArea(int[] height) {
        int ans = 0, left = 0, right = 1, len = height.length;
        for (; left < len - 1; left++) {
            for (right = left + 1; right < len; right++) {
                int tmp = Math.min(height[left], height[right]) * (right - left);
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}