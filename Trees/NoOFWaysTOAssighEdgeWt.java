package Trees;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class NoOFWaysTOAssighEdgeWt {

    public static void main(String[] args) {
        NoOFWaysTOAssighEdgeWt wy=new NoOFWaysTOAssighEdgeWt();
        int[][]mat={{2,3},{1,2}};
        System.out.println( wy.assignEdgeWeights(mat));

    }
    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public Node constructTree(int[][] mat) {
        if (mat == null || mat.length == 0) return null;

        Map<Integer, Node> map = new HashMap<>();
        HashSet<Integer> children=new HashSet<>();
        Node root = null;

        for (int[] num : mat) {
            int parentVal = num[0];
            int childVal = num[1];

            map.putIfAbsent(parentVal, new Node(parentVal));
            map.putIfAbsent(childVal, new Node(childVal));

            Node parentNode = map.get(parentVal);
            Node childNode = map.get(childVal);

            if (parentNode.left == null) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            if (root == null) {
                root = parentNode;
            }
            children.add(childVal);
        }

        for (int[] num : mat) {

            if (!children.contains(num[0])) {
                root = map.get(num[0]);
                break;
            }

        }
        return root;
    }


    public int noOfWay(Node root) {
        if (root == null) {
            return 0;
        }
        int left = noOfWay(root.left);
        int right = noOfWay(root.right);

        return 1 + Math.max(left, right);
    }
    public int assignEdgeWeights(int[][] edges) {
        Node root = constructTree(edges);
        if (root == null) return 0;

        int k = noOfWay(root) - 1;
        if (k <= 0) return 0;

        long mod = 1_000_000_007;
        return (int) power(2, k - 1, mod);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
