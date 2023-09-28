package org.example;

public class simple160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        int lenA=0,lenB=0;
        while (tmpA != null){
            lenA++;
            tmpA = tmpA.next;
        }
        while (tmpB != null){
            lenB++;
            tmpB = tmpB.next;
        }
        int len = 0;
        if (lenA > lenB){

            len = lenA - lenB;
        }else {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
            len = lenB - lenA;
        }

        tmpA = headA;
        tmpB = headB;

        while (len-- > 0){
            tmpA = tmpA.next;
        }

        while (tmpA != null){
            if (tmpA == tmpB){
                return tmpA;
            }
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }

        return null;


    }
}
