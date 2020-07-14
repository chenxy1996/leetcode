package jianZhiOffer._52_两个链表的第一个公共节点;

import jianZhiOffer.ListNode;

public class OptimalSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dumpA = headA;
        ListNode dumpB = headB;
        while (dumpA != dumpB) {
            dumpA = dumpA == null ? headB : dumpA.next;
            dumpB = dumpB == null ? headA : dumpB.next;
        }
        return dumpA;
    }
}
