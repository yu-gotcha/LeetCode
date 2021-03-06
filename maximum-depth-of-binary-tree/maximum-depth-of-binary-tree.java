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
    public int maxDepth(TreeNode root) {
        return traverse(root);
    }
    
    public int traverse(TreeNode node) {
        if(node == null)  return 0;
        int left = traverse(node.left) + 1;
        int right = traverse(node.right) + 1;
        return Math.max(left, right);
    }
}