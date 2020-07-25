package 面试金典._02_链表问题._06_并不是简单题_回文链表;

import 面试金典._02_链表问题.ListNode;

public class OptimalSolution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            // 翻转 slow 之间的链表
            ListNode temp = slow.next;
            slow.next = last;
            last = slow;
            slow = temp;
        }

        if(fast == null) { // 说明链表节点长度为偶数
            return isSame(last, slow);
        } else { // 链表节点个数为奇数
            return isSame(last, slow.next);
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
        OptimalSolution solution = new OptimalSolution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next= new ListNode(1);
        System.out.println(solution.isPalindrome(null));
    }
}
