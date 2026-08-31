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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null)
            return ans;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode nextt = curr.next;

        int index = 1;

        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;

        while (nextt != null) {

            boolean critical =
                (curr.val > prev.val && curr.val > nextt.val) ||
                (curr.val < prev.val && curr.val < nextt.val);

            if (critical) {

                if (first == -1) {
                    first = index;
                } else {
                    min = Math.min(min, index - last);
                }

                last = index;
            }

            prev = curr;
            curr = nextt;
            nextt = nextt.next;
            index++;
        }

        if (first == last)
            return ans;

        ans[0] = min;
        ans[1] = last - first;

        return ans;
    }
}