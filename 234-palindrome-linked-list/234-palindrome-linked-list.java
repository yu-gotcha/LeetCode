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
import java.util.*;

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<>();
        
        ListNode node = head;
        
        while(node != null) {
            s.push(node.val);
            node = node.next;
        }
        
        int size = s.size();
        while(s.size() > size / 2) {
            if(s.pop() != head.val) return false;
            head = head.next;
        }
        
        return true;
    }
    
}