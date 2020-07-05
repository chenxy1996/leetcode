package binarySearch.查找有序数组中等于某数的第一个位置;

public class FindFirstPos {
    public static int find(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        if (nums[l] > target || nums[r] < target) {
            return -1;
        }

        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = nums[m];
            if (val >= target) {
                r = m - 1;
            } else{
                l = m + 1;
            }
        }

        return nums[r + 1] == target ? r + 1 : -1;
    }

    public static int find1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == target) {
                return l;
            }

            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return (l < nums.length && nums[l] == target) ? l : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3, 5, 7, 8};
        int target = 9;
        System.out.println(find1(nums, target));
    }
}
