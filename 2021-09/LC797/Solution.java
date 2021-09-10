package LC797;

import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0); // 压栈出发节点
        dfs(graph, 0, graph.length - 1);
        return ans;
    }
    // 搜索从x节点到n的路径
    public void dfs(int[][] graph, int x, int n) {
        if (x == n) { // 已搜索到n节点，将栈中存的路径加入答案列表
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int ix : graph[x]) {
            stack.offerLast(ix); // 压栈经过节点
            dfs(graph, ix, n); // 继续递归深度搜索能否到终点n
            stack.pollLast(); // 结束搜索所有经过节点ix的路径，ix出栈
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(s.allPathsSourceTarget(graph));
    }
}
