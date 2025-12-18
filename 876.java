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
    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < (count)/2; i++) {
            cur =cur.next;
        }
        return cur;
    }
}
