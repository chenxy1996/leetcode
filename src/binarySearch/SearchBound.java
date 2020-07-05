package binarySearch;

import javax.swing.text.html.Option;
import java.util.OptionalInt;

/**
 * 都是用左右闭区间
 */
public class SearchBound {

    /*
     * nums = {1, 2, 3, 3, 3, 4}
     * target = 3
     * return 2
     */
    public static OptionalInt searchLeftBound(int[] nums, int target) {
        // 左右闭区间
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            if (nums[start] == target) {
                return OptionalInt.of(start);
            }

            mid = (end - start) / 2 + start;

            if (nums[mid] >= target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        if (start < nums.length && nums[start] == target) {
            return OptionalInt.of(start);
        }

        return OptionalInt.empty();
    }

    /*
     * nums = {1, 2, 3, 3, 3, 4, 5}
     * target = 3
     * return 4
     */
    public static OptionalInt searchRightBound(int[] nums, int target) {
        // 左右都是闭区间
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            if (nums[start] == target) {
                return OptionalInt.of(start);
            }

            mid = (end - start) / 2 + start;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }

        return OptionalInt.empty();
    }

    public static void main(String[] args) {
        int[] source  = new int[] {1, 2, 3, 3, 3, 5};
        int target = 4;

//        System.out.println("chen");
        System.out.println(searchLeftBound(source, target));
//        System.out.println(searchRightBound(source, target));
    }
}
