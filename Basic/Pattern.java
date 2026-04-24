package Basic;

public class Pattern {
    public static void main(String []args){
        printSquare(8);
        printInvertedTrangel(5);
    }

    public static void printSquare(int n){
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <= n; j++) {
                if (i==0 || j==0 || i==n || j==n){
                    System.out.print("*");
                }else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void printInvertedTrangel(int n){
        for (int i = n; i >=0 ; i--) {
            for (int j = i-1; j <= n; j++) {
                System.out.print(" ");
            }
            for (int j = 2*i; j >=0; j--) {
                System.out.print(i);
            }

            System.out.println();
        }
    }
}
