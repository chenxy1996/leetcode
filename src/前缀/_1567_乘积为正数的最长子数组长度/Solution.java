package 前缀._1567_乘积为正数的最长子数组长度;

public class Solution {
    public static int getMaxLen(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pos = 0;
        int pas = 0;
        int max = 0;
        for(int num : nums) {
            if (num == 0) {
                pos = 0;
                pas = 0;
            } else if (num > 0) {
                pos += 1;
                if(pas > 0) {
                    pas += 1;
                } else {
                    pas = 0;
                }
            } else {
                int temp = pos;
                if (pas > 0) {
                    pos = pas + 1;
                } else {
                    pos = 0;
                }
                pas = temp + 1;
            }
            max = Math.max(max, pos);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,0,1};
        System.out.println(getMaxLen(nums));
    }
}
