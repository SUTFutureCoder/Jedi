//Implement a trie with insert, search, and startsWith methods. 
//
// Example: 
//
// 
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");   
//trie.search("app");     // returns true
// 
//
// Note: 
//
// 
// You may assume that all inputs are consist of lowercase letters a-z. 
// All inputs are guaranteed to be non-empty strings. 
// 
// Related Topics 设计 字典树 
// 👍 352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private boolean isEnd;
    private Trie[] tries;

    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        tries = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        Trie trie = this;
        for (char c : chars) {
            if (trie.tries[c - 'a'] == null) {
                trie.tries[c - 'a'] = new Trie();
            }
            trie = trie.tries[c - 'a'];
        }
        trie.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        Trie trie = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (trie.tries[c - 'a'] != null) {
                trie = trie.tries[c - 'a'];
            } else {
                return false;
            }
        }
        return trie != null && trie.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        Trie trie = this;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if (trie.tries[c - 'a'] != null) {
                trie = trie.tries[c - 'a'];
            } else {
                return false;
            }
        }
        return trie != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
