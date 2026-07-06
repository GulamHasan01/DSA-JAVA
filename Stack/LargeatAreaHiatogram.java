package Stack;

import java.util.Stack;

public class LargeatAreaHiatogram {
    public static void main(String[] args) {
        System.out.println(largestArea(new int[]{2,1,5,6,2,3}));
    }
    public static int largestArea(int[] heigth){
        int max=0;
        Stack<Integer>stack1=new Stack<>();
        Stack<Integer>stack2=new Stack<>();
        int[] right=new int[heigth.length];
        int[] left=new int[heigth.length];

        for (int i = 0; i < heigth.length; i++) {
            while (!stack1.isEmpty() && heigth[stack1.peek()]>=heigth[i]){
                stack1.pop();
            }
            if (stack1.isEmpty()){
                left[i]=i+1;
            }else {
                left[i]=i-stack1.peek();
            }
            stack1.push(i);
        }

        for (int i = heigth.length-1; i>=0; i--) {
            while (!stack2.isEmpty() && heigth[stack2.peek()]>=heigth[i]){
                stack2.pop();
            }
            if (stack2.isEmpty()){
                right[i]= heigth.length-i;
            }else {
                right[i]=stack2.peek()-i;
            }
            stack2.push(i);
        }
        int[] width=new int[heigth.length];
        for (int i=0;i< heigth.length;i++){
            width[i]=left[i]+right[i]-1;
            max=Math.max(max,width[i]*heigth[i]);
        }

        return max;
    }
}
