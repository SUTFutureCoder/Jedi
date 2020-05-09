//Given a binary tree, check whether it is a mirror of itself (ie, symmetric aro
//und its center). 
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric: 
//
// 
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// But the following [1,2,2,null,3,null,3] is not: 
//
// 
//    1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// Follow up: Solve it both recursively and iteratively. 
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Deque<Integer> l = new LinkedList<>();
            Deque<Integer> r = new LinkedList<>();
            while (size-- > 0) {
                TreeNode tmp = q.pollFirst();
                if (tmp.left != null) {
                    l.addFirst(tmp.left.val);
                    q.addLast(tmp.left);
                } else {
                    l.addFirst(-1);
                }
                if (tmp.right != null) {
                    r.addLast(tmp.right.val);
                    q.addLast(tmp.right);
                } else {
                    r.addLast(-1);
                }
            }
            if (l.size() != r.size()){
                return false;
            }
            while (!l.isEmpty()) {
                if (!l.pollFirst().equals(r.pollFirst())) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
