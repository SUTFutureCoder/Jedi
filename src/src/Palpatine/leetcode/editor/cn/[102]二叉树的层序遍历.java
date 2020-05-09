//Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            while (size-- > 0) {
                TreeNode tmp = q.pollFirst();
                if (tmp == null && q.isEmpty()) {
                    return ret;
                }
                row.add(tmp.val);
                if (tmp.left != null) {
                    q.addLast(tmp.left);
                }
                if (tmp.right != null) {
                    q.addLast(tmp.right);
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
