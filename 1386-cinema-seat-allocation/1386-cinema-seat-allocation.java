class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, boolean[]> map = new HashMap<>();

        for (int[] seat : reservedSeats) {

            int row = seat[0];

            if (!map.containsKey(row)) {
                map.put(row, new boolean[10]);
            }

            map.get(row)[seat[1] - 1] = true;
        }

        int count = (n - map.size()) * 2;

        for (int row : map.keySet()) {

            boolean[] matrix = map.get(row);

            if (!matrix[1] && !matrix[2] &&
                !matrix[3] && !matrix[4]) {

                if (!matrix[5] && !matrix[6] &&
                    !matrix[7] && !matrix[8]) {

                    count += 2;

                } else {
                    count++;
                }

            } else if (!matrix[3] && !matrix[4] &&
                       !matrix[5] && !matrix[6]) {

                count++;

            } else if (!matrix[5] && !matrix[6] &&
                       !matrix[7] && !matrix[8]) {

                count++;
            }
        }

        return count;
    }
}