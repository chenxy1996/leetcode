<<<<<<< HEAD
package binarySearch.查找有序数组中大于某数的第一个位置;

public class SimpleImplementation {
    public static int find(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l < nums.length ? l : -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 3, 3, 3, 5, 5, 6, 7};
        int target = 1;
        System.out.println(find(nums, target));
    }
}
=======
package binarySearch.查找有序数组中大于某数的第一个位置;

public class SimpleImplementation {
    public static int find(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l < nums.length ? l : -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 3, 3, 3, 5, 5, 6, 7};
        int target = 1;
        System.out.println(find(nums, target));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
