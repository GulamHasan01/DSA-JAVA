class Solution {

    // UPDATE: Count how many products are <= mid
    private long countSmallestElement(int[] a, int[] b, long mid) {
        long count = 0;

        for (int x : a) {

            // UPDATE: Handle positive numbers
            if (x > 0) {
                int l = 0, r = b.length - 1;
                int ans = -1;

                while (l <= r) {
                    int m = l + (r - l) / 2;

                    if ((long) x * b[m] <= mid) {
                        ans = m;
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }

                count += ans + 1;
            }

            // UPDATE: Handle negative numbers
            else if (x < 0) {
                int l = 0, r = b.length - 1;
                int ans = b.length;

                while (l <= r) {
                    int m = l + (r - l) / 2;

                    if ((long) x * b[m] <= mid) {
                        ans = m;
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }

                count += b.length - ans;
            }

            // UPDATE: Handle zero
            else {
                if (mid >= 0)
                    count += b.length;
            }
        }

        return count;
    }

    public long kthSmallestProduct(int[] a, int[] b, long k) {

        // UPDATE: Binary search range
        long p1 = (long) a[0] * b[0];
        long p2 = (long) a[0] * b[b.length - 1];
        long p3 = (long) a[a.length - 1] * b[0];
        long p4 = (long) a[a.length - 1] * b[b.length - 1];

        long l = Math.min(Math.min(p1, p2), Math.min(p3, p4));
        long h = Math.max(Math.max(p1, p2), Math.max(p3, p4));

        long ans = l;

        while (l <= h) {

            long mid = l + (h - l) / 2;

            // UPDATE: O(n log m) counting
            long count = countSmallestElement(a, b, mid);

            if (count >= k) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}