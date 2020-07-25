package 面试金典._02_链表问题._06_并不是简单题_回文链表;

import 面试金典._02_链表问题.ListNode;

/**
 * 用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode last = null;
        // 先用快慢指针
        ListNode slow = head, fast = head.next;
        int count = 1; // 链表长度
        while (fast != null) {
            count++;

            // 翻转前面 slow 经过的链表节点
            ListNode temp = slow.next;
            slow.next = last;
            last = slow;
            slow = temp;

            fast = fast.next;
            if (fast != null) {
                count++;
                fast = fast.next;
            }
        }
        if ((count & 1) == 1) { // 如果是链表长度为奇数
            return isSame(last, slow.next);
        } else { // 如果是链表长度为偶数
            return isSame(last, slow);
        }
    }

    private boolean isSame(ListNode l1, ListNode l2) {
        while (l1 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next= new ListNode(3);
        System.out.println(new Solution().isPalindrome(head));
    }
}
