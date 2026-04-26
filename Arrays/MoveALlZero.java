package Arrays;

import java.util.Arrays;

public class MoveALlZero {

    public static void main(String[] args) {
        int[] arr={0,0,1,2,0,3,4,0,5};
        System.out.println(Arrays.toString(allZeroLast(arr)));
    }



    public static int[] allZeroLast(int[] arr){

        int j=1;
        int i=0;
        while(j<arr.length) {
            if (arr[i] == 0 && arr[j] != 0) {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }else if(arr[j]==0 && arr[i]==0){
                j++;
            }
        }
        return arr;
    }
}
