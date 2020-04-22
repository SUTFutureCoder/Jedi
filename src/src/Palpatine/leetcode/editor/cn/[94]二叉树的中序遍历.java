//Given a binary tree, return the inorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2] 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics 栈 树 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
//    List<Integer> ret = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root != null) {
//            inorderTraversal(root.left);
//            ret.add(root.val);
//            inorderTraversal(root.right);
//        }





//
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        List<Integer> ret = new ArrayList<>();
//        Deque<TreeNode> dq = new ArrayDeque<>();
//        Set<TreeNode> set = new HashSet<>();
//        dq.addFirst(root);
//        while (!dq.isEmpty()) {
//            TreeNode curr = dq.peekFirst();
//            if (curr.left != null && !set.contains(curr.left)) {
//                dq.addFirst(curr.left);
//                continue;
//            }
//            ret.add(curr.val);
//            set.add(curr);
//            dq.pollFirst();
//            if (curr.right != null && !set.contains(curr.right)) {
//                dq.addFirst(curr.right);
//            }
//        }


        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;

//        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
