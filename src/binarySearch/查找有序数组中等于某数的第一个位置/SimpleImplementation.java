package binarySearch.查找有序数组中等于某数的第一个位置;

public class SimpleImplementation {
    public static int find(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l < nums.length && nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 3, 3, 3, 5, 5, 6, 7};
        int target = 4;
        System.out.println(find(nums, target));
    }
}
