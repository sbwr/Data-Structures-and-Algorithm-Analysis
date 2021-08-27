package biweeklyContest59.contest1;

class Solution {
    public int minTimeToType(String word) {
        int len = word.length(), n = 0, l = 0, ans = 0;
        char[] c = word.toCharArray();
        for(int i = 0; i < len; i++){
            n = c[i] - 'a';
            int step = Math.abs(n - l);
            l = n;
            step = step < 13 ? step + 1 : 27 - step;
            ans += step;
        } return ans;
    }
}