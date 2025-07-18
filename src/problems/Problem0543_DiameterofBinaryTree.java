package problems;

public class Problem0543_DiameterofBinaryTree {
    private static int res;

    public static int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root); 
        return res;
    }

    private static int dfs(TreeNode root) {
    // By using a global variable we are able to essentially store maximumDiameter
    // while continuing to be able to calculate depth / height in the same method; improving time complexity
        if (root == null) {
            return 0;
        }
        // Get height of left and right subtrees
        int left = dfs(root.left);
        int right = dfs(root.right);
        // Left + right = longest diameter going through the CURRENT NODE
        // Check if there's anything bigger currently than diameter through current node
        res = Math.max(res, left + right);
        // Calculate subtree height at current root node
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, new TreeNode(5), null), new TreeNode(4)));
        int diameter = diameterOfBinaryTree(root); // 3
        System.out.println(diameter);

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        diameter = diameterOfBinaryTree(root); // 2
        System.out.println(diameter);
    }
}
