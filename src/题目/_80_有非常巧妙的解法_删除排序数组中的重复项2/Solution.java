package 题目._80_删除排序数组中的重复项2;

import java.util.Arrays;

/**
 * 没有利用到排序这个性质
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        // 从后往前
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int ans = nums.length;
        int p = ans - 1;
        while (p >= 0) {
            for(int i = p; i >= -1; i--) {
                if (i == -1 || nums[i] != nums[p]) {
                    if (p - i > 2) {
                        int s = i + 3;
                        int k = p + 1;
                        while (k < ans) {
                            nums[s++] = nums[k++];
                        }
                        ans -= p - i - 2;
                    }
                    p = i;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3};
        System.out.println(new Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
