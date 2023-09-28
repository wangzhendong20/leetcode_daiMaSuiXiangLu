package org.example;

public class middle19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0,head);
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        while (n-- > -1){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummyNode.next;
    }
}
