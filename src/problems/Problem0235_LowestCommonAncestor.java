package problems;

public class Problem0235_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root; // we found the split point
        }
    }
    /* Really straightforward problem
     * Since it's a binary search tree, we know that:
     * - If both p and q are less than root, then LCA is in the left subtree.
     * - If both p and q are greater than root, then LCA is in the right subtree.
     * - Otherwise, root is the LCA.
     * 
     * Time complexity: O(h) where h is the height of the tree.
     * Space complexity: O(1) since we are not using any additional data structures.
     */

    public static void main(String[] args) {
        Problem0235_LowestCommonAncestor solution = new Problem0235_LowestCommonAncestor();
        
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        
        root.left = node2;
        root.right = node8;
        node2.left = node0;
        node2.right = node4;
        node4.left = node3;
        node4.right = node5;
        node8.left = node7;
        node8.right = node9;

        TreeNode p = node2; // Node with value 2
        TreeNode q = node8; // Node with value 8
        
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val); // Output: 6
    }
}
