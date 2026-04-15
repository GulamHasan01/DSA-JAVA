package Arrays;

import java.util.Arrays;

public class SearchElement {
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 5, 6, 7, 8, 9};
        int x=5;
        System.out.println(search(arr,x));
    }

    private static int search(int[] arr, int x) {

        int start=0,end=arr.length-1;
        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (x > arr[mid]) {
                start = mid + 1;
            } else end = mid - 1;
            if (x == arr[mid]) return mid;
        }
        return 0;
    }
}
