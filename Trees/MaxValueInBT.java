package Trees;

public class MaxValueInBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        System.out.println(maxValue(root));
    }
    static int maxValue(TreeNode root){
        if (root == null) return Integer.MIN_VALUE;

        int left= maxValue(root.left);
        int right= maxValue(root.right);

        return Math.max(Math.max(root.val,left),right);
    }
}
