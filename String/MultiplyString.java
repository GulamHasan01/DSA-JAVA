package String;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyString {
    public static void main(String[] args) {
     MultiplyString md=new MultiplyString();
        System.out.println(md.multiply("123","2"));
    }
    public String multiply1(String num1, String num2) {
        Scanner sc=new Scanner(num1);
        BigInteger n1= sc.nextBigInteger();
        sc.close();
        Scanner ss=new Scanner(num2);
       BigInteger n2= ss.nextBigInteger();
      ss.close();

        return String.valueOf(n1.multiply(n2));
    }

    public String multiply(String num1, String num2) {
        // Edge case: If either number is "0", the total product is instantly "0"
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();

        // Max possible length of the resulting product array is len1 + len2
        int[] pos = new int[len1 + len2];

        // Loop backward from right-to-left through both numbers
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {

                // Manual ASCII conversion for single digit characters
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                // Multiply the single digits
                int mul = digit1 * digit2;

                // Determine array index positions for the current calculation step
                int p1 = i + j;     // Carry position
                int p2 = i + j + 1; // Sum position

                // Add current product to any existing value in the sum position
                int sum = mul + pos[p2];

                // Calculate the carry and update the positions in our array
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        // Build the final string result from our integer array
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // Skip leading zeros if the highest indices didn't need a carry overflow
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.toString();
    }

}
