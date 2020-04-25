//Given a non-empty array of integers, return the k most frequent elements. 
//
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1] 
// 
//
// Note: 
//
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size. 
// It's guaranteed that the answer is unique, in other words the set of the top 
//k frequent elements is unique. 
// You can return the answer in any order. 
// 
// Related Topics 堆 哈希表


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
//        LinkedHashMap<Integer, Set<Integer>> listLinkedHashMap = new LinkedHashMap<>();
//        Map<Integer, Integer> numInMap = new HashMap<>(16);
//        for (int num : nums) {
//            Integer key = numInMap.getOrDefault(num, 0);
//            if (key != 0) {
//                Set<Integer> keyList = listLinkedHashMap.get(key);
//                keyList.remove(num);
//                listLinkedHashMap.put(key, keyList);
//            }
//            Set<Integer> keyNextKeyList = listLinkedHashMap.containsKey(key + 1) ? listLinkedHashMap.get(key + 1) : new HashSet<>();
//            keyNextKeyList.add(num);
//            listLinkedHashMap.put(key + 1, keyNextKeyList);
//            numInMap.put(num, key + 1);
//        }
//
        int[] ret = new int[k];
//        int j = 0;
//        List<Integer> keySet = new ArrayList<>(listLinkedHashMap.keySet());
//        Collections.reverse(keySet);
//        for (Integer key: keySet) {
//            Set<Integer> tmp = listLinkedHashMap.get(key);
//            if (j == k) {
//                break;
//            }
//            for (Integer t : tmp) {
//                if (j == k) {
//                    break;
//                }
//                ret[j++] = t;
//            }
//        }






        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> freMap = new HashMap<>();
        for (int n : nums) {
            freMap.put(n, freMap.getOrDefault(n, 0) + 1);
        }
        for (Integer key: freMap.keySet()) {
            if (bucket[freMap.get(key)] == null) {
                bucket[freMap.get(key)] = new ArrayList<>();
            }
            bucket[freMap.get(key)].add(key);
        }

        for (int pos = bucket.length -1, j = 0; pos >= 0 && j <= k; pos--) {
            if (bucket[pos] != null) {
                ret2.addAll(bucket[pos]);
                for (Integer i : bucket[pos]) {
                    if (j == k) {
                        break;
                    }
                    ret[j++] = i;
                }
            }
        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
