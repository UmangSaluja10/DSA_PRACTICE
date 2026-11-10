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
    public int x;
    public int ans;
    public boolean flag;
    public void inorder(TreeNode node, int k){
        if(node==null)return;
        if(!flag)inorder(node.left,k);
        if(!flag && k==x){
            ans =  node.val;
            flag = true;
            return;
        }
        x++;
        if(!flag)inorder(node.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        x = 1;
        ans = 0;
        flag = false;
        //find the kth inorder element
        inorder(root,k);
        return ans;
    }
}