package LC526;

class Solution {
    int ans = 0;

    public int countArrangement(int n) {
        boolean[] flag = new boolean[n];
        for (int i = 0; i < flag.length; i++) {
            flag[i] = true;
        }
        beautiful(n, n, flag);
        return ans;
    }

    private void beautiful(int n, int i, boolean[] flag) {
        for (int j = 1; j <= n; j++) {
            if (flag[j - 1] == true) {
                if (j >= i && j % i == 0) {
                    if (i == 1) {
                        ans++;
                        return;
                    }
                    flag[j - 1] = false;
                    beautiful(n, i - 1, flag);
                    flag[j - 1] = true;
                } else if (i > j && i % j == 0) {
                    if (i == 1) {
                        ans++;
                        return;
                    }
                    flag[j - 1] = false;
                    beautiful(n, i - 1, flag);
                    flag[j - 1] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countArrangement(5));
    }
}