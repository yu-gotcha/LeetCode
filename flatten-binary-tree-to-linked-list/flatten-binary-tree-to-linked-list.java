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
import java.util.*;

class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        
        traverse(root, stack);
        
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            TreeNode tmp = current.left;
            TreeNode tmpRight = tmp;
            while(tmpRight.right != null) tmpRight = tmpRight.right;
            tmpRight.right = current.right;
            current.right = tmp;
            current.left = null;
        }
    }
    
    public void traverse(TreeNode node, Stack<TreeNode> stack) {
        if(node == null) return;
        if(node.left != null) stack.push(node);
        traverse(node.left, stack);
        traverse(node.right, stack);
    }
}