package Contest.Contest257.S1;

class Solution {
    public int countQuadruplets(int[] nums) {
        int ans = 0, len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i+1; j < len-1; j++) {
                for (int k = j+1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    for (int l = k+1; l < nums.length; l++) {
                        if(nums[l] == sum) {
                            ans++;
                        }
                    }
                }
            }
        }return ans;
    }
}