package 网易.数字圆环;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static boolean check(long[] nums) {
        Arrays.sort(nums);

        long[] arr = new long[nums.length];
        int step = (nums.length + 1) / 2;

        int p = 0;
        for(int i = 0; i < step; i++) {
            for(int j = i; j < nums.length; j += step) {
                arr[p++] = nums[j];
            }
        }

        for(int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] + nums[i + 1] <= nums[i]) {
                return false;
            }
        }

        return nums[0] < (nums[nums.length - 1] + nums[1]) &&
                nums[nums.length - 1] < (nums[nums.length - 2] + nums[0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            long[] arr = new long[n];
            for(int j = 0; j < n; j++) {
                arr[j] = scanner.nextLong();
            }
            if (check(arr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
