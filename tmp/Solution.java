import java.util.*;
import javax.swing.tree.TreeNode;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 你需要返回一个指针，指向root，表示删减去若干个点后，剩下的树
     * @param root TreeNode类 指向二叉树的根
     * @return TreeNode类
     */
    public TreeNode solve (TreeNode root) {
        // write code here
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        input = input.substring(1, input.length()-1);
        String[] input_1 = input.split(",");
        int[] num = new int[input_1.length];
        for(int i = 0; i<input_1.length; i++){
            num[i] = Integer.parseInt(input_1[i]);
        }
        double n = 0;
        while(Math.pow(2.0, n+1) - 2 < num.length){
            n++;
        }
        int end;
        for(double i = n; i >= 0; i--){
            int low = (int) (Math.pow(2, i) - 2), high = (int) (Math.pow(2, i + 1) - 2);
            for(int j = low; j < high; j++){
                if(j>=num.length) end = j;
                else if (input_1[j] == "#") end = j;
            }
        }
    }
}