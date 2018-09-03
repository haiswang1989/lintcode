package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 回文链表
 * 
 * 设计一种方式检查一个链表是否为回文链表。
 * 
 * 1->2->1 就是一个回文链表。
 * 
 * O(n)的时间和O(1)的额外空间。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月8日 下午4:19:16
 */
public class Pnum0223 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln1_1 = new ListNode(1);
        ListNode ln1_2 = new ListNode(1);
        ListNode ln0_1 = new ListNode(0);
        ListNode ln0_2 = new ListNode(0);
        ListNode ln1_3 = new ListNode(1);
        
        ln1_1.next = ln1_2;
        ln1_2.next = ln0_1;
        ln0_1.next = ln0_2;
        ln0_2.next = ln1_3;
        
        
//        ListNode ln2_1 = new ListNode(2);
//        ListNode ln2_2 = new ListNode(2);
        
//        ln1_1.next = ln2_1;
//        ln2_1.next = ln2_2;
//        ln2_2.next = ln1_2;
        
        ln1_1.print();
        
        Pnum0223 pnum0223 = new Pnum0223();
        boolean isPalindrome = pnum0223.isPalindrome(ln1_1);
        System.out.println(isPalindrome);
    }
    
    /**
     * 
     * @param head: A ListNode.
     * @return: A boolean.
     */
    public boolean isPalindrome(ListNode head) {
        // write your code here
        //大致的思路就是将链表一分为二,分为前半部分和后半部分
        //然后将后半部分反转,然后用反转后的链表和前半部分进行比较
        if(null == head || null == head.next) {
            return true;
        }
        
        //快慢指针,快的一次跳两步,慢的一次跳一步
        ListNode slowNode = head;
        ListNode fastNode = head;
        
        while(null!=fastNode && null!=fastNode.next) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        
        //第二个List的开始结点
        //如果是偶数个结点,那么后半部分链表的头结点就是slowNode
        //如果是奇数个结点,那么后半部分链表的头检点就是slowNode.next
        //如何判定是奇数个结点还是偶数个结点呢
        //fastNode最后如果只指向的是null就是偶数个结点
        //如果是非null那么就是奇数个结点
        ListNode secondListNode = null;
        if(null == fastNode) {
            secondListNode = slowNode;
        } else {
            secondListNode = slowNode.next;
        }
        
        //反转链表
        ListNode secondListHead = reverseList(secondListNode);
        ListNode firstListLoop = head;
        ListNode secondListLoop = secondListHead;
        
        //回文判断
        while(null!=secondListLoop) {
            if(secondListLoop.val != firstListLoop.val) {
                return false;
            }
            
            secondListLoop = secondListLoop.next;
            firstListLoop = firstListLoop.next;
        }
        
        return true;
    }
    
    /**
     * 反转链表
     * @param head
     * @return
     */
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
}
