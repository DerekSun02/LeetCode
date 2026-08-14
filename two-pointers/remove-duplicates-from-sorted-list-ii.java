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
        // 快慢指针
        ListNode dummy = new ListNode();
        ListNode p = dummy, q = head; 

        while(q != null){
            // 发现重复元素 
            if (q.next != null && q.next.val == q.val){
                // while循环跳过一整段重复元素
                while (q.next != null && q.next.val == q.val){
                    q = q.next; 
                }
                if (q == null){
                    // 清空p.next,避免把重复元素加入dummy队列
                    p.next = null; 
                }
                q = q.next; 
            }else{
                // 不重复元素加入dummy队列
                p.next = q;
                p = p.next;
                q = q.next; 
            }
        }
        return dummy.next; 
    }
}