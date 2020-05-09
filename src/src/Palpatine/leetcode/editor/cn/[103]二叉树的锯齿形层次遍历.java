//Given a binary tree, return the zigzag level order traversal of its nodes' val
//ues. (ie, from left to right, then right to left for the next level and alternat
//e between). 
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
//return its zigzag level order traversal as: 
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索


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
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        boolean addFirst = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            Deque<TreeNode> tmpQ = new LinkedList<>();
            while (size-- > 0) {
                TreeNode tmp = q.pollFirst();
                if (tmp.left != null) {
                    q.addLast(tmp.left);
                }
                if (tmp.right != null) {
                    q.addLast(tmp.right);
                }

                if (addFirst) {
                    tmpQ.addFirst(tmp);
                } else {
                    tmpQ.addLast(tmp);
                }

            }

            while (!tmpQ.isEmpty()) {
                row.add(tmpQ.pollFirst().val);
            }
            addFirst = !addFirst;
            ret.add(row);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
