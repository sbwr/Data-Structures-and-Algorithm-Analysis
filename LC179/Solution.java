package LC179;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    
    public String largestNumber(int[] nums) {
        int len = nums.length;
        ArrayList<String> numsAL = new ArrayList<String>();
        for(int i = 0; i < len; i++){ numsAL.add(String.valueOf(nums[i])); }

        /*** sort using custom rule ***/
        // Collections.sort(numsAL, new Comparator<String>(){ // assigned using anonymous class
        //     @Override
        //     public int compare(String a, String b) {
        //         return (b+a).compareTo(a+b);
        //     }
        // });
        Collections.sort(numsAL,(a,b)->{ // assigned by lambda expressions
            return (b+a).compareTo(a+b);}); 

        /*** ArrayList -> String, then output ***/
        // return numsAL.toString); // will get String[] by this mean
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(numsAL.get(i).toString());
        }
        String ans = sb.toString();
        return ans.charAt(0)=='0'?"0":ans; // 若ans首位为0，则其为len个连续的0，输出0
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {33, 34, 340, 3, 301};
        System.out.println(s.largestNumber(nums));
    }
}
