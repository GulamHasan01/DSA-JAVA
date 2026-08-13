class Solution {
    public int matchPlayersAndTrainers(int[] g, int[] s) {
       Arrays.sort(s);
        Arrays.sort(g);

        int i=0;
        int j=0;
        int count=0;
        while(i<g.length && j<s.length){
         if(g[i]<=s[j]){
            count++;
            i++;
            j++;
         }else{
            j++;
         }
        }
        return count;
    }
}