class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int max=0;
        int start=0;
        int len=0;
        for(int i=0;i<s.length();i++){
             map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
                 max=Math.max(max,map.get(s.charAt(i)));
            
            if(max<=2) len=Math.max(len,i-start+1);
            while(max>2){
              char left=s.charAt(start++);
              map.put(left,map.getOrDefault(left,0)-1);
              max=map.get(s.charAt(i));
              
            }
        }
       return len; 
    }
}