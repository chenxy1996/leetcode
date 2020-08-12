package 面试金典._17_其它问题._04_第二次做还是没有想出来怎么做_消失的数字;

/**
 * 这道题和剑指 offer 53_2 类似
 */
public class Solution {
    public static int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= i;
            ans ^= nums[i];
        }
        ans ^= nums.length;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(missingNumber(nums));
    }
}
