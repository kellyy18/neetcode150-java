package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem0199_rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        // always remember to get the BFS going by adding the root to the queue
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode rightSide = null;
            // note, we need to fix the CURRENT level size, if we call q.size in the loop, it's changing 
            // as we create child nodes and thus will not properly traverse levels as expected
            int levelSize = q.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll(); // ALWAYS need to remove current level nodes
                if (node != null) {
                    // once the loop is done for this level, since it traverses / processes nodes left to right it will end up
                    // setting the rightmost node correctly when the loop exits
                    rightSide = node;
                    // child nodes fill in the next level
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }

            if (rightSide != null) {
                res.add(rightSide.val);
            }
        }
        return res;
    }
    /* Pretty straightforward bfs algorithm; The method / algorithm is extremely easily to formulate 
     * and conceptualize, just writing the actual code I'm not super comfortable with because I haven't done too much
     * BFS yet but it will come in time.
     */

    public static void main(String[] args) {
        Problem0199_rightSideView problem = new Problem0199_rightSideView();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        List<Integer> result = problem.rightSideView(root);
        System.out.println(result); // Output: [1, 3, 4]

        // Additional test case
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.left.left = new TreeNode(5);
        List<Integer> result2 = problem.rightSideView(root2);
        System.out.println(result2); // Output: [1, 3, 4, 5]
    }
}
