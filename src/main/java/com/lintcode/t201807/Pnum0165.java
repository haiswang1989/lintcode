package com.lintcode.t201807;

import com.lintcode.common.ListNode;

/**
 * 165. 合并两个排序链表
 * 
 * 将两个排序链表合并为一个新的排序链表
 * 
 * 给出 1->3->8->11->15->null，2->null， 返回 1->2->3->8->11->15->null。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月6日 下午5:01:09
 */
public class Pnum0165 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln1 = new ListNode(1);
        ListNode ln3 = new ListNode(3);
        ListNode ln8 = new ListNode(8);
        ListNode ln11 = new ListNode(11);
        ListNode ln15 = new ListNode(15);
        
        ln1.next = ln3;
        ln3.next = ln8;
        ln8.next = ln11;
        ln11.next = ln15;
        
        ListNode ln2 = new ListNode(2);
        
        Pnum0165 pnum0165 = new Pnum0165();
        ListNode lnNew = pnum0165.mergeTwoLists(ln1, ln2);
        lnNew.print();
    }
    
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(null == l1) {
            return l2;
        } else if(null == l2) {
            return l1;
        }
        
        ListNode l1LoopNode = l1;
        ListNode l2LoopNode = l2;
        ListNode newListHead = null;
        ListNode newListLoop = null;
        
        
        while(null!=l1LoopNode && null!=l2LoopNode) {
            if(l1LoopNode.val < l2LoopNode.val) {
                if(null == newListHead) {
                    newListHead = l1LoopNode;
                    newListLoop = newListHead;
                } else {
                    newListLoop.next = l1LoopNode;
                    newListLoop = l1LoopNode;
                }
                l1LoopNode = l1LoopNode.next;
            } else {
                if(null == newListHead) {
                    newListHead = l2LoopNode;
                    newListLoop = newListHead;
                } else {
                    newListLoop.next = l2LoopNode;
                    newListLoop = l2LoopNode;
                }
                l2LoopNode = l2LoopNode.next;
            }
        }
        
        if(null == l1LoopNode) {
            newListLoop.next = l2LoopNode;
        } else {
            newListLoop.next = l1LoopNode;
        }
        
        return newListHead;
    }
}
