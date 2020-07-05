<<<<<<< HEAD
package binarySearch.查找有序数组中大于某数的第一个位置;

public class FindPos {
    public static int find(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int valL = nums[l];
            if (valL > target) {
                return l;
            }
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l < nums.length ? l : -1;
    }

    public static int find1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l < nums.length? l : -1;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 1, 2, 2, 3, 3, 3, 5, 5, 6, 7};
        int[] nums = {1};
        int target = 2;
        System.out.println(find1(nums, target));
        System.out.println(find(nums, target));
    }
}
=======
package binarySearch.查找有序数组中大于某数的第一个位置;

public class FindPos {
    public static int find(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int valL = nums[l];
            if (valL > target) {
                return l;
            }
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l < nums.length ? l : -1;
    }

    public static int find1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int valM = nums[m];
            if (valM > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l < nums.length? l : -1;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 1, 2, 2, 3, 3, 3, 5, 5, 6, 7};
        int[] nums = {1};
        int target = 2;
        System.out.println(find1(nums, target));
        System.out.println(find(nums, target));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
