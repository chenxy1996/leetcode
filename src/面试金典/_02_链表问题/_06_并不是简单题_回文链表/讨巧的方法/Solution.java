package 面试金典._02_链表问题._06_并不是简单题_回文链表.讨巧的方法;

import 面试金典._02_链表问题.ListNode;

import java.math.BigInteger;

/**
 * 如果链表为 1 --> 2 --> 3 --> 2 --> 1,
 * 那么从左往右的形成的数字为 12321, 从右往左是 12321，相等，就是回文；
 * 如果链表为 1 --> 2 --> 3 --> 2 --> 3,
 * 那么从左往右的形成的数字为 12323, 从右往左是 32321，不相等，不是回文
 *
 * 利用这个方法要注意越界的问题，如果链表长度小，那么可以用 int 和 long
 * 如果链表长度很大，我们用 BigInteger 来试试
 *
 * 注意：只适用于正数
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        BigInteger num1 = BigInteger.ZERO;
        BigInteger num2 = BigInteger.ZERO;
        BigInteger pos = BigInteger.ONE;
        while (head != null) {
            BigInteger val = BigInteger.valueOf(head.val);
            num1 = num1.multiply(BigInteger.valueOf(10)).add(val);
            num2 = pos.multiply(val).add(num2);
            pos = pos.multiply(BigInteger.valueOf(10));
            head = head.next;
        }
        return num1.equals(num2);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next= new ListNode(1);
        System.out.println(new Solution().isPalindrome(head));
    }
}
