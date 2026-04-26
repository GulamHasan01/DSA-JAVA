package Recursion;

public class PowerOfN {
    public static void main(String[] args){
        System.out.println(power(5,4));
    }

    public static int power(int n,int x){
        if (n<2){
            return n;
        }
        if (x==0){
            return 1;
        }
        if (x==1){
            return n;
        }
        return n* power(n,x-1);
    }
}
