<<<<<<< HEAD
package binarySearch.查找有序数组中大于等于某数的第一个位置;


public class FindFirstGreaterNumPos {
    public static int find(int[] nums, int target) {
        // 边界判断，优化特殊情况下的算法复杂度
        if (nums[0] >= target) {
            return 0;
        }

        if (nums[nums.length - 1] <= target) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        /**
        这里用的是 <
         */
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = nums[m];
            if (val < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public static int find1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] >= target) {
                return l;
            }

            int m = l + (r - l) / 2;
            int val = nums[m];
            if (val >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l < nums.length ? l : -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 3, 3, 3, 5, 5, 6, 7};
        int target = 3;
        System.out.println(find(nums, target));
        System.out.println(find1(nums, target));
    }
}
=======
package binarySearch.查找有序数组中大于等于某数的第一个位置;


public class FindFirstGreaterNumPos {
    public static int find(int[] nums, int target) {
        // 边界判断，优化特殊情况下的算法复杂度
        if (nums[0] >= target) {
            return 0;
        }

        if (nums[nums.length - 1] <= target) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        /**
        这里用的是 <
         */
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = nums[m];
            if (val < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public static int find1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] >= target) {
                return l;
            }

            int m = l + (r - l) / 2;
            int val = nums[m];
            if (val >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l < nums.length ? l : -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 3, 3, 3, 5, 5, 6, 7};
        int target = 3;
        System.out.println(find(nums, target));
        System.out.println(find1(nums, target));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
