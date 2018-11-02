package com.pointoffer.no11to20;

import com.lintcode.common.ListNode;

/**
 * 
 * 反转链表
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：355048
 * 
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月29日 下午5:41:54
 */
public class Pnum0015 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        
        
        Pnum0015 pnum0015 = new Pnum0015();
        ListNode newHead = pnum0015.ReverseList(ln1);
        System.out.println("---------------------" + newHead);
    }
    
    /**
     * 
     * 
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if(null == head) {
            return head;
        }
        
        ListNode before = null;
        ListNode loopNode = head;
        ListNode nextNode = null;
        
        while(null!=loopNode && null!=(nextNode=loopNode.next)) {
            loopNode.next = before;
            before = loopNode;
            loopNode = nextNode;
        }
        
        loopNode.next = before;
        return loopNode;
    }

}
