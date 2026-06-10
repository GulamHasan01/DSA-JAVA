package Arrays;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class maxTotalValue_II {

        static class Node {
            long val;
            int l, r;

            Node(long val, int l, int r) {
                this.val = val;
                this.l = l;
                this.r = r;
            }
        }

        int[][] maxST;
        int[][] minST;
        int[] log;

        public long maxTotalValue(int[] nums, int k) {
            int n = nums.length;

            buildSparseTable(nums);

            PriorityQueue<Node> pq =
                    new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

            for (int l = 0; l < n; l++) {
                pq.offer(new Node(getValue(l, n - 1), l, n - 1));
            }

            long ans = 0;

            while (k-- > 0) {
                Node cur = pq.poll();
                ans += cur.val;

                if (cur.r > cur.l) {
                    pq.offer(new Node(
                            getValue(cur.l, cur.r - 1),
                            cur.l,
                            cur.r - 1
                    ));
                }
            }

            return ans;
        }

        private void buildSparseTable(int[] nums) {
            int n = nums.length;
            int LOG = 32 - Integer.numberOfLeadingZeros(n);

            maxST = new int[LOG][n];
            minST = new int[LOG][n];
            log = new int[n + 1];

            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }

            for (int i = 0; i < n; i++) {
                maxST[0][i] = nums[i];
                minST[0][i] = nums[i];
            }

            for (int j = 1; j < LOG; j++) {
                int len = 1 << j;
                int half = len >> 1;

                for (int i = 0; i + len <= n; i++) {
                    maxST[j][i] = Math.max(
                            maxST[j - 1][i],
                            maxST[j - 1][i + half]
                    );

                    minST[j][i] = Math.min(
                            minST[j - 1][i],
                            minST[j - 1][i + half]
                    );
                }
            }
        }

        private long getValue(int l, int r) {
            int j = log[r - l + 1];
            int len = 1 << j;

            int mx = Math.max(
                    maxST[j][l],
                    maxST[j][r - len + 1]
            );

            int mn = Math.min(
                    minST[j][l],
                    minST[j][r - len + 1]
            );

            return (long) mx - mn;
        }
    }