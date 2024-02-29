// https://leetcode.com/problems/reverse-linked-list/

// Time Complexity: O(n)
// Space Compexity: O(n)
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
    ListNode reversed = new ListNode(-1);
    public ListNod  e reverseList(ListNode head) {
        // ListNode prev = null;
        // ListNode current = head;
        // ListNode next = null;

        // while(current != null){
        //     next = current.next;
        //     current.next = prev;
        //     prev = current;
        //     current = next;
        // }

        // return prev;
        if(head == null) return null;
        helper(head);
        return reversed;
    }

    private void helper(ListNode head) {
        if(head.next == null){
            reversed = head;
            return;
        }

        helper(head.next);

        head.next.next = head;
        head.next = null;

    }
}