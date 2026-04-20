package Trees;

import java.util.*;

// Implements DFS (inorder, preorder, postorder) and BFS (level order, zigzag)
// for binary trees using recursion and queue. Time: O(n), Space: O(n)

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class CustomTreeWithTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println(levelOrder1(root));
    }

    static void  inOrder(TreeNode root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

  static   void preOrder(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

   static void postOrder(TreeNode root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

  static  void levelOrder(TreeNode root){
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

      while (!q.isEmpty()){
          int size = q.size();

          for (int i = 0; i < size; i++){
              TreeNode node = q.poll();
              System.out.print(node.val + " ");

              if (node.left != null) q.add(node.left);
              if (node.right != null) q.add(node.right);
          }
          System.out.println();
      }
  }

  public static List<List<Integer>>levelOrder1(TreeNode root){
        List<List<Integer>>ans=new ArrayList<>();
        if (root==null) return ans;
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()){
            int size=q.size();
            List<Integer>level=new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode node=q.poll();
                level.add(node.val);

                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
            }
            ans.add(level);
        }
        return ans;
  }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (leftToRight) {
                    level.add(node.val);          // normal
                } else {
                    level.add(0, node.val);       // reverse insert
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            ans.add(level);
            leftToRight = !leftToRight; // flip direction
        }

        return ans;
    }
}