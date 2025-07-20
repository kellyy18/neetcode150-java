package problems;

public class Problem0287_FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        // Ok here's the idea. Each value accessed is an index pointing to another leement in the array. 
        // This basically turns our array functionally into a linked list and since we have one duplicate 
        // element. In this conceptualization, our linked ilst will effectively have a cycle in it due to the
        // way the pointers work with the one duplicated element. Thus, we have floyd's cycle detection algorithm.
        int slow = 0;
        int fast = 0;

        // Find a meetup point IN the cycle
        while (true ) {
            // slow = slow.next and fast = fast.next.next but with arrays
            slow = nums[slow]; 
            fast = nums[nums[fast]];

            // We have now found SOME point WITHIN the cycle 
            if (slow == fast) {
                break;
            }
        }

        // The duplicated element is the START of the cycle. Math is complex but we can find the start of the cycle with another slow pointer.

        // The math here is a bit hand wavy (I will look into it in-depth later but its complex) but starting 
        //from the start and doing however many steps to reach the beginning of the 'cycle' is guaranteed to 
        // meet up with the node in the cycle at the start of the cycle
        int slow2 = 0;
        while (true) { 
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
    }
}
