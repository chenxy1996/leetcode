package 剑指offer._0_剑指offer二刷_20200806._03_02_不修改数组找到重复的数字;

/**
 * 不利用额外的空间
 */
public class Solution {
    public static int search(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= l + 1 && nums[i] <= m + 1) {
                    count++;
                }
            }
            if (l == r) {
                if (count > 1) {
                    return l;
                } else {
                    break;
                }
            }
            if (count > m - l + 1) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,4,3,2,6,7};
        System.out.println(search(nums));
    }
}
