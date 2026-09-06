class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int currentEnd = arr[0][1];

        for (int i = 1; i < arr.length; i++) {

            if (currentEnd > arr[i][0]) {
              count++;
                currentEnd = Math.min(currentEnd, arr[i][1]);

            } else {
               
                currentEnd = arr[i][1];
            }
        }

        return count;
    }
}