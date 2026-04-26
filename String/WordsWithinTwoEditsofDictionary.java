package String;

import java.util.*;

public class WordsWithinTwoEditsofDictionary {

    public static void main(String[] args) {
        System.out.println(twoEditWords(
                new String[]{"word","note","ants","wood"},
                new String[]{"wood","joke","moat"}
        ));
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String> result = new ArrayList<>();

        for (String q : queries) {

            for (String d : dictionary) {

                int diff = 0;

                for (int i = 0; i < q.length(); i++) {
                    if (q.charAt(i) != d.charAt(i)) {
                        diff++;
                    }
                    if (diff > 2) break;
                }

                if (diff <= 2) {
                    result.add(q);
                    break;
                }
            }
        }

        return result;
    }
}