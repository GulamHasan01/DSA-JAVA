package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        int level=1;
        int maxLevel=1;
        int maxSum = Integer.MIN_VALUE;
        if (root==null) return 0;
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int n=q.size();
            int sum=0;
            for (int i = 0; i < n; i++) {
              TreeNode node=q.poll();
                assert node != null;
                sum+=node.val;

                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
            }
            if (sum>maxSum){
                maxSum=sum;
                maxLevel=level;
            }
            level++;
        }

        return maxLevel;
    }
}
