package Arrays;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(missingNumber(5,new int[]{0,1,3,4}));
        System.out.println(astd(new int[]{5,-8,11,-4,-3}));
    }
    public static int missingNumber(int n,int[]arr){
        int xor=0;
        for (int i = 0; i <n ; i++) {
            xor=xor^i;
        }
        for (int num:arr){
            xor^=num;
        }
        return xor;
    }

    public static Stack<Integer> astd(int[]arr){
        Stack<Integer>stack=new Stack<>();
        for (int num:arr){
            if (!stack.isEmpty() && stack.peek()>0 && num<0){
                int ans=stack.pop()+num;
                stack.push(ans);
            }else stack.push(num);
        }
        return stack;
    }
}
