package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * K组翻转链表
 * 给你一个链表以及一个k,将这个链表从头指针开始每k个翻转一下。
 * 链表元素个数不是k的倍数，最后剩余的不用翻转。
 * 
 * 给出链表 1->2->3->4->5
 * 
 * k = 2, 返回 2->1->4->3->5
 * k = 3, 返回 3->2->1->4->5
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月9日 下午3:50:45
 */
public class Pnum0450 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        
    }
    
    /**
     * 
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        
        if(null == head || k == 1) {
            return head;
        }
        
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode beforeFastNode = null;
        
        
        return null;
    }

}
