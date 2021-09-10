package Template;

import java.util.*;

public class BinaryTree {

    /** Definition fora binarytree node. */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int INF = 0xFFFFFFFF;

    /** 宽度优先/层序遍历：用队列记录遍历的次序 */
    List<Integer> BFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode emptyNode = new TreeNode(INF);
        dq.add(root);
        while (!dq.isEmpty()) {
            // 每次循环都将下一层拓展完并存到「队列」中
            // 同时将该层节点值依次存入到「列表」中
            TreeNode poll = dq.pollFirst();
            if (!poll.equals(emptyNode)) {
                dq.addLast(poll.left != null ? poll.left : emptyNode);
                dq.addLast(poll.right != null ? poll.right : emptyNode);
            }
            list.add(poll.val);
        }
        return list;
    }

    void DFS(TreeNode root) {
        if (root == null)
            return;
        // 添加节点-前序；中序则放在left后；后序 right后
        // list.add(root)
        DFS(root.left);
        DFS(root.right);
    }
    /**深度优先：用栈记录遍历次序 */
    List<Integer> DFSiterate(TreeNode root) {
        if (null == root)
            return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        // 栈
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        // 压栈
        stack.push(root);
        while (stack.size() > 0) {
            // 出栈
            TreeNode node = stack.pop();
            // 右孩子先入栈、后出栈
            TreeNode right = node.right;
            if (null != right) {
                stack.push(right);
            }

            TreeNode left = node.left;
            if (null != left) {
                stack.push(left);
            }

            list.add(node.val);
        }
        return list;
    }
}
