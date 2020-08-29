package 单调栈._334_递增的三元子数组;

public class Solution {
    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] deque = new int[3];
        deque[0] = nums[0];
        int p = 0;
        for(int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int j = p + 1;
            while (j - 1 >= 0 && deque[j - 1] >= val) {
                j--;
            }
            if (j == 2) {
                return true;
            }
            deque[j] = val;
            if (j > p) {
                p++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1};
        System.out.println(increasingTriplet(nums));
    }
}
