// https://leetcode.com/problems/palindrome-linked-list/

// Time Complexity: O(n)
// Space Complexity: O(1)

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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode start = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            System.out.println(fast.next.next.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = null;
        ListNode current = slow.next;
        ListNode prev = null;

        slow.next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        while(start != null && prev != null) {
            if(start.val != prev.val){
                return false;
            }
            start = start.next;
            prev = prev.next;
        }

        return true;
    }
}