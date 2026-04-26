package Recursion;

public class SumOfDigit {
    public static void main(String[] args) {
            System.out.println(sumOfDig(12345,0));
    }

        public static int sumOfDig(int n,int sum){

            if (n==0){
                return sum;
            }
            int rem= n%10;
            sum=sum+rem;

            return sumOfDig(n/10,sum);
        }

}
