package 剑指offer二刷_20200806._59_01_滑动窗口的最大值;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int p = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < len; i++) {
            int num = nums[i];
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.removeLast();
            }
            deque.addLast(num);
            if (i >= k - 1) {
                if (i >= k && nums[i - k] == deque.peekFirst()) {
                    deque.removeFirst();
                }
                ans[p++] = deque.peekFirst();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
