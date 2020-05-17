//You need to find the largest value in each row of a binary tree. 
//
// Example: 
// 
//Input: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//Output: [1, 3, 9]
// 
// 
// Related Topics 树 深度优先搜索 广度优先搜索


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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.addFirst(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Integer levelMax = q.peekFirst().val;
            while (size-- > 0) {
                TreeNode tmp = q.pollFirst();
                if (tmp.val > levelMax) {
                    levelMax = tmp.val;
                }
                if (tmp.left != null) {
                    q.addLast(tmp.left);
                }
                if (tmp.right != null) {
                    q.addLast(tmp.right);
                }
            }
            res.add(levelMax);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
