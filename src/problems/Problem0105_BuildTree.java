package problems;

import java.util.HashMap;

public class Problem0105_BuildTree {
    int pre_index = 0;
    HashMap<Integer, Integer> inOrderIndices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndices.put(inorder[i], i); // instantiate map with inorder values and indices
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) {
            return null; // base case: no elements to construct the tree
        }

        // This is the beauty of the preorder traversal. The first element is ALWAYS the root of whatever our current tree is. We only increment one.
        int root_val = preorder[pre_index++];
        TreeNode root = new TreeNode(root_val);

        int mid = inOrderIndices.get(root_val); // NOW, here's the beauty of inorder traversal. Courtesy of the root from preorder, we now know the index at which the elements from the left and right subtrees are split.
        root.left = dfs(preorder, left, mid - 1);
        root.right = dfs(preorder, mid + 1, right);
        // interestingly this almost is like binary search; I think it's the way we are splitting the inorder hashmap between left and right subtrees by the middle root.
        // This is how we return null if left > right.. there's nothing left to split! 
        return root; // return the constructed root node
    }
}
