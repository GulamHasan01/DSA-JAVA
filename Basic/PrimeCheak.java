package Basic;

import java.util.Scanner;

public class PrimeCheak {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int x= sc.nextInt();
        if (prime(x)){
            System.out.println("prime");
        }else System.out.println("non prime");

    }
    public static boolean prime(int x){
        int i=2;
        while (i<x){
            if (x%i!=0){
                i++;
            }else{
              return false;
            }
        }
        return true;
    }
}
