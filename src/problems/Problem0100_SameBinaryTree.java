package problems;

public class Problem0100_SameBinaryTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true; // Base Case 1: Same tree
        } else if (p != null && q != null && p.val == q.val) { // check both nodes are non-null (trees both have to keep going) and nodes are the same
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else { // any other case then return false
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(p, q));

        TreeNode p2 = new TreeNode(4, new TreeNode(7), null);
        TreeNode q2 = new TreeNode(4, null, new TreeNode(7));
        boolean b2 = isSameTree(p2, q2); // false
        System.out.println(b2);
    }
}
