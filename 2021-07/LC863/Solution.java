package LC863;

import java.util.ArrayList;
import java.util.List;

/* Definition for a binary tree node. */
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

class Solution {
    int N = 501;
    boolean[] vis = new boolean[N];
    TreeNode[] parent = new TreeNode[N];
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {
        DFS(root);
        find(t, k);
        return ans;
    }

    /** 记录每个结点的父 */
    public void DFS(TreeNode root) {
        if (root.left == null && root.right == null)
            return;
        if (root.left != null) {
            parent[root.left.val] = root;
            DFS(root.left);
        }
        if (root.right != null) {
            parent[root.right.val] = root;
            DFS(root.right);
        }
    }

    /** 向父、左、右结点三个方向递归搜索距离为k的结点 */
    public void find(TreeNode t, int k) {
        vis[t.val] = true; // 表示到达过t
        if (k == 0) {
            ans.add(t.val);
            return;
        }
        if (parent[t.val] != null && vis[parent[t.val].val] == false) {
            // 父结点方向
            find(parent[t.val], k - 1);
        }
        if (t.left != null && vis[t.left.val] == false) {
            find(t.left, k - 1);
        }
        if (t.right != null && vis[t.right.val] == false) {
            find(t.right, k - 1);
        }
    }
}
