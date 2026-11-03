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
    public int max;
    public int height(TreeNode node){
        if(node==null)return 0;
        if(node.left==null && node.right==null)return 1;
        return 1+Math.max(height(node.right),height(node.left));
    }
    public void check(TreeNode root){
        if(root==null)return;
        int currentDiameter = height(root.left)+height(root.right);
        if(currentDiameter>max){
            max = currentDiameter;
        }
        check(root.left);
        check(root.right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        check(root);
        return max;
    }
}