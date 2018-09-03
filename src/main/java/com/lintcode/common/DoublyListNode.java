package com.lintcode.common;

/**
 * 双向链表
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月9日 上午10:28:40
 */
public class DoublyListNode {
    public int val;
    public DoublyListNode next, prev;
    
    public DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}
