<<<<<<< HEAD
package jianZhiOffer._35别的_搜索插入位置;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        // 左闭右闭区间
        int s = 0;
        int e = nums.length - 1;
        int mid = 0;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 5, 6, 7};
        System.out.println(searchInsert(nums, 5));
    }
}
=======
package jianZhiOffer._35别的_搜索插入位置;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        // 左闭右闭区间
        int s = 0;
        int e = nums.length - 1;
        int mid = 0;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 5, 6, 7};
        System.out.println(searchInsert(nums, 5));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
