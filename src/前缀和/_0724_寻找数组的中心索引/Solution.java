package 前缀和._0724_寻找数组的中心索引;

public class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int[] fromLeft = new int[len + 2];
        int[] fromRight = new int[len + 2];
        int sum = 0;
        for(int i = 1; i < len + 1; i++) {
            sum += nums[i - 1];
            fromLeft[i] = sum;
        }
        sum = 0;
        for(int i = len; i >= 1; i--) {
            sum += nums[i - 1];
            fromRight[i] = sum;
        }
        int i = 1;
        for(; i < len + 1; i++) {
            if (fromLeft[i - 1] == fromRight[i + 1]) {
                break;
            }
        }
        return i <= len ? i - 1 : -1;
    }
}
