package problems;

/*
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode random; // NOTE (to my knowledge) only use for LC 138

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    // NOTE (to my knowledge) only use for LC 138)
    ListNode(int val, ListNode next, ListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
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

