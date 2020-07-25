package 面试金典._02_链表问题._07_经典_链表相交;

import 面试金典._02_链表问题.ListNode;

public class OptimalSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode la = headA, lb = headB;
        while (la != lb) {
            la = la == null ? headB : la.next;
            lb = lb == null ? headA : lb.next;
        }
        return la;
    }
}
