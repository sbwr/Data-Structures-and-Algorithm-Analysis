package Contest.Contest257.S4;

class Solution {
    public boolean gcdSort(int[] nums) {
        // 排序
        Sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return false;
        }
        return true;
    }

    void Sort(int[] arr) {
        int i = 0, len = arr.length, j;
        for (i = 0; i < len - 1; i++) {
            for (j = len - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    if (gcd(arr[i], arr[j])) {
                        swap(arr, i, j);
                    }
                }
            }
        }
    }

    void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    boolean gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a == 1 ? false : true;
    }
}
