package Math;

import java.util.Arrays;

public class MaxBuildingHeigth {
        public int maxBuilding(int n, int[][] restrictions) {
            int m = restrictions.length;

            int[][] arr = new int[m + 1][2];
            arr[0] = new int[]{1, 0};

            for (int i = 0; i < m; i++) {
                arr[i + 1] = restrictions[i];
            }

            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            // Left to Right
            for (int i = 1; i <= m; i++) {
                arr[i][1] = Math.min(
                        arr[i][1],
                        arr[i - 1][1] + (arr[i][0] - arr[i - 1][0])
                );
            }

            // Right to Left
            for (int i = m - 1; i >= 0; i--) {
                arr[i][1] = Math.min(
                        arr[i][1],
                        arr[i + 1][1] + (arr[i + 1][0] - arr[i][0])
                );
            }

            int ans = 0;

            for (int i = 1; i <= m; i++) {
                long d = arr[i][0] - arr[i - 1][0];
                long h1 = arr[i - 1][1];
                long h2 = arr[i][1];

                ans = Math.max(ans,
                        (int)((h1 + h2 + d) / 2)
                );
            }

            // Last segment to building n
            ans = Math.max(ans,
                    arr[m][1] + (n - arr[m][0])
            );

            return ans;
        }
    }