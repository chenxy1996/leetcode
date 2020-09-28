package 网易.代价;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[3];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int ans = 0;
        ans += (nums[1] - nums[0] + nums[2] - nums[1]);
        System.out.println(ans);
    }
}
