//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics 栈 数组


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= len; i++) {
            int h = (i == len) ? 0 : heights[i];
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
