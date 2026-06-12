package Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        SecondLargest sl=new SecondLargest();
        System.out.println(sl.getSecondLargest(new int[]{10,5,10}));
    }
    public int getSecondLargest(int[] arr) {
        // code here
    int max=0;
    int secondmax=Integer.MAX_VALUE;

    for(int num:arr){
      if (num>max){
          secondmax=max;
          max=num;
      } else if (secondmax<num && num<max) {
          secondmax=num;
      }
    }

    return secondmax;
    }
}
