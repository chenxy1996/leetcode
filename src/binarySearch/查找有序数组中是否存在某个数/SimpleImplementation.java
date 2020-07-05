package binarySearch.查找有序数组中是否存在某个数;

public class SimpleImplementation {
    public static boolean find(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM == target) {
                return true;
            } else if (valM < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 3, 3, 3, 5, 5, 6, 7};
        int target = 4;
        System.out.println(find(nums, target));
    }
}
