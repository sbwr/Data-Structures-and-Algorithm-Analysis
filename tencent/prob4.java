package tencent;

import java.util.Scanner;

public class prob4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] gym = new int[n], work = new int[n], rest = new int[n];
        for(int i = 0; i < n; i++){
            gym[i] = in.nextInt();
        }for(int i = 0; i < n; i++){
            work[i]  = in.nextInt();
        }for(int i = 0; i < n; i++){
            if(gym[i] == 0);
        }
        in.close();
        System.out.println(rest);
    }
}
