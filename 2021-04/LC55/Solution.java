package LC55;

class Solution {
    // 从后往前寻找 "最早开始位置" end
    public boolean canJump(int[] nums) { 
        int l = nums.length - 2, end = nums.length - 1;
        while(l >= 0){
            if(l + nums[l] >= end) {
                end = l;
            }
            l--;
        }
        if(end == 0)return true;
        else return false;
    }
}