package problems;

import java.util.HashMap;

public class Problem0138_CopyListRandomPointer {
    public static ListNode copyRandomList(ListNode head) {
        // A hashmap with the old nodes as a key to their new copied equivalents
        HashMap<ListNode, ListNode> oldToCopy = new HashMap<>();
        // What if there's no nodes (all nodes are null) or the next / random fields are null; 
        oldToCopy.put(null, null);

        ListNode curr = head;

        // Initialize the hashmap with curr and copy nodes
        while (curr != null) {
            ListNode copy = new ListNode(curr.val);
            oldToCopy.put(curr, copy);
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            // Create copy using the key (which gives us the value and also the value of the node)
            ListNode copy = oldToCopy.get(curr);
            // Now, we use the old node's pointers to instantiate our copy's pointers
            copy.next = oldToCopy.get(curr.next);
            copy.random = oldToCopy.get(curr.random);
            // Keep traversing
            curr = curr.next;
        }

        // Head of new list will be stored under key of old head hence .get(head)
        return oldToCopy.get(head);
    }

    public static void main(String[] args) {
        // --- Test Case 1: Simple list ---
        System.out.println("--- Test Case 1: Simple List ---");
        // Create nodes
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(13);
        ListNode node3 = new ListNode(11);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(1);

        // Link next pointers
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        // Link random pointers
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        System.out.print("Original List: ");
        ListNode.printLinkedList(node1);
        System.out.println();

        ListNode copiedList1 = copyRandomList(node1);
        System.out.print("Copied List:   ");
        ListNode.printLinkedList(copiedList1);
        System.out.println();
        System.out.println("--------------------------------\n");

        // --- Test Case 2: Empty list ---
        System.out.println("--- Test Case 2: Empty List ---");
        ListNode emptyList = null;
        System.out.print("Original List: ");
        ListNode.printLinkedList(emptyList);
        System.out.println();
        ListNode copiedList2 = copyRandomList(emptyList);
        System.out.print("Copied List:   ");
        ListNode.printLinkedList(copiedList2);
        System.out.println();
        System.out.println("--------------------------------\n");

        // --- Test Case 3: Single node list ---
        System.out.println("--- Test Case 3: Single Node List ---");
        ListNode singleNode = new ListNode(42);
        singleNode.next = null;
        singleNode.random = singleNode; // Points to itself
        System.out.print("Original List: ");
        ListNode.printLinkedList(singleNode);
        System.out.println();
        ListNode copiedList3 = copyRandomList(singleNode);
        System.out.print("Copied List:   ");
        ListNode.printLinkedList(copiedList3);
        System.out.println();
        System.out.println("--------------------------------\n");

        // --- Test Case 4: List with all random pointers null ---
        System.out.println("--- Test Case 4: All Random Pointers Null ---");
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n1.random = null;
        n2.next = null;
        n2.random = null;
        System.out.print("Original List: ");
        ListNode.printLinkedList(n1);
        System.out.println();
        ListNode copiedList4 = copyRandomList(n1);
        System.out.print("Copied List:   ");
        ListNode.printLinkedList(copiedList4);
        System.out.println();
        System.out.println("--------------------------------\n");
    }
}
