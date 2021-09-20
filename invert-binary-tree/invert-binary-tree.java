/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        return invert(root);
    }

    public TreeNode invert(TreeNode node) {
        if(node.left == null && node.right == null) return node;

        TreeNode tmp = node.left == null ? null : invert(node.left);
        node.left = node.right == null ? null : invert(node.right);
        node.right = tmp;

        return node;
    }
}