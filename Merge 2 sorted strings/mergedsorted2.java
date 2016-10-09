/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private ListNode getSmaller(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else {
            if (l1.val < l2.val) {
                return l1;
            }
            else {
                return l2;
            }
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headNode = getSmaller(l1, l2);
        if (headNode == null) {
            return null;
        }
        else if (headNode == l1) {
            l1 = l1.next;
        }
        else {
            l2 = l2.next;
        }
        
        ListNode firstNode = headNode;
        
        ListNode temp;
        
        while ((temp = getSmaller(l1, l2)) != null) {
            headNode.next = temp;
            headNode = headNode.next;
            if (temp == l1) {
                l1 = l1.next;
            }
            else {
                l2 = l2.next;
            }
        }
        
        return firstNode;
        
    }
    
}