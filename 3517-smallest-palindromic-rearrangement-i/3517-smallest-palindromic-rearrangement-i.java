class Solution {
    public String smallestPalindrome(String s) {
  
     char[] ch=s.toCharArray();
     Arrays.sort(ch,0,ch.length/2);
     int j=(ch.length/2);
     int k=0;
     for(int i=ch.length-1;i>=j;i--){
        ch[i]=ch[k++];
     }
     String ans= new String(ch);
     return ans;
    }
}