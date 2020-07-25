package 面试金典._02_链表问题._07_经典_链表相交;

import 面试金典._02_链表问题.LinkedListPrinter;
import 面试金典._02_链表问题.ListNode;

/**
 * 做的比较繁琐，使用了变量 exchange 来控制，实际上我们可以不要这个变量，
 * 可以把 null 也作比较，如果两个链表不相交，最后它们各自的指针最后都停在 null
 * 直接返回 null 就可
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int exchange = 2;
        ListNode currA = headA, currB = headB;
        while (currA != currB) {
            if (currA.next != null) {
                currA = currA.next;
            } else {
                if (exchange > 0) {
                    currA = headB;
                    exchange--;
                } else {
                    return null;
                }
            }
            if (currB.next != null) {
                currB = currB.next;
            } else {
                if (exchange > 0) {
                    currB = headA;
                    exchange--;
                } else {
                    return null;
                }
            }
        }
        return currA;
    }

    public static void main(String[] args) {
        ListNode _1_node = new ListNode(1);
        ListNode _2_node = new ListNode(2);
        ListNode _3_0_node = new ListNode(3);
        ListNode _3_1_node = new ListNode(3);
        ListNode _4_node = new ListNode(4);
        ListNode _5_node = new ListNode(5);
        ListNode _6_node = new ListNode(6);
        ListNode _7_node = new ListNode(7);

//        _1_node.next = _2_node;
        _2_node.next = _3_0_node;

        _6_node.next = _7_node;
        _7_node.next = _3_1_node;

        _3_0_node.next = _4_node;
        _3_1_node.next = _4_node;

        _4_node.next = _5_node;

        ListNode headA = _2_node;
        ListNode headB = _6_node;

        LinkedListPrinter.show(headA);
        LinkedListPrinter.show(headB);

        System.out.println(new Solution().getIntersectionNode(headA, headB).val);
    }
}
