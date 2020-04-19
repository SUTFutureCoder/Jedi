package Palpatine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * @author xingchen.lin
 * @desc https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @time 2020/4/19 8:25 上午.
 */
public class M50 {

    public char firstUniqChar(String s) {
         if (s == null || s.length() == 0) {
             return ' ';
         }
         int[] dict = new int[256];
         for (char c: s.toCharArray()) {
            dict[c]++;
         }
         for (char c: s.toCharArray()) {
             if (dict[c] == 1) {
                 return c;
             }
         }
         return ' ';

//         HashMap<Character, Integer> map = new LinkedHashMap<>();
//         for (Character c: s.toCharArray()) {
//             Integer tmp = map.getOrDefault(c, 0);
//             map.put(c, ++tmp);
//         }
//         for (Character c: map.keySet()) {
//             if (map.get(c).equals(1)) {
//                 return c;
//             }
//         }
//         return ' ';
    }

}
