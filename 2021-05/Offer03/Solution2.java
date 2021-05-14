package Offer03;

class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            while(nums[i] != i){
            /**
             * 将nums[i]的数换到正确的位置，直到nums[i]内的数已在正确位置
             * 结束标志 1. 若两位置的数相等，找到；
             *         2. 若nums[i]<i，nums[i]必然已出现过，找到；
             */
                int val = nums[i];
                if(nums[val] == val || val<i)return val;
                nums[i] = nums[val];
                nums[val] = val;
            }
        }return -1;
    }
}
