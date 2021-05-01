import java.util.Scanner;

public class prob5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // String input = in.nextLine();
        int n = in.nextInt(), L = in.nextInt();
        int[][] guard = new int[2][n];
        // System.out.println(n);
        // System.out.println(L);
        for(int i = 0; i < n; i++){
            guard[0][i] = in.nextInt();
            guard[1][i] = in.nextInt();
        }
        in.close();
    }

}
