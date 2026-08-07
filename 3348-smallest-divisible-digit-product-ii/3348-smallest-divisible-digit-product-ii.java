class Solution {
    private static final int[] PRIMES = {2, 3, 5, 7};
    private static final int[][] DIGIT_FACTORS = {
        {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}, {0, 1, 0, 0}, {2, 0, 0, 0},
        {0, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 1}, {3, 0, 0, 0}, {0, 2, 0, 0}
    };

    public String smallestNumber(String num, long t) {
        int[] targetFactors = new int[4];
        long tempT = t;
        for (int i = 0; i < 4; i++) {
            while (tempT % PRIMES[i] == 0) {
                targetFactors[i]++;
                tempT /= PRIMES[i];
            }
        }
        if (tempT > 1) return "-1";

        int n = num.length();
        int[][] prefixFactors = new int[n + 1][4];
        int firstZero = -1;

        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            if (digit == 0 && firstZero == -1) {
                firstZero = i;
            }
            for (int j = 0; j < 4; j++) {
                prefixFactors[i + 1][j] = prefixFactors[i][j] + (digit == 0 ? 0 : DIGIT_FACTORS[digit][j]);
            }
        }

        if (firstZero == -1) {
            if (canSatisfy(targetFactors, prefixFactors[n], 0)) {
                return num;
            }
        }

        int limit = (firstZero == -1) ? n - 1 : firstZero;
        for (int i = limit; i >= 0; i--) {
            int currentDigit = num.charAt(i) - '0';
            for (int nextDigit = currentDigit + 1; nextDigit <= 9; nextDigit++) {
                int[] currentFactors = new int[4];
                for (int j = 0; j < 4; j++) {
                    currentFactors[j] = prefixFactors[i][j] + DIGIT_FACTORS[nextDigit][j];
                }
                int remainingLength = n - 1 - i;
                if (canSatisfy(targetFactors, currentFactors, remainingLength)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(nextDigit);
                    fillOptimalSuffix(sb, targetFactors, currentFactors, remainingLength);
                    return sb.toString();
                }
            }
        }

        int newLength = n + 1;
        while (true) {
            int[] currentFactors = new int[4];
            if (canSatisfy(targetFactors, currentFactors, newLength)) {
                StringBuilder sb = new StringBuilder();
                fillOptimalSuffix(sb, targetFactors, currentFactors, newLength);
                return sb.toString();
            }
            newLength++;
        }
    }

    private boolean canSatisfy(int[] target, int[] current, int availableLen) {
        int req2 = Math.max(0, target[0] - current[0]);
        int req3 = Math.max(0, target[1] - current[1]);
        int req5 = Math.max(0, target[2] - current[2]);
        int req7 = Math.max(0, target[3] - current[3]);

        int slots = req5 + req7;
        slots += (req3 + 1) / 2;
        
        int rem3 = req3 % 2;
        int rem2 = req2;
        if (rem3 == 1 && rem2 > 0) {
            rem2--;
        }
        slots += (rem2 + 2) / 3;
        return slots <= availableLen;
    }

    private void fillOptimalSuffix(StringBuilder sb, int[] target, int[] current, int length) {
        if (length == 0) return;
        int req2 = Math.max(0, target[0] - current[0]);
        int req3 = Math.max(0, target[1] - current[1]);
        int req5 = Math.max(0, target[2] - current[2]);
        int req7 = Math.max(0, target[3] - current[3]);

        char[] suffix = new char[length];
        int idx = 0;

        while (req3 >= 2) { suffix[idx++] = '9'; req3 -= 2; }
        while (req2 >= 3) { suffix[idx++] = '8'; req2 -= 3; }
        while (req7 > 0) { suffix[idx++] = '7'; req7--; }
        while (req5 > 0) { suffix[idx++] = '5'; req5--; }

        if (req3 == 1 && req2 == 2) {
            suffix[idx++] = '2';
            suffix[idx++] = '6';
        } else if (req3 == 1 && req2 == 1) {
            suffix[idx++] = '6';
        } else if (req3 == 1 && req2 == 0) {
            suffix[idx++] = '3';
        } else if (req3 == 0 && req2 == 2) {
            suffix[idx++] = '4';
        } else if (req3 == 0 && req2 == 1) {
            suffix[idx++] = '2';
        }

        while (idx < length) {
            suffix[idx++] = '1';
        }

        Arrays.sort(suffix);
        sb.append(new String(suffix));
    }
}
