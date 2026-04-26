package Arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr={5,2,8,9,8,6,3,1};
        System.out.println(Arrays.toString(reverse(arr,0, arr.length-1)));
    }

    private static int[] reverse(int[] arr,int i,int j) {

       if (i>j){
           return arr;
       }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
       reverse(arr,i+1,j-1);
        return arr;
    }
}
