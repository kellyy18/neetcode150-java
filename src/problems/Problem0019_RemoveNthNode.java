package problems;

public class Problem0019_RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy; 
        ListNode right = head;

        // Let's say n = 2; When left starts at head and right starts at head.next.next (n = 2 away). What is the value of left when right is null?
        // THATS RIGHT LEFT LANDS AT THE NODE WE WANT TO DELETE
        // We initialize right n .next operations after left pointer; this is a slightly verbose way of saying it just look above
        while (n > 0) {
            right = right.next;
            n--;
        }

        // Then, we progress both of them through until right is NULL. Now, left is on the one we want to delete right? But how do we delete it? 
        // We want left to be on the one BEFORE the one we want to do delete. Hence, this is why we have the DUMMY NODE. Left doesn't start at start. 
        // It starts at the DUMMY NODE!!! NOW IT ENDS UP ON THE ONE BEFORE THE ONE WE WANT TO DELETE!!!
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // Deletes the nth node from the end
        left.next = left.next.next;
        // Returns the actual head of the list not the fake one
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printLinkedList(head); // 1 -> 2 -> 3 -> 4 -> 5
        System.out.println();
        ListNode newHead = removeNthFromEnd(head, 2); 
        ListNode.printLinkedList(newHead); // 1 -> 2 -> 3 -> 5
        System.out.println();

        System.out.println();
        head = new ListNode(1);
        ListNode.printLinkedList(head); // 1
        System.out.println();
        newHead = removeNthFromEnd(head, 1);
        ListNode.printLinkedList(newHead); // []
        System.out.println();
        
        System.out.println();
        head = new ListNode(1, new ListNode(2));
        ListNode.printLinkedList(head); // 1 -> 2
        System.out.println();
        newHead = removeNthFromEnd(head, 1);
        ListNode.printLinkedList(newHead); // 1
        System.out.println();
    }
}
