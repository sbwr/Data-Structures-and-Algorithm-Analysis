package LC11;

public class Solution {
    int ans = 0, left = 0, right = 0;

    public int maxArea(int[] height) {
        right = height.length - 1;
        if (left == right) return 0;
        if (height[left] < height[right])
            left(height); // 左侧指针右移
        else
            right(height); // 右侧指针左移
        return ans;
    }

    private void left(int[] height) {
        ans = Math.max(ans, height[left] * (right - left));
        if (++left == right) return;
        if (height[left] < height[right])
            left(height);
        else
            right(height);
    }

    private void right(int[] height) {
        ans = Math.max(ans, height[right] * (right - left));
        if (left == --right) return;
        if (height[left] < height[right])
            left(height);
        else
            right(height);
    }
}
