package Arrays;

import java.util.Arrays;

// Rotate array to right by k using reversal algorithm

public class RotateAnArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateLeft(new int[]{1, 2, 3, 4, 5}, 2)));
    }
    public static int[] rotateRight(int[] arr,int k){

        k = k % arr.length;

        reverse(arr,0, arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k, arr.length-1);
        return arr;
    }
    public static int[] rotateLeft(int[] arr,int k){

        k = k % arr.length;

        reverse(arr,0, k-1);
        reverse(arr,k, arr.length-1);
        reverse(arr,0, arr.length-1);
        return arr;
    }
    public static void reverse(int[] arr, int start, int end){

        while (start<end) {
           int temp=arr[start];
           arr[start]=arr[end];
           arr[end]=temp;
           start++;
           end--;
        }
    }
}
