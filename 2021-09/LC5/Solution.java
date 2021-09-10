package LC5;
public class Solution {
    String longest(String s){
        if (s.length() <= 1) return s;
        int len = s.length();
        int ans = 1, start = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) { // 初始化dp
            dp[i][i] = 1;
            if (i < len-1 && s.charAt(i) == s.charAt(i+1)) {
                // i i+1组成的是回文子串
                dp[i][i+1] = 1;
                start = i;
                ans = 2;
            }
        }
        
        for (int i = 3; i < len; i++) {// 所有不同的长度
            for (int j = 0; i+j-1 < len; j++) {// 所有子串的起始位置
                int end = i + j - 1;
                if (s.charAt(j) == s.charAt(end) && dp[j+1][end-1]==1){
                    dp[j][end] = 1;
                    ans = i;
                    start = j;
                }
            }
        } return s.substring(start, start+ans);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().longest("2"));
    }
}
