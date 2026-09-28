class Solution {
    public int maxDepth(String s) {
        int maxCount=0;
        int count=0;
        Stack<Character>stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)==')' ){
                stack.push(s.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek()==')'){
                count++;
            }else{
                maxCount=Math.max(maxCount,count);
                count-=1;
            }
            stack.pop();
        }
        return maxCount;
    }
}