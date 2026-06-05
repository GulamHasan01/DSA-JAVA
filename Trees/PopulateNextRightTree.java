package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class PopulateNextRightTree {

    public static Node connect(Node root) {
        if (root==null) return root;
        Queue<Node> q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            Node pre=null;
            int size=q.size();

            for (int i = 0; i < size; i++) {
                Node curr=q.poll();
                if (pre!=null){
                    pre.next=curr;
                }
                pre=curr;

                if (curr.left!=null) q.add(curr.left);
                if (curr.right!=null) q.add(curr.right);
            }
            pre.next=null;
        }
        return root;
    }

    //o(1) space comp
    public static Node connect1(Node root) {
        if (root==null) return root;
       Node leftNost=root;
        while (leftNost.left!=null){
           Node curr=leftNost;
           while (curr!=null){
               curr.left.next=curr.right;
               if (curr.next!=null) curr.right.next=curr.next.left;
              curr=curr.next;
           }
           leftNost=leftNost.left;
        }
        return root;
    }
}
