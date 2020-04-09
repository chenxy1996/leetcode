package jianZhiOffer._3_findRepeatNumber;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];

        for (int each : nums) {
            if (temp[each] == length) {
                return each;
            } else {
                temp[each] = length;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Solution().findRepeatNumber(nums));
    }
}
