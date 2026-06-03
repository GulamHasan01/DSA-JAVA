package BST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    Node left, right;
    Node(int val) {
        this.val = val;
    }
}
public class SumOfEachLevel {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(levelSum(root));
    }
    public static List<Integer>levelSum(Node root){
        List<Integer>list=new ArrayList<>();
        if (root==null) return list;
        Queue<Node>q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int ans=0;
            int size=q.size();
            for (int i = 0; i < size; i++) {
                Node node=q.poll();
                ans=ans+ node.val;
                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
            }

            list.add(ans);
        }
        return list;
    }
}
