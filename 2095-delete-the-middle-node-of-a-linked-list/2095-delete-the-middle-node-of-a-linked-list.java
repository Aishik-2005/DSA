class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: single node
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head.next.next; // offset by 2 to stop one before middle

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is just before the middle — skip it
        slow.next = slow.next.next;
        return head;
    }
}