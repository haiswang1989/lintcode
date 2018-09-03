package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 链表节点计数
 * 
 * 计算链表中有多少个节点.
 * 
 * 给出 1->3->5, 返回 3
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月14日 下午3:37:37
 */
public class Pnum0466 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln1 = new ListNode(1);
        ListNode ln3 = new ListNode(3);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln3;
        ln3.next = ln5;
        
        Pnum0466 pnum0466 = new Pnum0466();
        System.out.println(pnum0466.countNodes(ln1));
    }
    
    /**
     * @param head: the first node of linked list.
     * @return: An integer
     */
    public int countNodes(ListNode head) {
        // write your code here
        if(null == head) {
            return 0;
        }
        
        int count = 0;
        ListNode loopNode = head;
        while(null!=loopNode) {
            ++count;
            loopNode = loopNode.next;
        }
        
        return count;
    }

}
