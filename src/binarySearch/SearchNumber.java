package binarySearch;

import java.util.OptionalInt;

/**
 * find the target if is in the specific array.
 */
public class SearchNumber {
    // 区间左右边界都是闭合
    public static OptionalInt search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;

        // 下面是判断 <=
        while (start <= end) {
            // 写 (start + end) / 2 可能会溢出
            mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return OptionalInt.of(mid);
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }

        return OptionalInt.empty();
    }

    // 换成另外一种
    // 区间为左闭右开
    public static OptionalInt searchInAnotherWay(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid;

        while (start < end) {
            mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return OptionalInt.of(mid);
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            }
        }

        return OptionalInt.empty();
    }

    public static void main(String[] args) {
        int[] source = new int[] {1, 2, 3, 4, 5, 6, 7};
        System.out.println(searchInAnotherWay(source, 7));
    }
}
