package Recursion;

public class CountDigits {
    public static void main(String[] args) {
        System.out.println(count(-1234,0));
    }

    public static int count(int n,int count){
        if (n==0){
            return count;
        }

     return count(n/10,count+1);
    }
}
