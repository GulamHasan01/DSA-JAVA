class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxRowIndex = 0;
        int maxOnesCount = 0;

        // Iterate through each row to count the number of 1s
        for (int i = 0; i < mat.length; i++) {
            int currentOnes = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    currentOnes++;
                }
            }

            // Update if this row has strictly more 1s than the previous maximum
            if (currentOnes > maxOnesCount) {
                maxOnesCount = currentOnes;
                maxRowIndex = i;
            }
        }

        return new int[]{maxRowIndex, maxOnesCount};
    }
}
