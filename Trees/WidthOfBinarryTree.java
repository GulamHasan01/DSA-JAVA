package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class WidthOfBinarryTree {
    public static void main(String[] args) {

    }
    public int widthOfBinaryTree(TreeNode root) {
        return (int)Math.pow(2,levelOrder1(root)-1);
    }
    public int levelOrder1(TreeNode root){
        List<List<Integer>>ans=new ArrayList<>();
        if (root==null) return 0;
        Queue<TreeNode> q=new ArrayDeque<>();
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
        return ans.size();
    }
}
