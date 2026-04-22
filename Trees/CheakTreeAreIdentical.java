package Trees;

public class CheakTreeAreIdentical {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: Both null
        if (p == null && q == null) return true;

        // Case 2: One null, other not
        if (p == null || q == null) return false;

        // Case 3: Values don’t match
        if (p.val != q.val) return false;

        // Case 4: Recursively check left & right
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
