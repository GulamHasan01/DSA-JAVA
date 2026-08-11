class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack=new Stack<>();
        stack.push(asteroids[asteroids.length-1]);
        for(int i=asteroids.length-2;i>=0;i--){
            int ele=asteroids[i];
            boolean flag=false;
            while(!stack.isEmpty() && (stack.peek()<0 && ele>0)){
                if(Math.abs(stack.peek())<Math.abs(ele)){
                        stack.pop();
                       
                }else if(Math.abs(stack.peek())==Math.abs(ele)){
                stack.pop();
                flag=true;
                break;
                }else {
                    flag=true;
                    break;
                }
            }
            if(!flag){
                stack.push(ele);
            }
        }
        int[] ans=new int[stack.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=stack.pop();
        }
        return ans;
    }
}