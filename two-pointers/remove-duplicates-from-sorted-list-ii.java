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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head; 
        }
        if (head.val != head.next.val){
            // 如果头节点和身后节点的值不同，则对之后链表去重即可。 
            head.next = deleteDuplicates(head.next);
            return head; 
        }
        // 如果头节点和身后节点的值相同，则说明从head开始存在若干重复节点
        while (head.next != null && head.val == head.next.val){
            head = head.next; 
        }
        // 直接下一个不重复的节点开始，删除最后一个重复节点
        return deleteDuplicates(head.next); 
    }
}