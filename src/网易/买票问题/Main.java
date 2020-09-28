package 网易.买票问题;

public class Main {
    public static int minTime(int n, int[] arr1, int[] arr2) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int p1 = i - 1;
            int p2 = i - 2;
            if (p2 >= 0) {
                dp[i] = Math.min(dp[i - 2] + arr2[p2], dp[i - 1] + arr1[p1]);
            } else {
                dp[i] = dp[i - 1] + arr1[p1];
            }
        }
        return dp[n];
    }

    private static void transfer(int seconds) {
        StringBuilder sb = new StringBuilder();
        String flag;

        int h = seconds / 3600 + 8;
        if (h > 12) {
            flag = "PM";
        } else {
            flag = "AM";
        }
        sb.append(padding(h) + ":");

        seconds %= 3600;
        sb.append(padding(seconds / 60) + ":");
        sb.append(padding(seconds % 60) + " ");

        sb.append(flag);

        System.out.println(sb);
    }

    private static String padding(int n) {
        if (n < 10) {
            return "0" + n;
        }
        return String.valueOf(n);
    }

    public static void main(String[] args) {
        int[] arr1 = {200, 100, 300, 400, 200};
        int[] arr2 = {200, 300, 500, 400};
        int n = 5;
        System.out.println(minTime(n, arr1, arr2));
        System.out.println(Solution.minTime(n, arr1, arr2));

        int seconds = 6987;
        System.out.println(Solution.helper(seconds));
        transfer(seconds);
    }
}
