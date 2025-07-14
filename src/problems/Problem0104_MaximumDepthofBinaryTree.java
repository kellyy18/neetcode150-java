package problems;

public class Problem0104_MaximumDepthofBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
    // One of the easier problems out there. Very straightforward.

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int result = maxDepth(root); // 3
        System.out.println(result); 

        root = new TreeNode(1, null, new TreeNode(2));
        result = maxDepth(root); // 2
        System.out.println(result);
    }
}
