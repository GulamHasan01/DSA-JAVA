package BST;
import BST.Node;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class LevelOrderSucceser {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(succeser(root,5));

    }

    public static int succeser(Node root,int value){
       int ans=0;
       if (root==null) return -1;
        Queue<Node>q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size; i++) {
                Node node=q.poll();
                if (node.val == value) {
                    return q.isEmpty() ? -1 : q.peek().val;
                }
                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);

            }
        }
        return ans;
    }
}
