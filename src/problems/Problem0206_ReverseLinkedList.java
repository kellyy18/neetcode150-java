package problems;

public class Problem0206_ReverseLinkedList {
    /* Recursive Approach */
    // public static ListNode reverseList(ListNode head) {
    //     if (head == null) {
    //         return null;
    //     }

    //     ListNode newHead = head;
    //     if (head.next != null) {
    //         newHead = reverseList(head.next);
    //         head.next.next = head;
    //     }
    //     head.next = null;
    //     return newHead;
    // }

    // Recursive solution is slightly less space efficient and in my opinion more aesthetically pleasing. To me it's not too intuitive. 
    // I prefer the iterative approach.

    /*Iterative Approach */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next; // Save next node
            curr.next = prev; // Change current to point to prev (reversal)
            prev = curr; // Previous takes current's place (advances up one node)
            curr = temp; // Curr moves to curr.next (advances up one node)
        }

        return prev; // Traversal ends with curr at null and prev at the new head.
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.print("Old Linked List: ");
        printLinkedList(head);
        System.out.println();

        ListNode newHead = reverseList(head);
        System.out.print("Reversed Linked List: ");
        printLinkedList(newHead);
        System.out.println();

        // Prints output: 5 -> 4 -> 3 -> 2 -> 1

        head = new ListNode(1, new ListNode(2));
        System.out.print("Old Linked List: ");
        printLinkedList(head);
        System.out.println();

        newHead = reverseList(head);
        System.out.print("Reversed Linked List: ");
        printLinkedList(newHead);
        System.out.println();

        head = new ListNode();
        System.out.print("Old Linked List: ");
        printLinkedList(head);
        System.out.println();

        newHead = reverseList(head);
        System.out.print("Reversed Linked List: ");
        printLinkedList(newHead);
        System.out.println();
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }
}


