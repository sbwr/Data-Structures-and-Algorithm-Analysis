
public class Solution1 {
    public int combinationSum4(int[] nums, int target) {
        int N = nums.length;
        if (N == 0 || target == 0) return 0;
        int[] dp = new int[target+1]; // 用dp[j]表示和为j的组数，dp[target]即和为target
        dp[0] = 1;
        int ans = 0; // 记录总的和为target的组数
        for (int i = 1; i <= target; i++){ // 外循环从0开始递增，i表示当前使用的数字总数
            // 利用i-1次的结果计算使用i个数字达到每个总和j的组数
            for (int j = target; j >= 0; j--){ // 内循环[target, i]
                if(j < i) continue;
                for(int num : nums){
                    // 循环遍历数组，寻找可以添加以达到总和j的数
                    if(num <= j){
                        dp[j] += dp[j-num];
                    }
                }
            }ans += dp[target];
        }
        return ans;
    }
}