package com.lintcode.t201807;

import com.lintcode.common.ListNode;

/**
 *  翻转链表 II
 *  
 *  翻转链表中第m个节点到第n个节点的部分
 *  
 *  m，n满足1 ≤ m ≤ n ≤ 链表长度
 *  
 *  给出链表1->2->3->4->5->null， m = 2 和n = 4，返回1->4->3->2->5->null
 *  
 *  在原地一次翻转完成
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月11日 下午3:02:50
 */
public class Pnum0036 {

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
        
        Pnum0036 pnum0036 = new Pnum0036();
        ListNode newLn = pnum0036.reverseBetween(ln1, 1, 5);
        newLn.print();
    }
    
    /**
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if(null == head || null == head.next || m >= n) {
            return head;
        }
        
        int betweenMn = n - m;
        
        ListNode startNode = null;
        ListNode beforeStartNode = null;
        ListNode endNode = null;
        ListNode afterEndNode = null;
        
        endNode = head;
        afterEndNode = endNode.next;
        int betweenMnCopy = betweenMn;
        while(betweenMnCopy-- != 0) {
            endNode = afterEndNode;
            afterEndNode = endNode.next;
        }
        
        startNode = head;
        int mCopy = m;
        while(--mCopy != 0) {
            beforeStartNode = startNode;
            startNode = startNode.next;
            
            endNode = afterEndNode;
            afterEndNode = endNode.next;
        }
        
        ListNode beforeNode = null;
        ListNode currNode = startNode;
        ListNode nextNode = currNode.next;
        
        while(!nextNode.equals(endNode)) {
            currNode.next = beforeNode;
            beforeNode = currNode;
            currNode = nextNode;
            nextNode = currNode.next;
        }
        
        currNode.next = beforeNode;
        endNode.next = currNode;
        
        startNode.next = afterEndNode;
        
        if(null != beforeStartNode) {
            beforeStartNode.next = endNode;
        } else {
            return endNode;
        }
        
        return head;
    }
}
