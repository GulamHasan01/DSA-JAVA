package String;

public class FarthestPoinFromOrigin {

    public static void main(String[] args) {

    }

    public int furthestDistanceFromOrigin(String moves) {

        int lc = 0;
        int rc = 0;
        int blank = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') lc++;
            if (c == 'R') rc++;
            if (c == '_') blank++;
        }

        return Math.abs(lc - rc + blank);
    }
}