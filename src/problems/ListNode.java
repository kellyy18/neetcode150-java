package problems;

/*
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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

