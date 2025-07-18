package problems;

public class Problem0141_LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        // Only tricky part but makes sense; fast pointer gets to end first, it's calling .next.next so need to check if fastPointer
        // and fastPointer.next are null for nullpointerexceptions.
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            // If fast pointer and slow pointer meet up there's an infinite loop
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        // If you get out of the loop you reached the end of the list so there's no infinite loop
        return false;
    }

    // Fairly straightforward algorithm. If you've seen it before it's very easy. There's much more tricky applications

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        boolean result = hasCycle(node1);
        System.out.println(result); // true

        node1 = new ListNode(1);
        node2 = new ListNode(2); 
        
        node1.next = node2;
        node2.next = node1;
        result = hasCycle(node1);
        System.out.println(result); // true

        node1 = new ListNode(1);
        result = hasCycle(node1);
        System.out.println(result); // false
    }
}
