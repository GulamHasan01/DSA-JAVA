package Trees;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePreAndInOrder {
    static int preIndex=0;
   static Map<Integer,Integer>map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length);
    }
    public static TreeNode build(int[] preorder,int start,int end){
        if (start>end) return null;

        int val=preorder[preIndex++];
        TreeNode root = new TreeNode(val);
        int mid= map.get(val);

        root.left=build(preorder,start,mid-1);
        root.right=build(preorder,mid-1,end);

        return root;
    }
}
