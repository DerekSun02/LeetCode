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
        ListNode dummyDup = new ListNode(101), dummyUniq = new ListNode(101);
        ListNode curDup = dummyDup, curUniq = dummyUniq; 

        while (head != null){
            // 发现重复元素,加入重复链表。
            if (head.val == curDup.val || (head.next != null && head.next.val == head.val)){
                curDup.next = head;
                curDup = curDup.next;
            }else{
                // 不重复元素加入非重复链表. 
                curUniq.next = head; 
                curUniq = curUniq.next; 
            }
            head = head.next; 
        }
        curUniq.next = null; 
        return dummyUniq.next; 
    }
}