class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;
        
        for (int l = 0, r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            
            if (sum == target) {
                int currLen = r - l + 1;
                // Check if a valid subarray exists before index 'l'
                if (l > 0 && best[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currLen + best[l - 1]);
                }
                minLen = Math.min(minLen, currLen);
            }
            
            best[r] = minLen;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}