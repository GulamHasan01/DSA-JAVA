class Solution {
    public static String reverseWords(String s) {
        String[]  words=s.trim().split("\\s+");

        int i=0;
        int j=words.length-1;
        while(i<j){
            String word=words[i];
            words[i]=words[j];
            words[j]=word;
            i++;
            j--;
        }

        return String.join(" ",words);
    }
}