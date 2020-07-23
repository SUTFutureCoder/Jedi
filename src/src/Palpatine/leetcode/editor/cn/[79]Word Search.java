class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        TrieNode trieNode = buildTrieNode(word);
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, trieNode, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, TrieNode trieNode, int m, int n, String word) {
        char c = board[m][n];
        if (c == '#' || trieNode.next[c - 'A'] == null) {
            return false;
        }
        trieNode = trieNode.next[c - 'A'];
        if (trieNode.word != null) {
            trieNode.word = null;
            return true;
        }

        board[m][n] = '#';
        if (m > 0) {
            if (dfs(board, trieNode, m - 1, n, word)) {
                return true;
            }
        }
        if (n > 0) {
            if (dfs(board, trieNode, m, n - 1, word)) {
                return true;
            }
        }
        if (m < board.length - 1) {
            if (dfs(board, trieNode, m + 1, n, word)) {
                return true;
            }
        }
        if (n < board[0].length - 1) {
            if (dfs(board, trieNode, m, n + 1, word)) {
                return true;
            }
        }
        board[m][n] = c;
        return false;
    }


    class TrieNode {
        String word;
        TrieNode[] next = new TrieNode[256];
    }

    private TrieNode buildTrieNode(String word) {
        TrieNode node = new TrieNode();
        TrieNode head = node;
        if (word == null || word.length() == 0) {
            return node;
        }
        for (char c : word.toCharArray()) {
            int n = c - 'A';
            if (node.next[n] == null) {
                node.next[n] = new TrieNode();
            }
            node = node.next[n];
        }
        node.word = word;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
