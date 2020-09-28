package 网易.参加考试;

import java.util.Scanner;

public class Main {
    private static int getMaxScore(int[] nums) {
        int sum = 0;
        for(int each : nums) {
            sum += each;
        }
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            for(int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        int ans = 0;
        for(int j = sum; j >= 0; j--) {
            if (dp[j] == false || notHaveFive(j) == false) {
                continue;
            }
            ans = j;
            break;
        }
        return ans;
    }

    private static boolean notHaveFive(int num) {
        while (num != 0) {
            if (num % 10 == 5) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5, 15, 5, 15, 5};
        System.out.println(getMaxScore(nums));
//        System.out.println(notHaveFive(5));
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        System.out.println();
    }
}
