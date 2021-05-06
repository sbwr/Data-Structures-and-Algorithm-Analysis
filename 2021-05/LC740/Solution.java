package LC740;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

class Solution {
    public static int deleteAndEarn(int[] nums) {
        // 用hashmap存数组，每个出现的key对应其出现次数value
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            Integer value = map.get(nums[i]);
            if(value != null) map.put(nums[i], ++value);
            else map.put(nums[i], 1);
        }

        // 对hashmap的key排序（hashmap原存储方式非顺序）
        Set<Integer> set = map.keySet();
        Object[] array = set.toArray();
        Arrays.sort(array);

        int[][] dp = new int[array.length+1][2];
        for(int i=1; i<=array.length; i++) {
            // 考虑数组不连续的情况
            if(i>1 && (int)array[i-1]-1 > (int)array[i-2]){
                dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
                dp[i][1] = dp[i][0] + (int)array[i-1] * map.get(array[i-1]);
            }else{
                dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
                dp[i][1] = dp[i-1][0] + (int)array[i-1] * map.get(array[i-1]);
            }
            // System.out.printf("dp[%d][0]=%d, dp[%d][1]=%d \n", i,dp[i][0],i,dp[i][1]);
        }

        return dp[array.length][0] > dp[array.length][1] ?
               dp[array.length][0] : dp[array.length][1];
    }
    public static void main(String[] args) {
        int[] nums = {4,1};
        System.out.println(deleteAndEarn(nums));
    }
}