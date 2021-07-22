package LC1838;

import java.util.Arrays;

class Solution2 {
    static public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 1, total = 0, n = 1;
        for(int i=1; i<nums.length; i++){
            for(; j<=i; j++){
                int tmp = nums[i] - nums[i-j];
                total += tmp;
                if(total > k) break;
            }
            n = Math.max(n, j);
            j = 1; total = 0;
        }
        return n;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,4,5,8,13};
        System.out.println(maxFrequency(nums, 5));
    }
}
