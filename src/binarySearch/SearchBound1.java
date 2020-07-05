package binarySearch;

import java.util.OptionalInt;

/**
 * 左开右闭区间
 */
public class SearchBound1 {
    public static OptionalInt searchLeftBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid;

        while (start < end) {
            if (nums[start] == target) {
                return OptionalInt.of(start);
            }

            mid = (end - start) / 2 + start;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return OptionalInt.empty();
    }

    public static OptionalInt searchRightBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid;

        while (start < end) {
            if (nums[start] == target) {
                return OptionalInt.of(start);
            }

            mid = (end - start) / 2 + start;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return OptionalInt.empty();
    }

    public static void main(String[] args) {
        int[] source  = new int[] {1, 2, 3, 3, 3, 4, 7};
        int target = 5;

        System.out.println(searchLeftBound(source, target));
        System.out.println(searchRightBound(source, target));
    }
}
