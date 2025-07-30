package problems;

public class Problem0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;

        // Accounts for edge cases; one case where l1 and l2 don't have same length; and other case where we have 
        // like 8 + 7 and we create 5 but we still need to carry the 1 over for the tens place
        while (l1 != null || l2 != null || carry != 0) {
            // Value of l1 digit
            int v1;
            if (l1 != null) {
                v1 = l1.val;
            } else {
                v1 = 0;
            }

            // Value of l2 digit
            int v2;
            if (l2 != null) {
                v2 = l2.val;
            } else {
                v2 = 0;
            }

            // Let's say l1 + l2 = 15, the carry is the 1, or 15 / 10 and the digit in our list is 5 or 15 % 10
            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            // don't forget to actually insert into the new list and build it up
            cur.next = new ListNode(val);
            cur = cur.next; // advance new list

            // need to advance the old lists if non-null
            if (l1 != null) {
                l1 = l1.next; // move to next node in l1
            }
            if (l2 != null) {
                l2 = l2.next; // move to next node in l2
            }
        }
        return dummy.next; // dummy just helps us avoid some edge cases as usual
    }

    public static void main(String[] args) {
        // Example usage
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(4, new ListNode(5, new ListNode(6)));

        Problem0002_AddTwoNumbers solver = new Problem0002_AddTwoNumbers();
        ListNode result = solver.addTwoNumbers(l1, l2);

        // Print the result
        ListNode.printLinkedList(result); // Expected output: 5 -> 7 -> 9

        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode result2 = solver.addTwoNumbers(l3, l4);
        ListNode.printLinkedList(result2); // Expected output: 8 -> 1 
    }
}
