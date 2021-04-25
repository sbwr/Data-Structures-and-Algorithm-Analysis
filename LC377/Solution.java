public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int N = nums.length;
        if (N == 0 || target == 0) return 0;
        int[] dp = new int[target+1]; // 用dp[j]表示和为j的组数，dp[target]即和为target
        dp[0] = 1;
        for (int i = 1; i <= target; i++){ // 外循环从0开始递增，i表示数字总和为i
            for (int num : nums) {
                if(num <= i) dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}
