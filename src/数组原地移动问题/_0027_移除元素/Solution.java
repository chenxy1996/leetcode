package 数组原地移动问题._0027_移除元素;

/**
 * 和 _0283_ 移除元素题目基本一致
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i > j) {
                    nums[j] = nums[i];
                }
                j++;
            }
        }
        return j;
    }
}
