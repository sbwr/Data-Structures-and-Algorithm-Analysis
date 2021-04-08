package LC4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i=0, j=0, k=0;
        int[] nums = new int[2];
        double median = 0;
        while(k <= (m + n) / 2){
            if(i >= n && j < m){
                nums[k%2] = nums2[j];
                j++;
            }
            else if(j >= m && i < n){
                nums[k%2] = nums1[i];
                i++;
            }else{
                if(nums1[i] < nums2[j]){
                    nums[k%2] = nums1[i];
                    i++;
                }
                else{
                    nums[k%2] = nums2[j];
                    j++;
                }
            } k++;
        }
            
        if((n + m) % 2 == 1){
            median = nums[(k+1)%2];
        }
        else{
            median = (nums[k%2]+nums[(k+1)%2]) / 2.0;
        }
        return median;
    }

    public static void main(String arg[]){
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4};
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}
