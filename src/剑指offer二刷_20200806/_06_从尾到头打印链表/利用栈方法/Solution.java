package 剑指offer二刷_20200806._06_从尾到头打印链表.利用栈方法;

import 剑指offer.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.addLast(head.val);
            head = head.next;
        }
        int[] ans = new int[deque.size()];
        int p = 0;
        while (!deque.isEmpty()) {
            ans[p++] = deque.removeLast();
        }
        return ans;
    }
}
