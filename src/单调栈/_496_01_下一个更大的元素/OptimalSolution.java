package 单调栈._496_01_下一个更大的元素;

import java.util.*;

public class OptimalSolution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length;
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int val = nums2[i];
            while (!deque.isEmpty() && deque.peekLast() < val) {
                map.put(deque.removeLast(), val);
            }
            deque.addLast(val);
        }
//        while (!deque.isEmpty()) {
//            map.put(deque.removeLast(), -1);
//        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
