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
    public static void bfs(TreeNode node, List<List<Integer>> res){
        if(node==null)return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr!=null && curr.left!=null)q.add(curr.left);
                if(curr!=null && curr.right!=null)q.add(curr.right);
                if(curr!=null)list.add(curr.val);
            }
            res.add(list);
            list = new ArrayList<>();
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(root,res);
        return res;
    }
}