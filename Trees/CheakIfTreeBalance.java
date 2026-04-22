package Trees;

public class CheakIfTreeBalance {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        System.out.println(isBalanced1(root));
    }

    static boolean isBalanced(TreeNode root){
        if (root == null) return true;

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    static boolean isBalanced1(TreeNode root){
        return checkHeight(root) != -1;
    }
    static int checkHeight(TreeNode root){
        if (root == null) return 0;

        int left = checkHeight(root.left);
        if (left == -1) return -1;

        int right = checkHeight(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    static int  height(TreeNode root){
        if (root==null) return 0;
        int left=height(root.left);
        int right=height(root.right);

        return 1+Math.max(left,right);
    }
}
