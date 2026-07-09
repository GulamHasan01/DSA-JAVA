class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int start = 1;
        int end = 0;
        int ans = 0;
        for (int num : weights) {
            end += num;
            start = Math.max(start, num);
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(weights, mid, days)) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;
    }

    private boolean isValid(int[] weights, int capacity, int days) {

        int daysUsed = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight > capacity) {
                daysUsed++;
                currentLoad = 0;
            }

            currentLoad += weight;
        }

        return daysUsed <= days;
    }
}