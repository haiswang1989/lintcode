package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 两两交换链表中的节点
 * 
 * 给一个链表，两两交换其中的节点，然后返回交换后的链表
 * 
 * 给出 1->2->3->4, 你应该返回的链表是 2->1->4->3
 * 
 * 你的算法只能使用常数的额外空间，并且不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月9日 下午4:31:55
 */
public class Pnum0451 {

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
        
        Pnum0451 pnum0451 = new Pnum0451();
        ListNode re = pnum0451.swapPairs(ln1);
        re.print();
        
    }
    
    /**
     * 
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // write your code here
        if(null == head || null == head.next) {
            return head;
        }
        
        ListNode beforeNode = null;
        ListNode slowNode = head;
        ListNode fastNode = null;
        
        ListNode newHead = null;
        
        while(null!=slowNode) {
            fastNode = slowNode.next;
            if(null != fastNode) {
                ListNode slowNodeTemp = fastNode.next;
                fastNode.next = slowNode;
                slowNode.next = null;
                if(null != beforeNode) {
                    beforeNode.next = fastNode;
                } else {
                    newHead = fastNode;
                }
                
                beforeNode = slowNode;
                slowNode = slowNodeTemp;
            } else {
                beforeNode.next = slowNode;
                break;
            }
        }
        
        return newHead;
    }
}
