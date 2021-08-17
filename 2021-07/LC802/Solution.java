package LC802;

import java.util.*;

class Solution {
    int len, i = 0;
    int[] flag;  // 记录结点状态
    public List<Integer> eventualSafeNodes(int[][] graph) {
        /**从每个结点出发DFS，并记录经过的结点flag=1，
         * 遍历完全部结点后输出没有经过二次的结点 */ 
        len = graph.length;
        flag = new int[len];
        for (i = 0; i < len; i++){
            int len1 = graph[i].length;
            if (len1 == 0) {
                flag[i] = 2;
                continue;
            }
            else if (flag[i] == 0) { // 若未遍历到结点i，从i开始一次遍历
                for (int k = 0; k < len; k++){
                    flag[k] = flag[k] == 1 ? 0 : flag[k];
                }
                if (safeNode(graph, i)) {
                    flag[i] = 2;
                }
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int k = 0; k < len; k++) {
            if (flag[k] == 2) ans.add(k);            
        }
        return ans;
    }
    private boolean safeNode(int[][] graph, int n){
        if (flag[n] == 1) return false; // 已第二次经过该结点
        else if (flag[n] == 2) { // 已记录为安全结点，无需向更深处遍历
            return true;
        }
        else { // flag[n] == 0, n为未经过的结点：遍历n能到达的所有结点
            flag[n] = 1;
            for (int k = 0; k < graph[n].length; k++){
                if (!safeNode(graph, graph[n][k])){ // 遍历n能到达的所有结点，只要其中有非安全结点，则结点n也不安全
                    return false;
                }
            }return true;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(s.eventualSafeNodes(graph));
    }
}
