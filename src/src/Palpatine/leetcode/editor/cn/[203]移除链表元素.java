//Remove all elements from a linked list of integers that have value val. 
//
// Example: 
//
// 
//Input:  1->2->6->3->4->5->6, val = 6
//Output: 1->2->3->4->5
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
                fast = slow.next;
                continue;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
