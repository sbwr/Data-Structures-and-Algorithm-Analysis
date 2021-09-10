package Template;

// QuickSOrt template
public class qSort {
    void Sort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        // 基准点
        int pivot = left, l = left, r = right;
        while (l < r) {
            while (l < r && arr[r] >= arr[pivot])
                r--;
            while (l < r && arr[l] <= arr[pivot])
                l++; // 找到左侧比基准值大的数
            swap(arr, l, r);
        }
        swap(arr, pivot, l);
        Sort(arr, left, l);
        Sort(arr, l + 1, right);
    }

    void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 2, 4, 6, 8 };
        new qSort().Sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
