package Contest.Contest257.S2;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int len = properties.length;
        if (len == 1) return 0;
        // 按attack排序 相同attack怎么办？？反着排
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        int ans = 0, max = properties[len-1][1]; // 记录最大defen
        for (int i = len-2; i >= 0; i--) {
            if (properties[i][1] < max) ans++;
            else max = properties[i][1];
        } return ans;
    }
}
