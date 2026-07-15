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
    int count=0;
    int max=Integer.MIN_VALUE;
    public int goodNodes(TreeNode root) {
        postOrder(root);

        return count;
    }

    public void postOrder(TreeNode root){
        if(root==null) return ;
        int pre=max;
        if(root.val>=max){
            count++;
            max=root.val;
        }
       postOrder(root.left);
     
        postOrder(root.right);

          max=pre;
    }
}