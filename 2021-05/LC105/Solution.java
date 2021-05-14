package LC105;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    // 区间左闭右开
    public static TreeNode build(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end){
        if (in_start - 1 == in_end) return new TreeNode(inorder[in_start]);
        if (in_start == in_end) return null;
        int root_value = preorder[pre_start]; // 根节点的值
        int root_in = 0; // 根节点在中序遍历中的位置
        for(int i=in_start; i<in_end; i++){
            if(inorder[i] == root_value) {
                root_in = i;
            }
        }
        // 计算下一次调用函数的范围参数
        /** 
         * inorder 划分结果：
         * [in_start, root_in) 为左子树
         * [root_in+1, in_end) 为右子树
         */ 
        int lsize = root_in - in_start;
        // int rsize = in_end - root_in;
        /**
         * preorder:
         * [pre_start+1, pre_start+1+lsize) ltree
         * [pre_start+1+lsize, pre_end) rtree
         */

        TreeNode root = new TreeNode(root_value, 
                build(preorder, inorder, pre_start+1, pre_start+1+lsize, in_start, root_in), // 左子树
                build(preorder, inorder, pre_start+1+lsize, pre_end, root_in+1, in_end) );   // 右子树
        return root;
    }
}
