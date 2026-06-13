package String;

import java.util.HashMap;

public class mapWordWeight {
    public String mapWordWeights(String[] words, int[] weights) {
        HashMap<Integer,Character> map=new HashMap<>();
        int value = 25;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(value,ch);
            value--;
        }
        int len=0;
        StringBuilder sb=new StringBuilder();
        for (String str:words){
            int wordlen=str.length();
            int sum=0;
            while (len<wordlen){
                sum+=weights[len];
                len++;
            }
            sb.append(map.get(sum%26));
        }
        return sb.toString();
    }
}
