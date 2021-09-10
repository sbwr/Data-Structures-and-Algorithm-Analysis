package Contest.Contest257.S3;

/** dp:
 * 访问到房间i的第二天：
 * 1. 奇数次访问i则访问i前的某间房间
 * 2. 偶数次访问i则访问i+1
 * 使用dp[i]表示从第0天到离开第i个房间需要的总天数;
 * 需要注意：我们来到nextVisit[i-1]nextVisit[i−1]时的状态恰好nextVisit[i-1]和i-1被访问了奇数次，
 * 其余房间都被访问了偶数次（包括0）。因此这一状态与我们第一次来到nextVisit[i-1]时的差别只在于i-1的访问状态，
 * 那么我们就可以得出：从nextVisit[i-1]到i-1的用时为dp[i-1]-dp[nextVisit[i-1]]天。
 * 接下来，我们再花一天到达i。
 */
class Solution { 
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int[] dp = new int[nextVisit.length+1];
        int mod = 1000000007;
        for (int i = 0; i < nextVisit.length; i++) {
            if (nextVisit[i] == i) {
                dp[i+1] = (dp[i] + 2+mod) % mod;
            } else {
                dp[i+1] = (2 * dp[i] - dp[nextVisit[i]] + 2 + mod) % mod;
            }
        }
        return (int)dp[dp.length-2]; // 到最后一个房间的天数=离开倒数第二个房间的天数
    }
    public static void main(String[] args) {
        int[] nextVisit = {0,0,1,0,2,0};
        System.out.println(new Solution().firstDayBeenInAllRooms(nextVisit));
    }
}
