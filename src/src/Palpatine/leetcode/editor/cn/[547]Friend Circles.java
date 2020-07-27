//
//There are N students in a class. Some of them are friends, while some are not.
// Their friendship is transitive in nature. For example, if A is a direct friend
//of B, and B is a direct friend of C, then A is an indirect friend of C. And we d
//efined a friend circle is a group of students who are direct or indirect friends
//.
//
//
//
//Given a N*N matrix M representing the friend relationship between students in
//the class. If M[i][j] = 1, then the ith and jth students are direct friends with
// each other, otherwise not. And you have to output the total number of friend ci
//rcles among all the students.
//
//
// Example 1:
//
//Input:
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//Output: 2
//Explanation:The 0th and 1st students are direct friends, so they are in a frie
//nd circle. The 2nd student himself is in a friend circle. So return 2.
//
//
//
// Example 2:
//
//Input:
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//Output: 1
//Explanation:The 0th and 1st students are direct friends, the 1st and 2nd stude
//nts are direct friends, so the 0th and 2nd students are indirect friends. All of
// them are in the same friend circle, so return 1.
//
//
//
//
// Note:
//
// N is in range [1,200].
// M[i][i] = 1 for all students.
// If M[i][j] = 1, then M[j][i] = 1.
//
// Related Topics 深度优先搜索 并查集
// 👍 283 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    class UnionFind {
//        private int count;
//        private int[] parent;
//        public UnionFind(int[][] m) {
//            if (m == null || m.length <= 0) {
//                return;
//            }
//            count = 0;
//            int n = m.length;
//            parent = new int[n];
//            for (int i = 0; i < n; i++) {
//                parent[i] = i;
//                count++;
//            }
//        }
//
//        public int getCount() {
//            return count;
//        }
//
//        public int find(int p) {
//            while (parent[p] != p) {
//                parent[p] = parent[parent[p]];
//                p = parent[p];
//            }
//            return p;
//        }
//
//        public void union(int p, int q) {
//            int rootp = find(p);
//            int rootq = find(q);
//            if (rootp != rootq) {
//                parent[rootp] = rootq;
//                count--;
//            }
//        }
//    }
//
//    public int findCircleNum(int[][] M) {
//        // 并查集
//        if (M == null || M.length <= 0) {
//            return 0;
//        }
//        UnionFind uf = new UnionFind(M);
//        int row = M.length;
//        int col = M[0].length;
//        for (int i = 0; i < row - 1; i++) {
//            for (int j = i; j < col; j++) {
//                if (M[i][j] == 1) {
//                    M[i][j] = 2;
//                    uf.union(i, j);
//                }
//            }
//        }
//        return uf.getCount();
//    }


    // DFS
    public int findCircleNum(int[][] M) {
        if (M == null || M.length <= 0) {
            return 0;
        }
        int[] visited = new int[M.length];
        int count = 0;
        int n = M.length;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            System.out.println("i" + i + ",j" + j);
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(m, visited, j);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
