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
    public static int preIndex;
    public static TreeNode build(int[] preorder, int[] inorder, HashMap<Integer,Integer> map, int left, int right){
        if(left>right){
            return null;
        }else{
            int x = preorder[preIndex++];
            int ind = map.get(x);
            TreeNode root = new TreeNode(x);
            root.left = build(preorder,inorder,map,left,ind-1);
            root.right = build(preorder,inorder,map,ind+1,right);
            return root;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = build(preorder,inorder,map,0,preorder.length-1);
        return root;
    }
}