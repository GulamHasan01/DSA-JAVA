package Arrays;


public class FindMax {
    public static void main(String[] args) {
        System.out.println(max(new int[]{5,2,8,9,6,8,7}));
        System.out.println(Secondmax(new int[]{5,2,8,9,6,8,7}));
    }
    public static int max(int[] arr){

         int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
          if (arr[i]>max){
             max=arr[i];
          }
        }

return max;
    }

    public static int Secondmax(int[] arr){

        int max=arr[0];
        int secondMax=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                secondMax=max;
                max=arr[i];
            }else if (arr[i]>secondMax && arr[i]<max) secondMax=arr[i];
        }

        return secondMax;
    }
}
