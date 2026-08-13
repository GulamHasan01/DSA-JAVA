class Solution {
    private static class Node {
        int max;
        int pref;
        int suff;
        int size;
        
        Node(int size) {
            this.max = 1;
            this.pref = 1;
            this.suff = 1;
            this.size = size;
        }
    }

    private Node[] tree;
    private char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        this.chars = s.toCharArray();
        this.tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            
            update(1, 0, n - 1, idx, ch);
            
            ans[i] = tree[1].max;
        }
        return ans;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(1);
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        
        tree[node] = merge(tree[2 * node], tree[2 * node + 1], mid, start, end);
    }

    private void update(int node, int start, int end, int idx, char ch) {
        if (start == end) {
            chars[idx] = ch;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, ch);
        } else {
            update(2 * node + 1, mid + 1, end, idx, ch);
        }
        
        tree[node] = merge(tree[2 * node], tree[2 * node + 1], mid, start, end);
    }

    private Node merge(Node left, Node right, int mid, int start, int end) {
        Node parent = new Node(end - start + 1);
        
        parent.pref = left.pref;
        parent.suff = right.suff;
        parent.max = Math.max(left.max, right.max);

        if (chars[mid] == chars[mid + 1]) {
            if (left.pref == left.size) {
                parent.pref = left.size + right.pref;
            }
            if (right.suff == right.size) {
                parent.suff = right.size + left.suff;
            }
            parent.max = Math.max(parent.max, left.suff + right.pref);
        }
        
        parent.max = Math.max(parent.max, Math.max(parent.pref, parent.suff));
        return parent;
    }
}
