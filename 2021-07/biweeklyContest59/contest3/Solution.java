class Solution {
    public int numberOfCombinations(String num) {
        char[] c = num.toCharArray();
        int len = c.length, ans = 1;
        if(c[0] == '0') return 0;
        for (int i = 1; i < len; i++) {
            if (c[i] == '0' || c[i] < c[i-1]) {}
            else ans = (ans * 2) % 1000000007;
        } return ans;
    }
}
