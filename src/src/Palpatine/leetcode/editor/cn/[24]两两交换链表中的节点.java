//Given a linked list, swap every two adjacent nodes and return its head. 
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged. 
//
// 
//
// Example: 
//
// 
//Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode fast = head.next;
        ListNode savedHead = fast;
        while (curr.next != null) {
            ListNode faster = fast.next;

            curr.next = faster;
            fast.next = curr;
            if (faster == null || faster.next == null) {
                break;
            }
            fast = faster.next;
            curr.next = fast;
            curr = faster;
        }
        return savedHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
