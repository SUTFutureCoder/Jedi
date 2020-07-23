//Given a sorted linked list, delete all duplicates such that each element appea
//r only once. 
//
// Example 1: 
//
// 
//Input: 1->1->2
//Output: 1->2
// 
//
// Example 2: 
//
// 
//Input: 1->1->2->3->3
//Output: 1->2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head;
        ListNode pre = head;
        head = head.next;
        while (head != null) {
            while (head != null && head.val == pre.val) {
                head = head.next;
                pre.next = head;
            }
            pre = head;
            head = head == null ? null : head.next;
        }
        return dummy;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
