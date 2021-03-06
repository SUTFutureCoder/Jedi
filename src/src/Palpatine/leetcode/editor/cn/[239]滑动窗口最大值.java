//Given an array nums, there is a sliding window of size k which is moving from 
//the very left of the array to the very right. You can only see the k numbers in 
//the window. Each time the sliding window moves right by one position. Return the
// max sliding window. 
//
// Follow up: 
//Could you solve it in linear time? 
//
// Example: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7] 
//Explanation: 
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Comparator cmp = (o1, o2) -> (int)o2 - (int)o1;

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(cmp);
        int[] ret = new int[nums.length - k + 1];
        // init
        int last = 0;
        while (last < k) {
            q.add(nums[last++]);
        }
        int i = 0;
        ret[i++] = q.peek();
        // poll
        while (last < nums.length) {
            q.remove(nums[last - k]);
            q.add(nums[last++]);
            ret[i++] = q.peek();
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
