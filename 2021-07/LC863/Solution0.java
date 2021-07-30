package LC863;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution0 {
    int N = 1010, M = N * 2;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int idx;
    boolean[] vis = new boolean[N];

    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs(root);
        vis[t.val] = true;
        find(t.val, k, 0, ans);
        return ans;
    }

    /** 无向图中加入边 起点a - 终点b */
    void add(int a, int b) {
        e[idx] = b; // 终点为b
        ne[idx] = he[a];// 以a为起点上一条边的编号
        he[a] = idx++; // 更新以u为起点上一条边的编号
    }

    /** 迭代查找 */
    void find(int root, int max, int cur, List<Integer> ans) {
        if (cur == max) {
            ans.add(root);
            return;
        }
        for (int i = he[root]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!vis[j]) {
                vis[j] = true; // 标记到过该结点
                find(j, max, cur + 1, ans);
            }
        }
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }
}
