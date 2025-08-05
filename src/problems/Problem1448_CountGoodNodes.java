package problems;

public class Problem1448_CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int res = node.val >= maxSoFar ? 1 : 0;
        maxSoFar = Math.max(maxSoFar, node.val);

        res += countGoodNodes(node.left, maxSoFar);
        res += countGoodNodes(node.right, maxSoFar);

        return res;
    }

    public static void main(String[] args) {
        Problem1448_CountGoodNodes problem = new Problem1448_CountGoodNodes();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
        
        int result = problem.goodNodes(root);
        System.out.println(result); // Output: 4
    
        // Additional test case
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(2);
        root2.right.right = new TreeNode(5);
        
        int result2 = problem.goodNodes(root2);
        System.out.println(result2); // Output: [1, 3, 5]
    }
}   

