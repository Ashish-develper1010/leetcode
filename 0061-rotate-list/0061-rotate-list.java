/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int count = 1;
        ListNode curr = head;
        ListNode prev = head;

        while(curr.next != null) {
            curr = curr.next;
            count++;
        }

        k = k % count;
        int i = 1;

        while(i < count - k) {
            prev = prev.next;
            i++;
        }

        curr.next = head;
        head = prev.next;
        prev.next = null;

        return head;
    }
}