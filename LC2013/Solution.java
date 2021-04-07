package LC2013;

// originate from https://leetcode-cn.com/problems/volume-of-histogram-lcci/solution/gong-shui-san-xie-yi-ti-si-jie-po-su-yu-sqadp/
class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int sum = 0;
        // 由于预处理最值的时候，我们会直接访问到 height[0] 或者 height[length - 1]，因此要特判一下
        if (length == 0) return sum;

        // 预处理每个位置左边的最值
        int[] lmax = new int[length];
        lmax[0] = height[0];
        for (int i = 1; i < length; i++) lmax[i] = Math.max(height[i], lmax[i - 1]);
        
        // 预处理每个位置右边的最值
        int[] rmax = new int[length];
        rmax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) rmax[i] = Math.max(height[i], rmax[i + 1]);

        for (int i = 1; i < length - 1; i++) {
            sum += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return sum;
    }
}