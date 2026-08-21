import java.util.ArrayList;
import java.util.List;

class Solution {

    private static class Subset {
        long lcm;
        int sign;

        Subset(long lcm, int sign) {
            this.lcm = lcm;
            this.sign = sign;
        }
    }

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        List<Subset> subsets = new ArrayList<>();

        int totalSubsets = 1 << n;
        for (int i = 1; i < totalSubsets; i++) {
            long currentLcm = 1;
            int elementsCount = 0;
            boolean overflow = false;

            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    elementsCount++;
                    currentLcm = lcm(currentLcm, coins[j]);

                    if (currentLcm > 50_000_000_000L) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                int sign = (elementsCount % 2 != 0) ? 1 : -1;
                subsets.add(new Subset(currentLcm, sign));
            }
        }

        long left = 1;
        long minCoin = coins[0];
        for (int coin : coins) {
            if (coin < minCoin)
                minCoin = coin;
        }
        long right = minCoin * k;
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (countMultiples(mid, subsets) >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private long countMultiples(long mid, List<Subset> subsets) {
        long totalCount = 0;
        for (Subset subset : subsets) {
            totalCount += subset.sign * (mid / subset.lcm);
        }
        return totalCount;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
