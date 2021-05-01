package tencent.exam20210418.p3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        in.nextLine();
        // System.out.println(n);
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        in.close();

        // 找m的位置
        int p = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == m) p = i;
        }

        // 统计子串数
        int ceil = Math.min(p, n-p-1), len = n, ans = 1;
        // 只有一个
        if(ceil == 0) System.out.println(ans);
        // 从len=3开始。
        else {
            // 所有子串(i, j)
            for(int i = 0; i < len; i++){
                for(int j = 1; j < len; j++){
                    int l = 0;
                    int[] tmp = new int[j-i];
                    for(int k = i; k < j; k++){
                        tmp[l] = nums[k];
                    }
                    Arrays.sort(tmp);
                    int len2 = tmp.length;
                    if(m == tmp[len2/2]) ans += 1;
                }
            // }
            // for(int i = 1; i <= ceil; i++){
            //     len = 2 * i + 1;
            //     // 获得长len的子串
            //     int[] tmp = new int[len];
            //     for(int j = 0; j < len; j++){
            //         int po = p-i+j;
            //         tmp[j] = nums[po];
            //     }
                // 求中位数并比较
            }System.out.println(ans);
        }
    }
}
