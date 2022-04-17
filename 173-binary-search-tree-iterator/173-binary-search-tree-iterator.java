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

class BSTIterator {
    ArrayList<Integer> list;
    int current;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorderTraverse(root);
        current = 0;
    }
    
    public int next() {
        return list.get(current++);
    }
    
    public boolean hasNext() {
        return current < list.size();
    }
    
    private void inorderTraverse(TreeNode node) {
        if(node == null) return;
        inorderTraverse(node.left);
        list.add(node.val);
        inorderTraverse(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */