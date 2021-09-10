package Contest.Contest257.S3;

import java.util.HashMap;
import java.util.HashSet;

class Solution1 { // 模拟 超时
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length, ans = 0, MOD = 1000000007;
        HashSet<Integer> check = new HashSet<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            check.add(i);
            map.put(i, false); // 为偶数
        }
        int nxt = 0;
        while (!check.isEmpty()) {
            ans = ans == MOD ? 1 : ans + 1;
            check.remove(nxt);
            Boolean odd = !map.get(nxt);
            map.put(nxt, odd);
            if (odd) {
                nxt = nextVisit[nxt];
            } else {
                nxt = (nxt + 1) % n;
            }
        } return ans-1;
    }
}
