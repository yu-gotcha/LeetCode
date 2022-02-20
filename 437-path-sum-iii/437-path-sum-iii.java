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
    public int pathSum(TreeNode root, int target) {
    if (root == null) return 0;

    return dfs(root, target) +
        pathSum(root.left, target) +
        pathSum(root.right, target);
    }

    private int dfs(TreeNode root, int target) {
        if (root == null) return 0;

        int remainder = target - root.val;
        int total = remainder == 0 ? 1 : 0;
        return total + dfs(root.left, remainder) + dfs(root.right, remainder);
    }
}