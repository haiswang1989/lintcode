package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 两个链表的交叉
 * 
 * 请写一个程序，找到两个单链表最开始的交叉节点
 * 
 * 如果两个链表没有交叉，返回null
 * 在返回结果后，两个链表仍须保持原有的结构
 * 可假定整个链表结构中没有循环
 * 
 * 下列两个链表：
 * A:     a1 → a2
 *                ↘
 *                   c1 → c2 → c3
 *                ↗            
 * B:b1 → b2 → b3
 * 
 * 在节点 c1 开始交叉。
 * 
 * 需满足 O(n) 时间复杂度，且仅用 O(1) 内存。  
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月9日 上午11:02:59
 */
public class Pnum0380 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode lna1 = new ListNode(1);
        ListNode lna2 = new ListNode(2);
        
        lna1.next = lna2;
                
        
        
        ListNode lna1_1 = new ListNode(1);
        ListNode lna2_1 = new ListNode(2);
        lna1_1.next = lna2_1;
        
        
        
        Pnum0380 pnum0380 = new Pnum0380();
        ListNode intersectionNode = pnum0380.getIntersectionNode(lna1, lna1_1);
        System.out.println(intersectionNode);
    }
    
    /**
     * 
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        if(null == headA || null == headB) {
            return null;
        }
        
        int aLength = length(headA);
        int bLength = length(headB);
        
        ListNode aLoop = headA;
        ListNode bLoop = headB;
        
        if(aLength > bLength) {
            int moveStepCnt = aLength - bLength;
            while(--moveStepCnt >= 0) {
                aLoop = aLoop.next;
            }
        } else if(aLength < bLength) {
            int moveStepCnt = bLength - aLength;
            while(--moveStepCnt >= 0) {
                bLoop = bLoop.next;
            }
        } 
        
        while(null!=aLoop && null!=bLoop) {
            if(aLoop == bLoop) {
                return aLoop;
            }
            
            aLoop = aLoop.next;
            bLoop = bLoop.next;
        }
        
        return null;
    }
    
    /**
     * 
     * @param ln
     * @return
     */
    private int length(ListNode ln) {
        ListNode loopNode = ln;
        int length = 1;
        while(null!=(loopNode=loopNode.next)) {
            length++;
        }
        
        return length;
    }
    
    
    
    /**
     * 解题思路,反转两个链表
     * 然后遍历比较反转以后的链表
     * 
     * 该方案成功的额前提,就是相交的结点只是value相等,而非地址相等(不是同一个ListNode)
     * 
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    /*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        if(null == headA || null == headB) {
            return null;
        }
        
        ListNode headAReversed = reverseList(headA);
        ListNode headBReversed = reverseList(headB);
        
        ListNode intersectionNode = null;
        
        ListNode headAReversedLoopNode = headAReversed;
        ListNode headBReversedLoopNode = headBReversed;
        
        while(null!=headAReversedLoopNode && null!=headBReversedLoopNode && headAReversedLoopNode.val == headBReversedLoopNode.val) {
            intersectionNode = headAReversedLoopNode;
            headAReversedLoopNode = headAReversedLoopNode.next;
            headBReversedLoopNode = headBReversedLoopNode.next;
        }
        
        reverseList(headAReversed);
        reverseList(headBReversed);
        
        return intersectionNode;
    }
    */
    
    /**
     * 反转链表
     * @param head
     * @return
     */
    /*
    public ListNode reverseList(ListNode head) {
        if(null == head || null==head.next) {
            return head;
        }
        
        ListNode beforeLoopNode = null;
        ListNode loopNode = head;
        ListNode loopNodeNext = head.next;
        while(null!=loopNodeNext) {
            loopNode.next = beforeLoopNode;
            beforeLoopNode = loopNode;
            loopNode = loopNodeNext;
            loopNodeNext = loopNodeNext.next;
        }
        
        loopNode.next = beforeLoopNode;
        return loopNode;
    } 
    */
}
