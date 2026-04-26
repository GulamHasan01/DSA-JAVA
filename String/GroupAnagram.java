package String;
import java.util .*;

public class GroupAnagram {
        public static void main(String[] args) {
            String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
            System.out.println(groupAnagrams(strs));
        }

        public static List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();

            for (String word : strs) {
                char[] ch = word.toCharArray();
                Arrays.sort(ch);
                String key = new String(ch);

                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(word);
            }

            return new ArrayList<>(map.values());
        }
}
