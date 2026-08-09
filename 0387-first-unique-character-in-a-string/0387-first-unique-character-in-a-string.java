class Solution {
    public int firstUniqChar(String s) {
        int[]fre=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            fre[ch-'a']++;
        }
        for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
            if(fre[ch-'a']==1){
                return i;
            }
        }
        return -1;
    }
}