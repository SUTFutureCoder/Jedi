//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you im
//plement both? 
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
    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode fast = head.next;
//        ListNode curr = head;
//        while (fast != null) {
//            ListNode faster = fast.next;
//            fast.next = curr;
//            curr = fast;
//            fast = faster;
//        }
//        head.next = null;
//        return curr;

        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
