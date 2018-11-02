package com.pointoffer.no11to20;

import com.lintcode.common.ListNode;

/**
 * 
 * 链表中倒数第k个结点
 * 
 * 1秒 空间限制：32768K 热度指数：488719
 * 
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月29日 下午5:29:02
 */
public class Pnum0014 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    /**
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(null == head || k == 0) {
            return null;
        }
        
        int i = 0;
        ListNode fastNode = head;
        while(++i < k && null!=fastNode) {
            fastNode = fastNode.next;
        }
        
        if(null == fastNode) {
            return null;
        }
        
        ListNode slowNode = head;
        while(null!=(fastNode=fastNode.next)) {
            slowNode = slowNode.next;
        }
        
        return slowNode;
    }
}
