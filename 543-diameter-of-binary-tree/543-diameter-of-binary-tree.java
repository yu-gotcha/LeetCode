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
    public class DiaMover{
        int dia=0;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        DiaMover dm=new DiaMover();
        helper(root,dm);
        return dm.dia;
    }
    
    public int helper(TreeNode root,DiaMover dm){
        if(root==null){
            return -1;
        }
        
        int ls=helper(root.left,dm);
        int rs=helper(root.right,dm);
        int ht=Math.max(ls,rs)+1;
        
        if(ls+rs+2>dm.dia){
            dm.dia=ls+rs+2;
        }
        return ht;
    }
}