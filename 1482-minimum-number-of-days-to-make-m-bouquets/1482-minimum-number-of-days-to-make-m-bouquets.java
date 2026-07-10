class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int ans = 0;
        if ((long) m * k > bloomDay.length)
            return -1;
        for (int num : bloomDay) {
            low = Math.min(low, num);
            high = Math.max(high, num);

        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isValid(int[] arr, int limit, int m, int k) {
        int have = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= limit) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                count = 0;
                have++;
            }
        }

        if (have >= m)
            return true;

        return false;
    }
}