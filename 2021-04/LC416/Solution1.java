package LC416;

// 最初版本
class Solution1 {
    public boolean canPartition(int[] nums) {
        int len = nums.length, target = 0;
        for (int i : nums) {
            target += i;
        }
        if(target %2 != 0) return false;
        target /= 2;
        // 初始化dp
        Boolean[][] dp = new Boolean[len+1][target+1];
        for (int j = 1; j <= target; j++) { // foreach 不行
            dp[0][j] = false;
        } dp[0][0] = true;

        for(int i = 1; i <= len; i++) {
            for(int j = 0; j <= target; j++) {
                if(j < nums[i-1]) dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
            }
        }
        return dp[len][target];
    }
    
}