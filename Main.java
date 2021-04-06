import java.util.Scanner;

public class Main {
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String input = in.nextLine();
        int[] nums = new int[n];
        in.close();
        // num = Integer.parseInt(input);
        for(int i = 0; i < n-1; i++){
            nums[i] = Integer.parseInt(input.substring(i, i+1));
            // int k = num%10;
            // nums[i] = k;
            // num /= 10;
            // System.out.println(nums[i]);
            // if(i == n-1)continue;
        }
        int flag = 1; //修改标志
        // int[] nums1 = nums;
        while(flag == 1){ //上一轮还有修改
            for(int i = 0; i < n-1; i++){
                if(nums[i] == -1 && nums[i+1] == -1 && i == n-2)flag = 0;
                if(nums[i] == -1)continue;
                flag = 0;
                int k = 1; //偏移量
                while(nums[i+k] == -1 && i+k < n){
                    k++;
                    // System.out.println(nums[i+k]);
                }
                if(nums[i] + nums[i+k] == 10){
                    nums[i] = -1;
                    nums[i+k] = -1;
                    flag = 1;
                    break;
                }
            }
        }

        int out = 0;
        for(int i = n-1; i >= 0; i--){
            if(nums[i] == -1);
            else {
                out++;
                // System.out.print(nums[i]);
            }
            
        }
        System.out.print(out);

    }
}
