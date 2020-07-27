class Solution {

    class UnionFind {
        private int count;
        private int[] parent;
        public UnionFind(int n) {
            count = 0;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                count++;
            }
        }

        public int getCount() {
            return count;
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootp = find(p);
            int rootq = find(q);
            if (rootp != rootq) {
                parent[rootp] = rootq;
                count--;
            }
        }

        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length <= 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                helper(board, 0, i);
            }
            if (board[row - 1][i] == 'O') {
                helper(board, row - 1, i);
            }
        }
        for (int i = 1; i < row - 1; i++) {
            if (board[i][0] == 'O') {
                helper(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                helper(board, i, col - 1);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
//        UnionFind uf = new UnionFind(row * col + 1);
//        int dummyNode = row * col;
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (board[i][j] != 'O') {
//                    continue;
//                }
//                board[i][j] = 'X';
//                if (i == 0 || j == 0 || j == col - 1 || i == row - 1) {
//                    uf.union(i * col + j, dummyNode);
//                }
//                         if (i + 1 < row && board[i + 1][j] == 'O') {
//                    uf.union(i * col + j, (i + 1) * col + j);
//                }
//                if (j + 1 < col && board[i][j + 1] == 'O') {
//                    uf.union(i * col + j, i * col + j + 1);
//                }
//            }
//        }
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (uf.isConnected(i * col + j, dummyNode)) {
//                    board[i][j] = 'O';
//                }
//            }
//        }
    }

    private void helper(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O' ) {
            return;
        }
        board[i][j] = '*';
        helper(board, i - 1, j);
        helper(board, i + 1, j);
        helper(board, i, j - 1);
        helper(board, i, j + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
