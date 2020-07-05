<<<<<<< HEAD
package dp.数组中元素相加等于target;

import java.util.Arrays;

// 动态规划解法
public class Solution {
    public static boolean hasTarget(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            if (i == nums[0]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            boolean[] temp = new boolean[target + 1];
            for (int j = 0; j <= target; j++) {
                temp[j] = (j < dp.length ? dp[j] : false) || (j - nums[i] >= 0? dp[j - nums[i]] : false);
            }
            dp = temp;
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(hasTarget(new int[]{2, 3, 4, 5, 12, 34}, 1));
    }
}
=======
package dp.数组中元素相加等于target;

import java.util.Arrays;

// 动态规划解法
public class Solution {
    public static boolean hasTarget(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            if (i == nums[0]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            boolean[] temp = new boolean[target + 1];
            for (int j = 0; j <= target; j++) {
                temp[j] = (j < dp.length ? dp[j] : false) || (j - nums[i] >= 0? dp[j - nums[i]] : false);
            }
            dp = temp;
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(hasTarget(new int[]{2, 3, 4, 5, 12, 34}, 1));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
