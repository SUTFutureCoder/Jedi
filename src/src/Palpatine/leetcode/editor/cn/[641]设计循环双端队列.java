//Design your implementation of the circular double-ended queue (deque). 
//
// Your implementation should support following operations: 
//
// 
// MyCircularDeque(k): Constructor, set the size of the deque to be k. 
// insertFront(): Adds an item at the front of Deque. Return true if the operati
//on is successful. 
// insertLast(): Adds an item at the rear of Deque. Return true if the operation
// is successful. 
// deleteFront(): Deletes an item from the front of Deque. Return true if the op
//eration is successful. 
// deleteLast(): Deletes an item from the rear of Deque. Return true if the oper
//ation is successful. 
// getFront(): Gets the front item from the Deque. If the deque is empty, return
// -1. 
// getRear(): Gets the last item from Deque. If the deque is empty, return -1. 
// isEmpty(): Checks whether Deque is empty or not. 
// isFull(): Checks whether Deque is full or not. 
// 
//
// 
//
// Example: 
//
// 
//MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 
//3
//circularDeque.insertLast(1);			// return true
//circularDeque.insertLast(2);			// return true
//circularDeque.insertFront(3);			// return true
//circularDeque.insertFront(4);			// return false, the queue is full
//circularDeque.getRear();  			// return 2
//circularDeque.isFull();				// return true
//circularDeque.deleteLast();			// return true
//circularDeque.insertFront(4);			// return true
//circularDeque.getFront();			// return 4
// 
//
// 
//
// Note: 
//
// 
// All values will be in the range of [0, 1000]. 
// The number of operations will be in the range of [1, 1000]. 
// Please do not use the built-in Deque library. 
// 
// Related Topics 设计 队列


import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularDeque {

    Node head = null;
    int maxSize = 0;
    int currentSize = 0;
    Node last = null;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        maxSize = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        // 检查size
        if (maxSize < currentSize + 1) {
            return false;
        }
        currentSize++;
        if (currentSize == 1) {
            Node tmp = new Node(value);
            head = last = tmp;
            return true;
        }

        Node tmp = new Node(value, null, head);
        head.prev = tmp;
        tmp.next = head;
        head = tmp;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        // 检查size
        if (maxSize < currentSize + 1) {
            return false;
        }
        currentSize++;
        if (currentSize == 1) {
            Node tmp = new Node(value);
            head = last = tmp;
            return true;
        }

        Node tmp = new Node(value, last, null);
        last.next = tmp;
        tmp.prev = last;
        last = tmp;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (currentSize < 1 || head == null) {
            return false;
        }
        currentSize--;
        if (currentSize == 0) {
            last = head = null;
            return true;
        }
        head = head.next;
        head.prev = null;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (currentSize < 1 || last == null) {
            return false;
        }
        currentSize--;
        if (currentSize == 0) {
            last = head = null;
            return true;
        }
        last = last.prev;
        last.next = null;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return head != null ? head.val : -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return last != null ? last.val : -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return currentSize == maxSize;
    }

    private class Node {
        int  val;
        Node next;
        Node prev;

        Node(int val) {
            this(val, null, null);
        }

        Node(int val, Node prev) {
            this(val, prev, null);
        }

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
