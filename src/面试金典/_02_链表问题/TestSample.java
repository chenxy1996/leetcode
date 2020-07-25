package 面试金典._02_链表问题;


public class TestSample {
    public static final ListNode head = new ListNode(1);
    static {
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
    }
}
