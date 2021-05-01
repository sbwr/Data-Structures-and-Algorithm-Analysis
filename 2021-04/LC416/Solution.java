package LC416;

public class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length, target = 0;
        for (int i : nums) {
            target += i;
        }
        if(target%2 != 0) return false;
        target /= 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < len; i++){
            /** 内循环从前往后，错误：导致一个数可以被使用多次 */
            // for(int j = nums[i]; j <= target; j++){
            //     dp[j] = (dp[j] > 0 || dp[j-nums[i]] > 0) ? 1 : 0;
            // }
            for(int j = target; j >= nums[i]; j--){
                dp[j] = (dp[j] > 0 || dp[j-nums[i]] > 0) ? 1 : 0;
            }
        }return dp[target] > 0 ? true : false;
    }
}
