package Offer03;
// 能过样例，but存在关于0处理的bug
class Solution3 {
    public static int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int val = Math.abs(nums[i]);// 保存绝对值数据，减少求绝对值的次数
            if(nums[val] < 0) {return val;}
            else {nums[val] = -nums[val];}
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {6, 3, 1, 0, 2, 5, 3};
        findRepeatNumber(nums);
    }
}
