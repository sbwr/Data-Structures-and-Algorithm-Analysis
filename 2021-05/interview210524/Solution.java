package interview210524;

public class Solution {
    static int count1 = 0, count2 = 0;
    // 正常思路，一位一位赋值给新数组
    public static int[] shiftnums(int nums[], int k){
        int len = nums.length;
        int[] ans = new int [len];
        for(int i=0; i<len; i++){
            count1++;
            ans[(i+k)%len] = nums[i];
        }
        return ans;
    }

    // 不使用额外空间
    public static int[] shiftnums2(int nums[], int k){
        int len = nums.length;
        k %= len;
        for(int i=0; i<k; i++){
            int j=i+k, next_value = nums[i];
            for(; j<len; j+=k){
                count2++;
                int tmp = nums[j];
                nums[j] = next_value;
                next_value = tmp;
            }
            nums[j%len] = next_value;
        }
        return nums;
    }
    
    // 随机生成长度len，不超过max的数组
    public static int[] gennerateArray(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = gennerateArray(300, 100), ans1 = new int[nums.length],
        ans2 = new int[nums.length];
        int k = 99;
        // 显示移动前数组
        // for (int i : nums) {
        //     System.out.printf("%d ",i);
        // }
        System.out.println();
        long starttime = System.currentTimeMillis();
        ans1 = shiftnums(nums, k);
        System.out.println(System.currentTimeMillis()-starttime);
        starttime = System.currentTimeMillis();
        ans2 = shiftnums2(nums, k);
        System.out.println(System.currentTimeMillis()-starttime);
        // 显示移动后数组
        // for (int i : ans2) {
        //     System.out.printf("%d ",i);
        // }
        // System.out.println();
        // 输出两数组是否相等
        System.out.println(ans1[0] == ans2[0] && ans1[k] == ans2[k]);
        System.out.printf("count1:");
        System.out.println(count1);
        System.out.printf("count2:");
        System.out.println(count2);
    }
}
