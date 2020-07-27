//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 668 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // DFS
//    public int numIslands(char[][] grid) {
//
//        int islands = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    islands++;
//                    dfs(grid, i, j);
//                }
//            }
//        }
//        return islands;
//    }
//
//    private void dfs(char[][] grid, int i, int j) {
//        if (!isInArea(grid, i, j) || grid[i][j] != '1') {
//            return;
//        }
//        // mark the current position
//        grid[i][j] = '2';
//        dfs(grid, i - 1, j);
//        dfs(grid, i + 1, j);
//        dfs(grid, i, j - 1);
//        dfs(grid, i, j + 1);
//    }
//
//    private boolean isInArea(char[][] grid, int i, int j) {
//        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
//    }


    // BFS
//    public int numIslands(char[][] grid) {
//
//        int islands = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    islands++;
//                    bfs(grid, i, j);
//                }
//            }
//        }
//        return islands;
//    }
//
//    private void bfs(char[][] grid, int i, int j) {
//        Deque<int[]> q = new LinkedList<>();
//        q.addLast(new int[]{i, j});
//        while (!q.isEmpty()) {
//            int size = q.size();
//            while (size-- > 0) {
//                int[] current = q.pollFirst();
//                if (!isInArea(grid, current[0], current[1]) || grid[current[0]][current[1]] != '1') {
//                    continue;
//                }
//                grid[current[0]][current[1]] = '2';
//                q.addLast(new int[]{current[0] - 1, current[1]});
//                q.addLast(new int[]{current[0] + 1, current[1]});
//                q.addLast(new int[]{current[0], current[1] - 1});
//                q.addLast(new int[]{current[0], current[1] + 1});
//            }
//        }
//    }

    // 并查集
    class UnionFind {
        private int count;
        private int[] parent;
        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }

        public int getCount() {
            return count;
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int rooti = find(i);
            int rootj = find(j);
            if (rooti != rootj) {
                parent[rooti] = parent[rootj];
                count--;
            }
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int total = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        uf.union(i * col + j, (i + 1) * col + j);
                    }
                    if (j + 1 < col && grid[i][j + 1] == '1') {
                        uf.union(i * col + j, i * col + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
