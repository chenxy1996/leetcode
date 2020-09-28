package 网易.字典序最小的排列;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static int[] generate(int[] nums, int n) {
        int[] map = new int[n + 1];
        for(int num : nums) {
            map[num] = 1;
        }

        int[] temp = new int[n - nums.length];
        int p = 0;
        for(int i = 1; i <= n; i++) {
            if (map[i] == 0) {
                temp[p++] = i;
            }
        }

        int i = 0, j = 0;
        int[] ans = new int[n];
        p = 0;
        while (i < nums.length && j < temp.length) {
            if (nums[i] < temp[j]) {
                ans[p++] = nums[i++];
            } else {
                ans[p++] = temp[j++];
            }
        }
        while (i < nums.length) {
            ans[p++] = nums[i++];
        }
        while (j < temp.length) {
            ans[p++] = temp[j++];
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] nums = {4, 2, 5};
        for(int i : generate(nums, n)) {
            System.out.println(i);
        }
    }
}
