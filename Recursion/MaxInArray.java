package Recursion;

public class MaxInArray {
    public static void main(String[] args) {
        System.out.println(maxV(new int[]{1,5,3,2,10,8,7},0,Integer.MIN_VALUE));
    }

    public static int maxV(int[] arr,int i, int max){

        if (i>arr.length-1){
            return max;
        }
        if (arr[i]>max){
            max=arr[i];
        }
        i++;
      return  maxV(arr, i,max);


    }
}
