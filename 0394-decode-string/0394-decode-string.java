class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder(s);

        while (sb.indexOf("[") != -1) {

            int openIdx = sb.lastIndexOf("[");

            int numStart = openIdx - 1;
            while (numStart >= 0 && Character.isDigit(sb.charAt(numStart))) {
                numStart--;
            }
            numStart++; 
            int repeatCount = Integer.parseInt(sb.substring(numStart, openIdx));

            int closeIdx = openIdx + 1;
            while (closeIdx < sb.length() && sb.charAt(closeIdx) != ']') {
                closeIdx++;
            }

            String word = sb.substring(openIdx + 1, closeIdx);
            StringBuilder expanded = new StringBuilder();
            for (int j = 0; j < repeatCount; j++) {
                expanded.append(word);
            }

            sb.replace(numStart, closeIdx + 1, expanded.toString());
        }

        return sb.toString();
    }
}
