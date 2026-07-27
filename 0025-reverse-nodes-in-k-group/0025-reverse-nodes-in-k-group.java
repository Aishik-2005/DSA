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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Step 1: Check if k nodes exist
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Step 2: If k nodes exist, reverse them
        if (count == k) {
            ListNode prev = null;
            curr = head;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Step 3: Recursively process remaining list
            head.next = reverseKGroup(curr, k);

            // Step 4: Return new head after reversal
            return prev;
        }

        // If less than k nodes, return head as it is
        return head;
    }
}