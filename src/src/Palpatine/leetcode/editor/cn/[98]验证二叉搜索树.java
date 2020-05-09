//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

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

//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
class Solution {

    Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        // 二叉搜索树中序遍历肯定是有序的
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);

        if (!left) {
            return false;
        }

        if (pre == null) {
            pre = root.val;
        } else {
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
        }
//
//        if ((root.left != null && root.val < root.left.val) || (root.right != null && root.val > root.right.val) ) {
//            return false;
//        }

        boolean right = isValidBST(root.right);

        return right;
    }



}
//leetcode submit region end(Prohibit modification and deletion)
