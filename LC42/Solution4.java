package LC42;

class Solution4 {
    public int trap(int[] height) {
        int len = height.length, water = 0, tmp;
        int[] leftmax = new int[len], rightmax = new int[len];
        if(len == 0)return 0; // WTF
        leftmax[0] = 0;
        rightmax[len-1] = 0;

        //traverse to get all leftmax nums & rightmax nums
        for(int i = 1; i < len - 1; i ++) {
            leftmax[i] = Math.max(leftmax[i-1], height[i-1]);
            rightmax[len - 1 - i] = Math.max(rightmax[len - i], height[len - i]);
        }

        //cal each grid
        for(int i = 0; i < len; i ++) {
            tmp = Math.min(leftmax[i], rightmax[i]) - height[i];
            if(tmp > 0) water += tmp;
        }
        return water;
    }
    public static void main(String arg[]){
        int[] height = {0,1,0,2,1,0,1};
        Solution4 s = new Solution4();
        System.out.println(s.trap(height));
    }
}