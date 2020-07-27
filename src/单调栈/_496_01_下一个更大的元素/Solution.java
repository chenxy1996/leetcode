package 单调栈._496_01_下一个更大的元素;

import java.util.*;

/**
 * 初见做麻烦了，没有注意到题目中没有重复数字这个条件
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length;
        int[] store = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int val = nums2[i];
            map.put(val, i);
            int top;
            while (!deque.isEmpty() && nums2[top = deque.peekLast()] < val) {
                deque.removeLast();
                store[top] = i;
            }
            deque.addLast(i);
        }
        while (!deque.isEmpty()) {
            store[deque.removeLast()] = -1;
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int p = map.get(nums1[i]);
            if (store[p] > 0) {
                ans[i] = nums2[store[p]];
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums1, nums2)));
    }
}
