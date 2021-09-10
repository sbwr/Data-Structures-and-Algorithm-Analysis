package Interview1714;

import java.util.Random;

class Solution {
    int k;
    public int[] smallestK(int[] arr, int _k) {
        k = _k;
        int n = arr.length;
        int[] ans = new int[k];
        if (k == 0) return ans;
        qsort(arr, 0, n - 1);
        for (int i = 0; i < k; i++) ans[i] = arr[i];
        return ans;
    }
    void qsort(int[] arr, int l, int r) {
        if (l >= r) return ;
        int i = l, j = r;
        int pivot = l; // 随机取区间内的某位数作为基准点
        swap(arr, pivot, l); // 总是将基准点存在arr[l]
        int x = arr[l];
        // 交换arr[i] > x & arr[j] < x对，结束后arr[i]左侧小于x、右侧大于x
        while (i < j) {
            while (i < j && arr[j] >= x) j--;
            while (i < j && arr[i] <= x) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 只需找到前k个最小，不需要完整排序
        if (i > k-1) qsort(arr, l, i - 1);
        if (i < k-1) qsort(arr, i + 1, r);
    }

    void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        System.out.println(new Solution().smallestK(arr, k)[0]);
    }
}
