class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sb.append(ch);
            
            if (sb.length() * 2 > s.length()) return false;
            
            int window = sb.length();
            if (s.length() % window != 0) continue;
            
            String sub = s.substring(window, window + window);
            
            if (sub.equals(sb.toString())) {
                int counter = window + window;
                boolean match = true;
                
                while (counter < s.length()) {
                    sub = s.substring(counter, counter + window);
                    if (!sub.equals(sb.toString())) {
                        match = false;
                        break;
                    }
                    counter = counter + window;
                }
                
                if (match && counter == s.length()) return true;
            }
        }
        return false;
    }
}
