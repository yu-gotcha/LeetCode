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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        
        traverse(root, list);
        Collections.sort(list);
        
        return list.get(k - 1);
    }
    
    public static void traverse(TreeNode node, List<Integer> list) {
        if(node == null) return;
        
        list.add(node.val);
        traverse(node.left, list);
        traverse(node.right, list);
    }
    
    
}