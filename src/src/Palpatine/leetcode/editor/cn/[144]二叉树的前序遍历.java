//Given a binary tree, return the preorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,2,3]
// 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics 栈 树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> list = new ArrayList<>();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                list.add(curr.val);
//                stack.push(curr);
//                curr = curr.left;
//            }
//
//            TreeNode treeNode = stack.pop();
//            if (treeNode.right != null) {
//                curr = treeNode.right;
//            }
//        }
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
