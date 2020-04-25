//Given an n-ary tree, return the level order traversal of its nodes' values. 
//
// Nary-Tree input serialization is represented in their level order traversal, 
//each group of children is separated by the null value (See examples). 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [[1],[3,2,4],[5,6]]
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
// Constraints: 
//
// 
// The height of the n-ary tree is less than or equal to 1000 
// The total number of nodes is between [0, 10^4] 
// 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
//        Deque<Node> q = new ArrayDeque<>();
//        q.addFirst(root);
//
//        while (!q.isEmpty()) {
//            List<Integer> row = new ArrayList<>();
//
//            int len = q.size();
//            for (int i = 0; i < len; i++) {
//                Node curr = q.pollFirst();
//                row.add(curr.val);
//                if (root.children != null) {
//                    for (Node n : curr.children) {
//                        q.addLast(n);
//                    }
//                }
//            }
//            list.add(row);
//        }

        Deque<Node> q = new ArrayDeque<Node>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node curr = q.pollFirst();
                row.add(curr.val);
                for (Node c: curr.children) {
                    q.addLast(c);
                }
            }
            list.add(row);
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
