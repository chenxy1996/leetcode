package binarySearch.查找有序数组中等于某数的最后一个位置;

public class FindLastPos {
    public static int find(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int valR = nums[r];
            if (valR == target) {
                return r;
            }
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return (r >= 0 && nums[r] == target) ? r : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 4, 5};
        int target = 4;
        System.out.println(find(nums, target));
    }
}
