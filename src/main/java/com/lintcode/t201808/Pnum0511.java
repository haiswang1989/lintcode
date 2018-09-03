package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 
 * 交换链表当中两个节点
 * 
 * 给你一个链表以及两个权值v1和v2，交换链表中权值为v1和v2的这两个节点。保证链表中节点权值各不相同，如果没有找到对应节点，那么什么也不用做
 * 
 * 给出链表 1->2->3->4->null ，以及 v1 = 2 ， v2 = 4
 * 
 * 返回结果 1->4->3->2->null。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月10日 上午9:41:45
 */
public class Pnum0511 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        
        Pnum0511 pnum0511 = new Pnum0511();
        ListNode re = pnum0511.swapNodes(ln1, 1, 4);
        re.print();
    }
    
    /**
     * 
     * @param head: a ListNode
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if(null == head || null == head.next) {
            return head;
        }
        
        ListNode v1Before = null;
        ListNode v1Node = null;
        
        ListNode v2Before = null;
        ListNode v2Node = null;
        
        ListNode loopNodeBefore = null;
        ListNode loopNode = head;
        
        while(null != loopNode) {
            if(loopNode.val == v1) {
                v1Node = loopNode;
                v1Before = loopNodeBefore;
            } else if(loopNode.val == v2) {
                v2Node = loopNode;
                v2Before = loopNodeBefore;
            } 

            loopNodeBefore = loopNode;
            loopNode = loopNode.next;
        }
        
        if(null != v1Node && null != v2Node) {
            if(v1Before == v2Node) { 
                //结点相连,v2在v1前面
                if(null == v2Before) { 
                    //v2是第一个结点,返回时需要调整head结点
                    v2Node.next = v1Node.next;
                    v1Node.next = v2Node;
                    return v1Node;
                } else {
                    //v2不是第一个结点
                    ListNode v1NodeNext = v1Node.next;
                    v1Node.next = v2Node;
                    v2Node.next = v1NodeNext;
                    v2Before.next = v1Node;
                }
            } else if(v2Before == v1Node) { 
                //结点相连,v1在v2前面
                if(null == v1Before) {
                    //v1是第一个结点,返回时需要调整head结点
                    v1Node.next = v2Node.next;
                    v2Node.next = v1Node;
                    return v2Node;
                } else {
                    //v2不是第一个结点
                    ListNode v2NodeNext = v2Node.next;
                    v2Node.next = v1Node;
                    v1Node.next = v2NodeNext;
                    v1Before.next = v2Node;
                }
            } else {
                if(null == v1Before) {
                    ListNode v1Next = v1Node.next;
                    v2Before.next = v1Node;
                    v1Node.next = v2Node.next;
                    v2Node.next = v1Next;
                    
                    return v2Node;
                } else if(null == v2Before) {
                    ListNode v1Next = v1Node.next;
                    v1Node.next = v2Node.next;
                    v1Before.next = v2Node;
                    v2Node.next = v1Next;
                    
                    return v1Node;
                } else {
                    ListNode v1Next = v1Node.next;
                    v2Before.next = v1Node;
                    v1Node.next = v2Node.next;
                    
                    v1Before.next = v2Node;
                    v2Node.next = v1Next;
                }
            }
        }
        
        return head;
    }
}
