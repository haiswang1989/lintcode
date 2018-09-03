package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 旋转链表
 * 
 * 给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数
 * 
 * 给出链表1->2->3->4->5->null和k=2
 * 
 * 返回4->5->1->2->3->null
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月7日 上午10:04:33
 */
public class Pnum0170 {

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
        
        Pnum0170 pnum0170 = new Pnum0170();
        ListNode newHead = pnum0170.rotateRight(ln1, 2);
        newHead.print();
        
    }
    
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(null == head) {
            return null;
        }
        
        int nodeCnt = getNodeCnt(head);
        k %= nodeCnt;
        if(0 == k) {
            return head;
        }
        
        ListNode slowNode = head;
        ListNode fastNode = head;
        
        int kCopy = k;
        while(--kCopy >= 0) {
            fastNode = fastNode.next;
        }
        
        while(null!=fastNode.next) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        
        ListNode newHead = slowNode.next;
        
        slowNode.next = null;
        fastNode.next = head;
        return newHead;
    }
    
    /**
     * 获取结点个数
     * @param head
     * @return
     */
    private int getNodeCnt(ListNode head) {
        ListNode loopNode = head;
        int nodeCnt = 1;
        while(null!=(loopNode=loopNode.next)) {
            ++nodeCnt;
        }
        
        return nodeCnt;
    }

}
