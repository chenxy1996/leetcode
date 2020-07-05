<<<<<<< HEAD
<<<<<<< HEAD
package dp;

import dfs._93_restoreIpAddresses.Solution;

public class RestoreIpAddressNumber {
    public static int restoredIpNumber(String s) {
        int[] dp = new int[s.length()];

        // 初始化 dp  数组，前三项一定为 1
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 0; i < 3; i++) {
            int[] temp = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                if (j - 1 >= 0) {
                    temp[j] += dp[j - 1];
                }

                if (j - 2 >= 0) {
                    String s1 = s.substring(j - 1, j + 1);
                    if (s1.charAt(0) != '0') {
                        temp[j] += dp[j - 2];
                    }
                }

                if (j - 3 >= 0) {
                    String s1 = s.substring(j - 2, j + 1);
                    if (s1.charAt(0) != '0' && Integer.parseInt(s1) <= 255) {
                        temp[j] += dp[j - 3];
                    }
                }
            }

            dp = temp;
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        RestoreIpAddressNumber solution = new RestoreIpAddressNumber();
        System.out.println(solution.restoredIpNumber("19216801"));
        String s;
    }
}
=======
package dp;

import dfs._93_restoreIpAddresses.Solution;

public class RestoreIpAddressNumber {
    public static int restoredIpNumber(String s) {
        int[] dp = new int[s.length()];

        // 初始化 dp  数组，前三项一定为 1
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 0; i < 3; i++) {
            int[] temp = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                if (j - 1 >= 0) {
                    temp[j] += dp[j - 1];
                }

                if (j - 2 >= 0) {
                    String s1 = s.substring(j - 1, j + 1);
                    if (s1.charAt(0) != '0') {
                        temp[j] += dp[j - 2];
                    }
                }

                if (j - 3 >= 0) {
                    String s1 = s.substring(j - 2, j + 1);
                    if (s1.charAt(0) != '0' && Integer.parseInt(s1) <= 255) {
                        temp[j] += dp[j - 3];
                    }
                }
            }

            dp = temp;
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        RestoreIpAddressNumber solution = new RestoreIpAddressNumber();
        System.out.println(solution.restoredIpNumber("19216801"));
        String s;
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
=======
package dp;

import dfs._93_restoreIpAddresses.Solution;

public class RestoreIpAddressNumber {
    public static int restoredIpNumber(String s) {
        int[] dp = new int[s.length()];

        // 初始化 dp  数组，前三项一定为 1
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 0; i < 3; i++) {
            int[] temp = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                if (j - 1 >= 0) {
                    temp[j] += dp[j - 1];
                }

                if (j - 2 >= 0) {
                    String s1 = s.substring(j - 1, j + 1);
                    if (s1.charAt(0) != '0') {
                        temp[j] += dp[j - 2];
                    }
                }

                if (j - 3 >= 0) {
                    String s1 = s.substring(j - 2, j + 1);
                    if (s1.charAt(0) != '0' && Integer.parseInt(s1) <= 255) {
                        temp[j] += dp[j - 3];
                    }
                }
            }

            dp = temp;
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        RestoreIpAddressNumber solution = new RestoreIpAddressNumber();
        System.out.println(solution.restoredIpNumber("19216801"));
    }
}
>>>>>>> b401e4cbce140a03a2c9946c5735a15648800108
