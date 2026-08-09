class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return list;
        }

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }

        int require = need.size();
        int have = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);

            if (need.containsKey(rChar)) {
                window.put(rChar, window.getOrDefault(rChar, 0) + 1);
        
                if (window.get(rChar).equals(need.get(rChar))) {
                    have++;
                }
            }

          
            if (right - left + 1 > p.length()) {
                char lChar = s.charAt(left);
                if (need.containsKey(lChar)) {
               
                    if (window.get(lChar).equals(need.get(lChar))) {
                        have--;
                    }
                    window.put(lChar, window.get(lChar) - 1);
                }
                left++;
            }

           
            if (have == require) {
                list.add(left);
            }
        }

        return list;
    }
}
