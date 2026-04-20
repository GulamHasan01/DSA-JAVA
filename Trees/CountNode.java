package Trees;

public class CountNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        System.out.println(sumNodes(root));
    }
   static int countNodes(TreeNode root){
        if (root==null) return 0;

       int left= countNodes(root.left);
       int right= countNodes(root.right);

       return 1+left+right;
   }
   static int sumNodes(TreeNode root){
       if (root==null) return 0;

      int left=sumNodes(root.left);
      int right= sumNodes(root.right);
      return root.val+left+right;
   }
}
