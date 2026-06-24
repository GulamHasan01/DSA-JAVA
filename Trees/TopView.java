package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
    public ArrayList<Integer> TopView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<BottomView.Pair> q = new LinkedList<>();

        q.offer(new BottomView.Pair(root, 0));

        while (!q.isEmpty()) {
            BottomView.Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            if (!map.containsKey(hd))
                map.put(hd, node.val);

            if (node.left != null)
                q.offer(new BottomView.Pair(node.left, hd - 1));

            if (node.right != null)
                q.offer(new BottomView.Pair(node.right, hd + 1));
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

