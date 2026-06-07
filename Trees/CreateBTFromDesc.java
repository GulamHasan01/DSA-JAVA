package Trees;

import java.util.HashMap;
import java.util.HashSet;

public class CreateBTFromDesc {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode>map=new HashMap<>();
        HashSet<Integer>set=new HashSet<>();

        for (int[] num:descriptions){
           map.putIfAbsent(num[0],new TreeNode(num[0]));
           map.putIfAbsent(num[1],new TreeNode(num[1]));

           TreeNode parent=map.get(num[0]);
           TreeNode child=map.get(num[1]);
           if (num[2]==1) parent.left=child;
           else parent.right=child;

           set.add(num[1]);
        }

        for (int[] nums:descriptions){
           if (!set.contains(nums[0])){
             return map.get(nums[0]);
           }
        }
        return null;
    }
}
