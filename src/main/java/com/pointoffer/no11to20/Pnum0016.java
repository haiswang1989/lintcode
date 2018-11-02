package com.pointoffer.no11to20;

import com.lintcode.common.ListNode;

/**
 * 
 * 合并两个排序的链表
 * 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：337381
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月29日 下午5:49:38
 */
public class Pnum0016 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln1 = new ListNode(1);
        ListNode ln3 = new ListNode(3);
        
        ln1.next = ln3;
        
        
        ListNode ln2 = new ListNode(2);
        ListNode ln4 = new ListNode(4);
        ln2.next = ln4;
        
        Pnum0016 pnum0016 = new Pnum0016();
        ListNode newListHead = pnum0016.Merge(ln1, ln2);
        System.out.println("----------" + newListHead);
    }
    
    /**
     * 
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(null == list1) {
            return list2;
        } else if(null == list2) {
            return list1;
        }
        
        ListNode l1LoopNode = list1;
        ListNode l2LoopNode = list2;
        
        ListNode newListHead = null;
        ListNode newListLoopNode = null;
        for(;null!=l1LoopNode && null!=l2LoopNode;) {
            ListNode newNode = null;
            if(l1LoopNode.val < l2LoopNode.val) {
                newNode = new ListNode(l1LoopNode.val);
                l1LoopNode = l1LoopNode.next;
            } else {
                newNode = new ListNode(l2LoopNode.val);
                l2LoopNode = l2LoopNode.next;
            }
            
            if(null == newListHead) {
                newListHead = newNode;
            } else {
                newListLoopNode.next = newNode;
            }
            
            newListLoopNode = newNode;
        }
        
        if(null != l1LoopNode) {
            appendLeft(newListLoopNode, l1LoopNode);
        } else if(null != l2LoopNode) {
            appendLeft(newListLoopNode, l2LoopNode);
        }
        
        return newListHead;
    }
    
    /**
     * 
     * @param newListLoopNode
     * @param leftListLoopNode
     */
    public void appendLeft(ListNode newListLoopNode, ListNode leftListLoopNode) {
        while(null!=leftListLoopNode) {
            ListNode newNode = new ListNode(leftListLoopNode.val);
            newListLoopNode.next = newNode;
            leftListLoopNode = leftListLoopNode.next;
        }
    }

}
