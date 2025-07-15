package problems;

public class Problem0021_MergeTwoSortedLists {
    /* Iterative Approach */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node at the head (actual head starts at node after dummy)
        //Purpose of dummy node is simply to account for both lists are empty case. Otherwise we'd just start the list (tail) directly and return that.
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next;
    }

    /* Recursive Approach */
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     if (list1 == null) {
    //         return list2;
    //     }

    //     if (list2 == null) {
    //         return list1;
    //     }

    //     if (list1.val <= list2.val) {
    //         list1.next = mergeTwoLists(list1.next, list2);
    //         return list1;
    //     } else {
    //         list2.next = mergeTwoLists(list1, list2.next);
    //         return list2;
    //     }
    // }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result = mergeTwoLists(list1, list2); // [1, 1, 2, 3, 4, 4]

        ListNode.printLinkedList(result);
    }
}
