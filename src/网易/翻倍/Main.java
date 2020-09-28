package 网易.翻倍;

import java.util.Scanner;

public class Main {
    private static int minOps(int[] nums) {
        int A = nums[0];
        int B = nums[1];
        int p = nums[2];
        int q = nums[3];

        int ans = 0;
        while (A + p < B) {
            p = p * q;
            ans++;
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][] nums = new int[T][4];
        for(int i = 0; i < T; i++) {
            for(int j = 0; j < 4; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        for(int[] arr : nums) {
            System.out.println(minOps(arr));
        }
    }
}
