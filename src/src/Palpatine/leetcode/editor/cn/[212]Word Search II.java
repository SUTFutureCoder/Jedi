//Given a 2D board and a list of words from the dictionary, find all words in th
//e board. 
//
// Each word must be constructed from letters of sequentially adjacent cell, whe
//re "adjacent" cells are those horizontally or vertically neighboring. The same l
//etter cell may not be used more than once in a word. 
//
// 
//
// Example: 
//
// 
//Input: 
//board = [
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//words = ["oath","pea","eat","rain"]
//
//Output: ["eat","oath"]
// 
//
// 
//
// Note: 
//
// 
// All inputs are consist of lowercase letters a-z. 
// The values of words are distinct. 
// 
// Related Topics 字典树 回溯算法 
// 👍 198 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, TrieNode root, int i, int j, List<String> res) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) {
            return;
        }
        root = root.next[c - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, root, i - 1, j, res);
        }
        if (j > 0) {
            dfs(board, root, i, j - 1, res);
        }
        if (i < board.length - 1) {
            dfs(board, root, i + 1, j, res);
        }
        if (j < board[0].length - 1) {
            dfs(board, root, i, j + 1, res);
        }
        board[i][j] = c;
    }

    class TrieNode {
        String word;
        TrieNode[] next = new TrieNode[26];
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        if (words == null || words.length == 0) {
            return root;
        }
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.word = w;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
