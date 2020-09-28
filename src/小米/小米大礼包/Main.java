package 小米.小米大礼包;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static boolean dp(int[] nums, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++) {
            for(int j = sum; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int t = scanner.nextInt();
        if (dp(nums, t)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
