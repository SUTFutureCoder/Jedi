//A gene string can be represented by an 8-character long string, with choices f
//rom "A", "C", "G", "T". 
//
// Suppose we need to investigate about a mutation (mutation from "start" to "en
//d"), where ONE mutation is defined as ONE single character changed in the gene s
//tring. 
//
// For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation. 
//
// Also, there is a given gene "bank", which records all the valid gene mutation
//s. A gene must be in the bank to make it a valid gene string. 
//
// Now, given 3 things - start, end, bank, your task is to determine what is the
// minimum number of mutations needed to mutate from "start" to "end". If there is
// no such a mutation, return -1. 
//
// Note: 
//
// 
// Starting point is assumed to be valid, so it might not be included in the ban
//k. 
// If multiple mutations are needed, all mutations during in the sequence must b
//e valid. 
// You may assume start and end string is not the same. 
// 
//
// 
//
// Example 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//return: 1
// 
//
// 
//
// Example 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//return: 2
// 
//
// 
//
// Example 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//return: 3
// 
//
// 
//


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String b : bank) {
            bankSet.add(b);
        }

        char[] chars = new char[]{'A', 'T', 'G', 'C'};

        int level = 0;

        Deque<String> q = new LinkedList<>();
        Set<String> visit = new HashSet<>();

        q.addFirst(start);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.pollFirst();
                if (curr.equals(end)) {
                    return level;
                }
                char[] charArray = curr.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char old = charArray[i];
                    for (char c: chars) {
                        charArray[i] = c;
                        String next = new String(charArray);
                        if (!visit.contains(next) && bankSet.contains(next)) {
                            q.addLast(next);
                        }
                    }
                    charArray[i] = old;
                }
                level++;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
