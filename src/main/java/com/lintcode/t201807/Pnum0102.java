package com.lintcode.t201807;

import com.lintcode.common.ListNode;

/**
 * 带环链表
 * 
 * 给定一个链表，判断它是否有环。
 * 
 * 给出 -21->10->4->5, tail connects to node index 1，返回 true
 * 
 * 不要使用额外的空间
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月26日 下午5:36:22
 */
public class Pnum0102 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln21 = new ListNode(21);
        ListNode ln10 = new ListNode(10);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        
        ln21.next = ln10;
        ln10.next = ln4;
        ln4.next = ln5;
        ln5.next = ln10;
        
        Pnum0102 pnum0102 = new Pnum0102();
        System.out.println(pnum0102.hasCycle(ln21));
    }
    
    /*
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(null == head || null == head.next) {
            return false;
        }
        
        ListNode slowNode = head;
        ListNode fastNode = head.next.next;
                
        
        while(null!=fastNode) {
            if(slowNode.val == fastNode.val) {
                return true;
            }
            
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if(null == fastNode) {
                return false;
            } else {
                fastNode = fastNode.next;
            }
        }
        
        return false;
    }

}
