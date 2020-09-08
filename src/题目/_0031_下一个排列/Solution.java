package 题目._0031_下一个排列;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        Deque<Integer> deque  = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            int val = nums[i];
            int top = i;
            while (!deque.isEmpty() && nums[deque.peekLast()] > val) {
                top = deque.removeLast();
            }
            if (top != i) { // 说明在 [i + 1, len - 1] 中有值比 val 大
                int temp = nums[i];
                nums[i] = nums[top];
                nums[top] = temp;
                Arrays.sort(nums, i + 1, len);
                return;
            }
            deque.addLast(i);
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
