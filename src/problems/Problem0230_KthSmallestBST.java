package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem0230_KthSmallestBST {
    public int KthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inOrderTraversal(root, arr);
        return arr.get(k - 1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, arr);
        arr.add(node.val);
        inOrderTraversal(node.right, arr);
    }

    public static void main(String[] args) {
        Problem0230_KthSmallestBST solution = new Problem0230_KthSmallestBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        
        int k = 1;
        System.out.println("The " + k + "th smallest element is: " + solution.KthSmallest(root, k)); // Output: 1
        
        k = 2;
        System.out.println("The " + k + "th smallest element is: " + solution.KthSmallest(root, k)); // Output: 2
        
        k = 3;
        System.out.println("The " + k + "th smallest element is: " + solution.KthSmallest(root, k)); // Output: 3
        
        k = 4;
        System.out.println("The " + k + "th smallest element is: " + solution.KthSmallest(root, k)); // Output: 4
    }
}
