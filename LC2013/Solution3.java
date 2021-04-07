package LC2013;

public class Solution3 {
    public int trap(int[] height) {
        int depth = 1, length = height.length, sum = 0, walls = 0;
        int left = 0, right = length - 1;
        while(left <= right){
            if(height[left] >= depth) {
                while (height[right] < depth && right >= left ){
                    right--;
                }
                if (height[right] >= depth && right >= left ){
                    sum += right - left + 1;
                    depth++;
                    continue;
                }
            }
            left ++;
        }
        for(int i = 0; i < length; i++) {
            walls += height[i];
        }
        return sum - walls;
    }

    public static void main(String arg[]){
        int[] height = {0,2,0};
        Solution3 s = new Solution3();
        System.out.println(s.trap(height));
    }
}