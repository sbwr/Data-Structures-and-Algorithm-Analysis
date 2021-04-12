package LC179;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        ArrayList<String> numsAL = new ArrayList<String>();
        for(int i = 0; i < len; i++){ numsAL.add(String.valueOf(nums[i])); }
        Collections.sort(numsAL,(a,b)->{
            return (b+a).compareTo(a+b);}); // sort using custom rule, used lambda expressions
        // return numsAL.toString(); // will get String[] by this mean
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(numsAL.get(i).toString());
        }
        System.out.println(numsAL.getClass().toString());
        String ans = sb.toString();
        return ans.charAt(0)=='0'?"0":ans; // 若ans首位为0，则其为len个连续的0，输出0
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {33, 34, 340, 3, 301};
        System.out.println(s.largestNumber(nums));
    }
}
