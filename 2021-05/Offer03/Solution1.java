package Offer03;

class Solution1 {
    public int findRepeatNumber(int[] nums) {
        
        int[] flag = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(flag[i] >= 2) return i;
            flag[nums[i]] ++;
        }for(int i = 0; i < nums.length; i++){
            if(flag[i] >= 2) return i;
        }
        return -1;
    }
}
