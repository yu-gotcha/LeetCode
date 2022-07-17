/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int size = getSize(head);
        if(k % size == 0) return head;
        int n = size - k % size;
        ListNode nextHead, nextTail, tmp = head;
        
        System.out.println("size: " + size + ", n: " + n);
        
        if(n == 0 || size == 1) return head;
        
        for(int i = 1; i <= n - 1; i++) tmp = tmp.next;
        
        nextHead = tmp.next;
        tmp.next = null;
        tmp = nextHead;
        
        if(tmp.next == null) tmp.next = head;
        else {
            while(tmp.next != null) tmp = tmp.next;
            tmp.next = head;
        }
        
        return nextHead;
        
    }
    
    public int getSize(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}