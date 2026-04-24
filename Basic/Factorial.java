package Basic;

public class Factorial {
    public static void main(String[] args){
        System.out.println(fact(5));
    }
    public static int fact(int x){
     if (x<=2){
         return x;
     }
        return x*fact(x-1);
    }
}
