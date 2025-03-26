/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        ListNode tempA = headA;
        ListNode tempB = headB;
        int countA = 0;
        int countB = 0;

        while (l1 != null) {
            l1 = l1.next;
            countA++;
        }
        while (l2 != null) {
            l2 = l2.next;
            countB++;
        }

        int idx = Math.abs(countA - countB);
        if (countA > countB) {
            for (int i = 0; i < idx; i++) {
                tempA = tempA.next;
            }
        } else {
            for (int i = 0; i < idx; i++) {
                tempB = tempB.next;
            }
        }
        while (tempA != null && tempB != null) {
            if (tempA == tempB) return tempA; 
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}