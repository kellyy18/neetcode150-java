package problems;

public class Problem0143_ReorderLinkedList {
    /*
     * The goal is to order the link list weaving in alternating nodes starting from the back with the front nodes. The way to do this is essentially
     * to split the list in two, reverse the second half list, then merge the second half list into the first half list. Once you come up with this 
     * approach, the logic to implement is not all too difficult to code up except for maybe a few pitfalls here and there.
     */
    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // Split list into two using a slow and fast pointer
        }

        ListNode second = slow.next; // start of 2nd list
        ListNode prev = slow.next = null; // this just sets prev and slow.next to null in one line; equivalent to doing ListNode prev = null and slow.next = null


        // Iterative linked list reversal for the second half
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
            // There was a time when I struggled to implement the logic using tmp as second.next. Maybe try setting tmp to second. I found some success that way
        }

        // We now have the first half and second half list heads
        ListNode first = head;
        second = prev;

        /*
         * Merging the second list pointers into the first list. It's not too bad overall just draw it out and think about where the links need to go.
         */
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1: Even number of nodes ---");
        // List: 1 -> 2 -> 3 -> 4
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        System.out.print("Original List: ");
        ListNode.printLinkedList(head1); // 1 -> 2 -> 3 -> 4
        System.out.println(); // Added for formatting
        reorderList(head1);
        System.out.print("Reordered List: ");
        ListNode.printLinkedList(head1); // Expected: 1 -> 4 -> 2 -> 3
        System.out.println("--------------------------------\n");


        System.out.println("--- Test Case 2: Odd number of nodes ---");
        // List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        System.out.print("Original List: ");
        ListNode.printLinkedList(head2); // 1 -> 2 -> 3 -> 4 -> 5
        System.out.println(); // Added for formatting
        reorderList(head2);
        System.out.print("Reordered List: ");
        ListNode.printLinkedList(head2); // Expected: 1 -> 5 -> 2 -> 4 -> 3
        System.out.println("--------------------------------\n");
    }
}
