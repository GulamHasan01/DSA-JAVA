package Arrays;

public class SumofArray {
    public static void main(String[] args) {
        System.out.println(sum(new int[]{5,2,8,9,6,8,7}));
    }

    public static int sum(int[] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
        }
        return sum;
    }
}
