package String;

public class MaxRepSubStr {
    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc", "ab"));
    }
    public static int maxRepeating(String sequence, String word) {
        int count = 0;
        String temp = word;

        while (sequence.contains(temp)) {
            count++;
            temp += word;
        }

        return count;
    }
}
