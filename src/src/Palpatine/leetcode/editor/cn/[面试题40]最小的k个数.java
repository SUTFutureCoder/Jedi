//English description is not available for the problem. Please switch to Chinese
//. Related Topics 堆 分治算法


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ret = new int[k];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i:arr) {
            q.add(i);
        }
        int i = 0;
        while (i < k && !q.isEmpty()) {
            ret[i++] = q.poll();
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
