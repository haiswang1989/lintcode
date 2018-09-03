package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 删除链表中倒数第n个节点
 * 
 * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。
 * 
 * 链表中的节点个数大于等于n
 * 
 * 给出链表1->2->3->4->5->null和 n = 2.
 * 
 * 删除倒数第二个节点之后，这个链表将变成1->2->3->5->null.
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月8日 上午11:19:49
 */
public class Pnum0174 {

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
        
        Pnum0174 pnum0174 = new Pnum0174();
        ListNode newRe = pnum0174.removeNthFromEnd(ln1, 5);
        newRe.print();
        
    }
    
    /**
     * 
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(null==head || 0==n) {
            return head;
        }
        
        //使用快慢指针来实现
        ListNode fastNode = head;
        ListNode slowNode = head;
        
        //先根据N来移动快指针,让快指针和慢指针之间间隔N个元素
        while(--n >= 0 && null!=fastNode) {
            fastNode = fastNode.next;
        }
        
        //如果
        if(null == fastNode) {
            return head.next;
        }
        
        while(null!=fastNode.next) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        
        ListNode slowNext = slowNode.next;
        slowNode.next = slowNext.next;
        
        return head;
    }
}
