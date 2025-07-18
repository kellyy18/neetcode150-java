package problems;

public class Problem0572_SubtreeofAnotherTree {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if subTree has been processed first then it's good
        if (subRoot == null) {
            return true;
        }
        // if regular tree reaches null before subtree then it's definitely false by definition of subtree
        if (root == null) {
            return false;
        }

        // check if current root is sametree as the subroot
        if (sameTree(root, subRoot)) {
            return true;
        }

        // only need to find one root that's the same tree as the subroot to get true for subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /* Same Tree Helper Method. Explained alerady in SameBinaryTree class */
    public static boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot != null && root.val == subRoot.val) {
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode subRoot = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        boolean b = isSubtree(root, subRoot);
        System.out.println(b);
    }
}
