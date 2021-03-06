//Merge two sorted linked lists and return it as a new list. The new list should
// be made by splicing together the nodes of the first two lists. 
//
// Example:
// 
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fin = new ListNode(0), dummy = fin;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                fin.next = l1;
                l1 = l1.next;
            } else {
                fin.next = l2;
                l2 = l2.next;
            }
            fin = fin.next;
        }
        if (l1 != null) {
            fin.next = l1;
        }
        if (l2 != null) {
            fin.next = l2;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
