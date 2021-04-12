package LC179;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String numsToWord[] = new String[n];
        for(int i=0;i<n;i++){
            numsToWord[i] = String.valueOf(nums[i]);
        }
        //[233，23333]排序后变为[23333，233]
        Arrays.sort(numsToWord,(a,b)->{
            return (b+a).compareTo(a+b);
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(numsToWord[i]);
        }
        String res = sb.toString();
        return res.charAt(0)=='0'?"0":res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {233, 23333, 2, 23};
        System.out.println(s.largestNumber(nums));
    }
}


// 作者：wang-qiang-ustb
// 链接：https://leetcode-cn.com/problems/largest-number/solution/java-jiang-shu-zu-zhuan-hua-wei-zi-fu-ch-ikrv/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。