package 单调栈._503_02_下一个更大的元素;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null) {
            return null;
        }
        int len = nums.length;
        int[] newNums = new int[2 * len];
        System.arraycopy(nums, 0, newNums, 0, len);
        System.arraycopy(nums, 0, newNums, len, len);
        nums = newNums;

        int[] res = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len * 2; i++) {
            int val = nums[i];
            while (!deque.isEmpty() && nums[deque.peekLast()] < val) {
                int p = deque.removeLast();
                if (p < len) {
                    res[p] = val;
                }
            }
            deque.addLast(i);
        }
        while(!deque.isEmpty()) {
            int p = deque.removeLast();
            if (p < len) {
                res[p] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,5,6};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
