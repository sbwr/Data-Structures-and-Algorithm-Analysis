package Interview1714;

import java.util.Arrays;

// using Arrays.sort() API
class Solution1 {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = arr[i];
        return ans;
    }
}
