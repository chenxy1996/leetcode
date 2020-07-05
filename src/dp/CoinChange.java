package dp;

import java.util.Arrays;

public class CoinChange {
    private static int[] notes = {3, 5};

    public static class DfsSolution {
        private int minNumber(int sum, int maxNote) {
            if (sum == 0) {
                return 0;
            }

            if (sum < 0) {
                return -1;
            }

            int min = Integer.MAX_VALUE;
            for (int note : notes) {
                if (note <= maxNote) {
                    int currentNumber = minNumber(sum - note, note);
                    if (currentNumber < Integer.MAX_VALUE && currentNumber >= 0) {
                        min = Math.min(min, currentNumber + 1);
                    }
                }
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }

        public int getMinNumber(int sum) {
            return minNumber(sum, notes[0]);
        }
    }

    public static class DpSolution {
        public int getMinNumber(int sum) {
            int[] dp = new int[sum + 1];
            Arrays.fill(dp, sum + 1);
            dp[0] = 0;
            for (int i = 1; i <= sum; i++) {
                for (int note : notes) {
                    if (i - note >= 0 ) {
                        dp[i] = Math.min(dp[i], dp[i - note] + 1);
                    }
                }
            }
            return dp[sum] > sum ? -1 : dp[sum];
        }
    }

    public static void main(String[] args) {
        DfsSolution dfsSolution = new DfsSolution();
        System.out.println(dfsSolution.getMinNumber(1));

//        DpSolution dpSolution = new DpSolution();
//        System.out.println(dpSolution.getMinNumber(4));
    }
}
