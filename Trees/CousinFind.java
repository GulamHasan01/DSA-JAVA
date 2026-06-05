package Trees;

public class CousinFind {

        public boolean isCousins(TreeNode root, int x, int y) {
            TreeNode xx = find(root, x);
            TreeNode yy = find(root, y);

            return level(root, xx, 0) == level(root, yy, 0)
                    && !isSibling(root, xx, yy);
        }

        TreeNode find(TreeNode node, int x) {
            if (node == null) return null;

            if (node.val == x) return node;

            TreeNode left = find(node.left, x);
            if (left != null) return left;

            return find(node.right, x);
        }

        int level(TreeNode node, TreeNode x, int lev) {
            if (node == null) return -1;

            if (node == x) return lev;

            int l = level(node.left, x, lev + 1);
            if (l != -1) return l;

            return level(node.right, x, lev + 1);
        }

        boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
            if (node == null) return false;

            return (node.left == x && node.right == y)
                    || (node.left == y && node.right == x)
                    || isSibling(node.left, x, y)
                    || isSibling(node.right, x, y);
        }
    }
