package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        if (root==null) return ans;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size; i++) {

                TreeNode node=q.poll();
                if (i==size-1){
                    ans.add(node.val);
                }

                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
            }
        }
        return ans;
    }
}
