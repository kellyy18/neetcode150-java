package problems;

public class Problem0226_InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Just need temporary references to the left and right tree node since we're going to change them; 
        // only part of this problem that requires any thought
        TreeNode left = root.left;
        TreeNode right = root.right;

        // x = change(x) pattern. Change the links
        root.left = invertTree(right);
        root.right = invertTree(left);
        // don't forget to return the root at the end
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        TreeNode.printTree(root); // 1 2 4 5 3 6 7 (prints differently than expected due to pre-order but this is correct)
        System.out.println(); // 1 3 7 6 2 5 4 (same thing with pre-order)

        root = invertTree(root);
        TreeNode.printTree(root);
        System.out.println();

        root = new TreeNode(3, new TreeNode(2), new TreeNode(1));
        TreeNode.printTree(root); // 3 2 1
        System.out.println();

        root = invertTree(root); // 3 1 2
        TreeNode.printTree(root);
        System.out.println();
    

    }
}
