package 网易.逆序对距离之和;

import java.util.Scanner;

public class Solution {
    private static long reversedPairSum(int[] nums, int l, int r) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (l >= r) {
            return 0;
        }

        int m = (r - l) / 2 + l;
        long leftSum = reversedPairSum(nums, l, m);
        long rightSum = reversedPairSum(nums, m + 1, r);

        long ls = 0;
        for(int i = l; i <= m; i++) {
            ls += nums[i];
        }

        long sum = 0;
        int i = l, j = m + 1, p = 0;
        int[] temp = new int[r - l + 1];

        while (i <= m && j <= r) {
            if (nums[i] > nums[j]) {
                sum += ls - nums[j] * (m - i + 1);
                temp[p++] = nums[j++];
            } else {
                ls -= nums[i];
                temp[p++] = nums[i++];
            }
        }

        while (i <= m) {
            temp[p++] = nums[i++];
        }

        while (j <= r) {
            temp[p++] = nums[j++];
        }

        p = 0;
        while (l <= r) {
            nums[l++] = temp[p++];
        }

        return leftSum + sum + rightSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] nums = new int[T];
        for(int i = 0; i < T; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(reversedPairSum(nums, 0, T - 1));
    }
}
