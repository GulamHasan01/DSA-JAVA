package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

        public ArrayList<Integer> bottomView(Node root) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (root == null) return ans;

            TreeMap<Integer, Integer> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<>();

            q.offer(new Pair(root, 0));

            while (!q.isEmpty()) {
                Pair curr = q.poll();
                Node node = curr.node;
                int hd = curr.hd;

                map.put(hd, node.val);

                if (node.left != null)
                    q.offer(new Pair(node.left, hd - 1));

                if (node.right != null)
                    q.offer(new Pair(node.right, hd + 1));
            }

            for (int val : map.values())
                ans.add(val);

            return ans;
        }

        static class Pair {
            Node node;
            int hd;

            Pair(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

}
