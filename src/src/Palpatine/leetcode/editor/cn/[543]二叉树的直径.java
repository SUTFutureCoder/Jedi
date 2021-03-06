//
//Given a binary tree, you need to compute the length of the diameter of the tre
//e. The diameter of a binary tree is the length of the longest path between any t
//wo nodes in a tree. This path may or may not pass through the root.
// 
//
// 
//Example: 
//Given a binary tree 
// 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
// 
// 
// 
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
// 
//
// Note:
//The length of path between two nodes is represented by the number of edges bet
//ween them.
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

import javax.imageio.ImageTranscoder;

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

    int imax = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getWidth(root);
        return imax;
    }

    private int getWidth(TreeNode root) {
        // 左深度 + 右深度
        if (root == null) {
            return 0;
        }

        int left = getWidth(root.left);
        int right = getWidth(root.right);
        imax = Math.max(imax, left + right);
        return Math.max(left, right) + 1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
