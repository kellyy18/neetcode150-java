package problems;

public class Problem0098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (!(min < node.val && node.val < max)) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    /*
     * Approach:
     * Pass in and track the max and min bounds for each node to check if valid BST. There's another slightly less space efficient
     * solution which is make a list of the nodes with an in-order traversal and check if the list is strictly increasing. The approach used 
     * here is most efficient though and is best explained on paper. Check the notebook.
     */

    public static void main(String[] args) {
        Problem0098_ValidateBinarySearchTree solution = new Problem0098_ValidateBinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("Is valid BST: " + solution.isValidBST(root)); // Output: true

        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(1);
        invalidRoot.right = new TreeNode(4);
        invalidRoot.right.left = new TreeNode(3);
        invalidRoot.right.right = new TreeNode(6);
        System.out.println("Is valid BST: " + solution.isValidBST(invalidRoot)); // Output: false
    }
}
