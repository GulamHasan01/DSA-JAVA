class Solution {
 private static class Interval implements Comparable<Interval> {
        int l, r, w, id;

        Interval(int l, int r, int w, int id) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.id = id;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.r != other.r) {
                return Integer.compare(this.r, other.r);
            }
            return Integer.compare(this.l, other.l);
        }
    }

    private static class DPState {
        long weight;
        List<Integer> path;

        DPState(long weight, List<Integer> path) {
            this.weight = weight;
            this.path = path;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] A = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervals.get(i);
            A[i] = new Interval(interval.get(0), interval.get(1), interval.get(2), i);
        }

        Arrays.sort(A);

        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            ends[i] = A[i].r;
        }

        DPState[][] dp = new DPState[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new DPState(0, new ArrayList<>());
            }
        }

        for (int i = 1; i <= n; i++) {
            int l = A[i - 1].l;
            long w = A[i - 1].w;
            int idx = A[i - 1].id;

            int j = lowerBound(ends, l);

            for (int k = 1; k <= 4; k++) {
                long bestW = dp[i - 1][k].weight;
                List<Integer> bestPath = dp[i - 1][k].path;

                long takeW = w + dp[j][k - 1].weight;
                List<Integer> takePath = new ArrayList<>(dp[j][k - 1].path);
                takePath.add(idx);
                Collections.sort(takePath);

                if (takeW > bestW) {
                    bestW = takeW;
                    bestPath = takePath;
                } else if (takeW == bestW) {
                    if (bestPath.isEmpty() || isLexicographicallySmaller(takePath, bestPath)) {
                        bestPath = takePath;
                    }
                }

                dp[i][k] = new DPState(bestW, bestPath);
            }
        }

        List<Integer> resultList = dp[n][4].path;
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isLexicographicallySmaller(List<Integer> a, List<Integer> b) {
        int minLen = Math.min(a.size(), b.size());
        for (int i = 0; i < minLen; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
}