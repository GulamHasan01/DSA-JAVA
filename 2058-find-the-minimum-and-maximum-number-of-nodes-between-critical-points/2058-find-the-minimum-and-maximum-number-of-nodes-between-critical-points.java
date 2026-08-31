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
        if (head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 2;
        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;

        while (curr.next != null) {
            boolean critical =
                (curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val);

            if (critical) {
                if (first == -1) {
                    first = index;
                } else {
                    min = Math.min(min, index - last);
                }

                last = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (first == last)
            return new int[]{-1, -1};

        return new int[]{min, last - first};
    }
}