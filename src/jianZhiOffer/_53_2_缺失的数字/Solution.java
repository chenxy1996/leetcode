package jianZhiOffer._53_2_缺失的数字;

// 这道题用二分更好
public class Solution {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            int valL = nums[l];
            int valR = nums[r];
            if (valL != l) {
                return l;
            }
            if (valR != r + 1) {
                return r + 1;
            }
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0};
        System.out.println(solution.missingNumber(nums));
    }
}
