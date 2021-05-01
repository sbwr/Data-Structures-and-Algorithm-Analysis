package LC33;
// iterative solution
public class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1,
            mid = end / 2;
        while(start <= end){
            if(target == nums[mid]) return mid;
            if(target == nums[start]) return start;
            if(target == nums[end]) return end;

            if(nums[start] < nums[mid]) {
                if(target > nums[start] && target < nums[mid]){
                    end = mid - 1; // endless loop happens when using (mid-1)
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if(target > nums[mid] && target < nums[end]){
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            mid = (start + end) / 2;
        }
        return -1;
    }
    public static void main(String arg[]) {
        Solution s = new Solution();
        int [] nums = {1,3};
        
        System.out.println(s.search(nums, 2));
    }
}
