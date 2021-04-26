class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int min = 0, max = 0;   // 二分查找上下限
        for (int i : weights) {
            if(i > min) min = i;
            max += i;
        }
        int mid = (min + max) / 2, result = 1, sum = 0;
        while (max != mid){
            // 求载重为mid时需要的天数result
            sum = 0; result = 1;
            for (int num : weights) {
                if(num + sum <= mid) sum += num;
                else {
                    result++;
                    sum = num;
                }
            }if(result > D) min = mid + 1;
            else max = mid;
            mid = (min + max) / 2;
        }return mid;
    }
}