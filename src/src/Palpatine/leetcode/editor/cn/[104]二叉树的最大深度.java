//Given a binary tree, find its maximum depth. 
//
// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given binary tree [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// return its depth = 3. 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    Integer max = 0;

    public int maxDepth(TreeNode root) {
//        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        if (root == null) {
            return 0;
        }
        // DFS
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<Integer> depth = new Stack<>();
//        stack.push(root);
//        depth.push(1);
//        int max = 0;
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            int tmp = depth.pop();
//            max = Math.max(max, tmp);
//            if (node.left != null) {
//                stack.push(node.left);
//                depth.push(tmp + 1);
//            }
//            if (node.right != null) {
//                stack.push(node.right);
//                depth.push(tmp + 1);
//            }
//        }


        // BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            max++;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
