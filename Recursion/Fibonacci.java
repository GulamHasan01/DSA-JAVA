package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        fibo(8);
    }

    public static void fibo(int n){
        System.out.print(0+" "+1);
    helper(n,0,1,3);
    }
    public static void helper(int n,int a,int b,int count){
        int c=a+b;
        System.out.print(" "+c);
        if (count==n){
            return;
        }
        helper(n,b,c,count+1);
    }
}
