package 二插堆binaryHeap;

import java.util.Arrays;
import java.util.Comparator;

public class IsBinaryHeap {
    public static boolean is(int[] nums, Comparator<Integer> comparator) {
        for (int i = 0; i <= nums.length / 2 - 1; i++) {
            int k = 2 * i + 1;
            if (k < nums.length && comparator.compare(nums[i], nums[k]) > 0) {
                return false;
            }
            k++;
            if (k < nums.length && comparator.compare(nums[i], nums[k]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 7, 0, 3, 1, 2, 5, 8};
        Comparator<Integer> comparator = Comparator.naturalOrder();
        System.out.println(IsBinaryHeap.is(nums, comparator));
        BinaryHeap binaryHeap = new BinaryHeap(nums, comparator);
        System.out.println(Arrays.toString(binaryHeap.getHeap()));
        System.out.println(IsBinaryHeap.is(nums, comparator));
    }
}
