package Arrays;

public class MinimizeHammingDistanceAfterSwapOperations {
    public static void main(String[] args) {

    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        int count=0;
        if (allowedSwaps[0].length!=0) {
            for (int[] num : allowedSwaps) {
                int temp = source[num[0]];
                source[num[0]] = source[num[1]];
                source[num[1]] = temp;
            }
        }
        for (int i = 0; i < source.length ; i++) {
            if (source[i]!=target[i]) count++;
        }
        return count;
    }
}
