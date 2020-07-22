package jianZhiOffer._59_1单调队列困难_滑动窗口的最大值;

import java.util.ArrayDeque;
import java.util.Arrays;

// 初见, 这里用一个双向队列来辅助
public class Solution {
    // 要求线性复杂度
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (nums == null || len == 0 || len < k) {
            return new int[0];
        }

        int[] res = new int[len - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int leftBound = i - k + 1;
            if (leftBound - 1 >= 0 && nums[leftBound - 1] == deque.peekFirst()) {
                deque.pollFirst();
            }
            int val = nums[i];;
            while (!deque.isEmpty() && (deque.peekLast() < val)) {
                deque.pollLast();
            }
            deque.addLast(val);
            if (leftBound >= 0) {
                res[leftBound] = deque.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
