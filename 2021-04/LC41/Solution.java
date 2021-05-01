package LC41;


class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Boolean flag = false;
        // 遍历查找1，并删去所有无意义的负数元素
        for (int i = 0; i <= len; i++) {
            if(i == len) {
                if(flag == false) return 1; // 未发现1则返回1
                else break;
            } 
            else if(nums[i] == 1) flag = true; // 发现1设标志位
            else if(nums[i] < 1) nums[i] = 1;
        }// 根据每个位置的数字（key）改变第key-1位标志，出现过置为负数
        for (int i = 0; i < len; i++) {
            if(nums[i] <= len & Math.abs(nums[i]) > 1) {
                nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
            }
        }// 寻找第一个正数，返回对应key
        for (int i = 1; i < len; i++) { // nums[0] ~ nums[len-1] 依次表示 1 ~ len 是否出现过，从2开始检查是否出现过
            if(nums[i] > 0) {
                return i+1;
            }
        }
        return len+1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,6,3,5,4};
        Solution s = new Solution();
        System.out.print(s.firstMissingPositive(nums));
    }
}