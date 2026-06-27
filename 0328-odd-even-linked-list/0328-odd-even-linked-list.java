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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        // Step 1: Store values in array
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        // Step 2: Rearrange values (odd indices first, then even)
        ArrayList<Integer> res = new ArrayList<>();

        // odd indices (1-based → i = 0,2,4,...)
        for (int i = 0; i < arr.size(); i += 2) {
            res.add(arr.get(i));
        }

        // even indices (1-based → i = 1,3,5,...)
        for (int i = 1; i < arr.size(); i += 2) {
            res.add(arr.get(i));
        }

        // Step 3: Put values back into linked list
        temp = head;
        int i = 0;
        while (temp != null) {
            temp.val = res.get(i++);
            temp = temp.next;
        }

        return head;
    }
}