package Arrays;

import java.util.Arrays;

public class maximumElementAfterDecrementingAndRearranging {
    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearrangin(new int[]{10,9,8,7,6,5,4,3,2,1}));
    }
        public static int maximumElementAfterDecrementingAndRearrangin(int[] arr) {

            Arrays.sort(arr);

            arr[0] = 1;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1] + 1) {
                    arr[i] = arr[i - 1] + 1;
                }
            }

            return arr[arr.length - 1];
        }
    }