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
    int count;
    public int averageOfSubtree(TreeNode root) {
       countAvg(root);
       return count; 
    }
    private int[] countAvg(TreeNode root ){
        if(root==null) return new int[]{0,0};
        
        int[] left=countAvg(root.left);
        int[] right=countAvg(root.right);
        int sum=root.val+left[0]+right[0];
        int node=1+left[1]+right[1];
        if(sum/node==root.val) count++;

       return new int[]{sum,node};
    }
}