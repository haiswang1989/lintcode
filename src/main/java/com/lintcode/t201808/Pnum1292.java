package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 奇偶链表
 * 
 * 给定单链表，将所有奇数位置的节点组合在一起，然后是偶数位置的节点。 请注意，这里我们讨论的是节点位置，而不是节点中的值。
 * 
 * 偶数组和奇数组内的相对顺序应保持与输入中的相对顺序。
 * 第一个节点被认为是奇数，第二个节点被认为是偶数等等......
 * 
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月14日 下午3:48:31
 */
public class Pnum1292 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        
        Pnum1292 pnum1292 = new Pnum1292();
        ListNode newHead = pnum1292.oddEvenList(ln1);
        newHead.print();
        
    }
    
    /**
     * 
     * @param head: a singly linked list
     * @return: Modified linked list
     */
    public ListNode oddEvenList(ListNode head) {
        // write your code here
        if(null==head || null==head.next) {
            return head;
        }
        
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        
        ListNode evenListHead = evenNode;
        
        while(null!=evenNode && null!=evenNode.next) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        
        oddNode.next = evenListHead;
        return head;
        
        //return mySolution(head);
    }
    
    /**
     * 
     * @param head
     * @return
     */
    private ListNode mySolution(ListNode head) {
        if(null==head || null==head.next) {
            return head;
        }
        
        ListNode beforeOddNode = null;
        
        //偶数链表的head
        ListNode evenListHead = null;
        ListNode beforeEvenNode = null;
        
        ListNode oddNode = head;
        ListNode evenNode = null;
        while(null!=oddNode) {
            //当前奇数结点的下一个结点(偶数结点)
            evenNode = oddNode.next;
            
            if(null != beforeOddNode) {
                beforeOddNode.next = oddNode;
            } 
            beforeOddNode = oddNode;
            beforeOddNode.next = null;
            
            if(null == evenNode) {
                //偶数结点没了,链表到末尾了,直接用最后一个偶数结点连接奇数结点的头
                oddNode.next = evenListHead;
                break;
            } else {
                if(null!=beforeEvenNode) {
                    beforeEvenNode.next = evenNode;
                } else {
                    evenListHead = evenNode;
                }
                beforeEvenNode = evenNode;
                
                oddNode.next = evenListHead;
                //调整下一个奇数结点
                oddNode = evenNode.next;
                beforeEvenNode.next = null;
            }
        }
        
        return head;
    }
}
