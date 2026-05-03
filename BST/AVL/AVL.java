package BST.AVL;
class Node{
    Node left,right;
    int val,height;
    Node(int val){
        this.val=val;
        this.height=1;
    }

}
public class AVL {

    int height(Node root){
        return (root==null)?0: root.height;
    }
    int getBalance(Node root){
        return (root==null)?0:height(root.left)-height(root.right);
    }

    Node rotateLeft(Node root){

        Node p=root.right;
        Node t1=p.left;

        p.left=root;
        root.right=t1;

        p.height=1+Math.max(height(p.left),height(p.right));
        root.height=1+Math.max(height(root.left),height(root.right));

        return p;
    }

    Node rotateRight(Node root){

        Node p=root.left;
        Node t1=p.right;

        p.right=root;
        root.left=t1;

        p.height=1+Math.max(height(p.left),height(p.right));
        root.height=1+Math.max(height(root.left),height(root.right));


        return p;
    }
    Node insert(Node root,int val){
        if (root == null) return new Node(val);

        if (val> root.val){
            root.right=insert(root.right,val);
        }else if (val<root.val){
            root.left=insert(root.left, val);
        }else return root;

        root.height=1+Math.max(height(root.right),height(root.left));

        int balance=getBalance(root);
        // LL
        if (balance > 1 && val < root.left.val)
            return rotateRight(root);

        // RR
        if (balance < -1 && val > root.right.val)
            return rotateLeft(root);

        // LR
        if (balance > 1 && val > root.left.val){
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // RL
        if (balance < -1 && val < root.right.val){
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    // delete node

    Node minNodeVal(Node root){
        Node min=root;
        while (min.left!=null) min=min.left;

        return min;
     }

     Node deleteNode(Node root,int val){
        if (root==null) return root;

        if (root.val>val){
           root.left=deleteNode(root.left,val);
        }else if(root.val<val){
            root.right=deleteNode(root.right,val);
        }else{
            if (root.left==null || root.right==null){
                Node temp=(root.left==null)?root.right:root.left;
                if (temp==null){
                    root=null;
                } else {
                    root = temp; // one child
                }
            }else{
                Node temp = minNodeVal(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
         if (root == null) return root;

         // update height
         root.height = 1 + Math.max(height(root.left), height(root.right));

         int balance = getBalance(root);

         // LL
         if (balance > 1 && getBalance(root.left) >= 0)
             return rotateRight(root);

         // LR
         if (balance > 1 && getBalance(root.left) < 0) {
             root.left = rotateLeft(root.left);
             return rotateRight(root);
         }

         // RR
         if (balance < -1 && getBalance(root.right) <= 0)
             return rotateLeft(root);

         // RL
         if (balance < -1 && getBalance(root.right) > 0) {
             root.right = rotateRight(root.right);
             return rotateLeft(root);
         }

         return root;
     }

}
