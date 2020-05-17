//Given two words (beginWord and endWord), and a dictionary's word list, find th
//e length of shortest transformation sequence from beginWord to endWord, such tha
//t: 
//
// 
// Only one letter can be changed at a time. 
// Each transformed word must exist in the word list. 
// 
//
// Note: 
//
// 
// Return 0 if there is no such transformation sequence. 
// All words have the same length. 
// All words contain only lowercase alphabetic characters. 
// You may assume no duplicates in the word list. 
// You may assume beginWord and endWord are non-empty and are not the same. 
// 
//
// Example 1: 
//
// 
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog
//" -> "cog",
//return its length 5.
// 
//
// Example 2: 
//
// 
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
// 
//
// 
// 
// Related Topics 广度优先搜索


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> q = new LinkedList<>();
        q.addFirst(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
//        Set<Character> cList = new HashSet<>();
//        for (String word: wordList) {
//            char[] wc = word.toCharArray();
//            for (char c: wc) {
//                cList.add(c);
//            }
//        }

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String qFirst = q.pollFirst();
                if (qFirst.equals(endWord)) {
                    return level;
                }
                char[] beginCharSet = qFirst.toCharArray();
                for (int i = 0; i < beginCharSet.length; i++) {
                    char old = beginCharSet[i];
                    System.out.println(new String(beginCharSet));
//                    for (char c : cList) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        beginCharSet[i] = c;
                        String beginStr = new String(beginCharSet);
                        if (wordSet.contains(beginStr)) {
                            q.addLast(beginStr);
                            wordSet.remove(beginStr);
                        }
                    }
                    beginCharSet[i] = old;
                }
            }
            level++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
