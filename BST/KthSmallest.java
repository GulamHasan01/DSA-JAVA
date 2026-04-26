package BST;

public class KthSmallest {

    int ans=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }
    public void inorder(TreeNode root,int k){
        if (root==null) return;
        inorder(root.left,k);

        count++;
        if (count==k){
            ans= root.val;
            return;
        }
        inorder(root.right,k);

    }
}
