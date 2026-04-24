package Basic;

public class ReverseTheNumber {
    public static void main(String[] args) {
        System.out.println(reverse(64234));
        palindrome(12321);
    }

    public static int reverse(int x){
        int rev=0;

        while (x >= 1) {
            int rem = x % 10;
            rev = rev * 10 + rem;
            x = x / 10;
        }

        return rev;
    }

    public static void palindrome(int x){
        if (x==reverse(x)){
            System.out.println("palindrome");
        }else {
            System.out.println("not palindrome");
        }
    }
}
