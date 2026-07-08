class Solution {
    public String frequencySort(String s) {
     if (s == null || s.isEmpty()) {
            return s;
        }

        // 1. LinkedHashMap tracks frequency while keeping the "first appearance" order
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(freqMap.keySet());

    
        Collections.sort(chars, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            
            if (freqA != freqB) {
                return Integer.compare(freqB, freqA); 
            }
            return 0; 
        });

        
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            int count = freqMap.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

}