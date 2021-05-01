package tencent.exam20210418.p4;

import java.util.Scanner;

public class Main {
    // 满足本题相等条件返回true
    private static Boolean myequal(String a, String b){
        int len = a.length();
        if(a.equals(b)) {
            return true;
        }
        else {
            if(len %2 != 0) {
                return false;
            }
            else { // 字符串长为偶数
                /************** 核心：判断子串相等性 */ 
                String a1 = a.substring(0, len/2);
                String b1 = b.substring(0, len/2);
                String a2 = a.substring(len/2, len);
                String b2 = b.substring(len/2, len);
                if(a1.equals(b2) && a2.equals(b1)) return true;
                else return (myequal(a1, b2) && myequal(a2, b1));
            }
        }
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int [] ans = new int[n];
        String[][] s = new String[n][2];

        // 输入所有字符串
        for(int i = 0; i < n; i++){
            s[i][0] = in.nextLine();
            s[i][1] = in.nextLine();
        }
        in.close();
        
        // 分别比较字符串
        for(int i = 0; i < n; i++){
            ans[i] = myequal(s[i][0], s[i][1]) == true? 1 : 0;
        }

        // output
        for(int i = 0; i < n; i++){
            if(ans[i]==0) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
