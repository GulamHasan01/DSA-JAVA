package Arrays;

import java.util.Arrays;

public class CountOddEven {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(count(new int[]{5,2,8,9,6,8,7})));
    }

    private static int[] count(int[] arr) {
        int ans[]=new int[2];
        int even=0;
        int odd=0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 == 0) {
                even++;
            }else odd++;
        }
        ans[0]=even;
        ans[1]=odd;

        return ans;
    }

}
