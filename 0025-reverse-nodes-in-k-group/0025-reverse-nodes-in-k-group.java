class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;

        // Check if there are k nodes
        for (int i = 0; i < k; i++) {
            if (curr == null)
                return head;
            curr = curr.next;
        }

        // Reverse first k nodes
        ListNode prev = null;
        curr = head;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Connect remaining list
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}