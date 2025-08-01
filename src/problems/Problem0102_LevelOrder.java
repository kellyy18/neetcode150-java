package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem0102_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }

            if (!level.isEmpty()) {
                res.add(level);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem0102_LevelOrder solver = new Problem0102_LevelOrder();

        System.out.println("--- LeetCode Test Case 1 ---");
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.print("Input: ");
        TreeNode.printTree(root1);
        System.out.println();
        List<List<Integer>> result1 = solver.levelOrder(root1);
        System.out.println("Output: " + result1); // Expected: [[3],[9,20],[15,7]]
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 2 ---");
        TreeNode root2 = new TreeNode(1);
        System.out.print("Input: ");
        TreeNode.printTree(root2);
        System.out.println();
        List<List<Integer>> result2 = solver.levelOrder(root2);
        System.out.println("Output: " + result2); // Expected: [[1]]
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 3 ---");
        TreeNode root3 = null;
        System.out.print("Input: ");
        TreeNode.printTree(root3);
        System.out.println();
        List<List<Integer>> result3 = solver.levelOrder(root3);
        System.out.println("Output: " + result3); // Expected: []
        System.out.println("------------------------------\n");
    }
}
