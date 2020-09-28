package 网易.完美的序列;

import java.util.Scanner;

public class Solution {
    private static int maxPerfect(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int l = 0, r = 0;
        int ans = 0;
        while (r < nums.length) {
            int val = nums[r];
            if (val >= sum) {
                sum += val;
                r++;
                ans = Math.max(ans, r - l);
            } else {
                sum -= nums[l];
                l++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            System.out.println(maxPerfect(nums));
        }
    }
}
