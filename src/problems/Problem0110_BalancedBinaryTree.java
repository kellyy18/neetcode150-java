package problems;

public class Problem0110_BalancedBinaryTree {
    private static boolean isBalanced;

    public static boolean isBalanced(TreeNode root) {
        isBalanced = true;
        dfs(root);
        return isBalanced;
    }

    private static int dfs(TreeNode root) {
        // Base cases to exit the loop once conditional flags have been set or end of tree reached
        if (root == null) {
            return 0;
        }

        if (!isBalanced) {
            return 0;
        }

        // doesn't this look familiar
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        // isBalanced checker
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }

        // doesn't this look familiar
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Reference diameterOfBinaryTree. As mentioned in the sections of doesn't this look familiar it appears there's a clear DFS
    // pattern for improving time complexity by combining height calculation with tracking of a boolean in this case or a diameter
    // in the other case.

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null));
        System.out.println(isBalanced(root)); // true

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null));
        boolean b = isBalanced(root); // false
        System.out.println(b);
    }
}
