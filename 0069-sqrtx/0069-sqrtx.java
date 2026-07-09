class Solution {
    public int mySqrt(int x) {
        int low = 1;
        int ans = 0;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x/ mid == mid) {
                return mid;
            } else if (x/ mid > mid) {
                ans = mid;
                low = mid + 1;
            } else {
                 high = mid - 1;
               
            }
        }
        return ans;
    }
}