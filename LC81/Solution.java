package LC81;

class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1,
            mid = end / 2;
        if(end == -1)return false;
        while(start <= end){
            if(target == nums[mid] || target == nums[start] || target == nums[end])
                return true;
            if(nums[start] == nums[mid]) {
                start++;
                continue;}
            if(nums[end] == nums[mid]) {
                end--;
                continue;} 
            // 有序区间(start, mid)内有target或有序区间(mid, end)内无target：继续在(start, mid-1)内二分查找
            if((nums[start] < nums[mid] && target < nums[mid] && target > nums[start])
            || (nums[mid] < nums[end] && (target < nums[mid] || target > nums[end]))){
                end = mid - 1;
            }
            else if((nums[start] < nums[mid] && (target > nums[mid] || target < nums[start]))
                 ||( nums[mid] < nums[end] && target > nums[mid] && target < nums[end])){
                start = mid + 1;
            }
            else System.out.println("err");
            mid = (start + end) /2;
        }
            return false;    
    }
    public static void main(String arg[]) {
        Solution s = new Solution();
        int [] nums = {4,5,6,7,0,1,2};

        System.out.println(s.search(nums, 0));
    }
}
