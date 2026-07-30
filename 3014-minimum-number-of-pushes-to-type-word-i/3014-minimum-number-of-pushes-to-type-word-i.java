class Solution {
    public int minimumPushes(String word) {
     int n=word.length();
     int count =0;
     if(n<9) return n;
     else if(n>8 && n<17){
        count =8;
        n=n-8;
        return count+n*2;
     }else if(n>16 && n<25){
        count=24;
        n=n-16;
        return count+n*3;
     }else{
        count=48;
        n=n-24;
        return count+n*4;
     }
    }
}