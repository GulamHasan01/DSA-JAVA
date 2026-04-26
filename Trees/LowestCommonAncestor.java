package Trees;

//  Finds the lowest common ancestor of two nodes using recursive DFS by checking left and right subtrees.
public class LowestCommonAncestor {


    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }
}