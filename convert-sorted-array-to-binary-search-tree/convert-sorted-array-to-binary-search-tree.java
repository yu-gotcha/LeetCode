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
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(null, nums, 0, nums.length - 1);
    }
    
    public static TreeNode BST(TreeNode node, int[] nums, int left, int right) {
        if(left > right) return null;
        
        int mid = (left + right) / 2;
        node = new TreeNode(nums[mid]);
        node.left = BST(node.left, nums, left, mid - 1);
        node.right = BST(node.left, nums, mid + 1, right);
        return node;
    }
}