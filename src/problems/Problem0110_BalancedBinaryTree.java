package problems;

public class Problem0110_BalancedBinaryTree {
    private static boolean isBalanced;

    public static boolean isBalanced(TreeNode root) {
        isBalanced = true;
        dfs(root);
        return isBalanced;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (!isBalanced) {
            return 0;
        }

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null));
        System.out.println(isBalanced(root)); // true

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null));
        boolean b = isBalanced(root); // false
        System.out.println(b);
    }
}
