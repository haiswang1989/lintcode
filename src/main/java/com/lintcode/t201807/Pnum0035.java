package com.lintcode.t201807;

import com.lintcode.common.ListNode;

/**
 * 翻转一个链表
 * 
 * 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null
 * 
 * 在原地一次翻转完成
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月11日 下午2:41:06
 */
public class Pnum0035 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        
        ln1.next = ln2;
        ln2.next = ln3;
        
        Pnum0035 pnum0035 = new Pnum0035();
        ListNode newLn = pnum0035.reverse(ln1);
        newLn.print();
    }
    
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(null == head || null == head.next) {
            return head;
        } 
        
        ListNode beforeNode = null;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        
        while(null!=nextNode) {
            currNode.next = beforeNode;
            beforeNode = currNode;
            currNode = nextNode;
            nextNode = currNode.next;
        }
        
        currNode.next = beforeNode;
        return currNode;
    }
    
}
