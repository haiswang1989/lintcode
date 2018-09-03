package com.lintcode.t201807;

import com.lintcode.common.ListNode;

/**
 * 删除排序链表中的重复元素
 * 
 * 给定一个排序链表，删除所有重复的元素每个元素只留下一个。
 * 
 * 给出 1->1->2->null，返回 1->2->null
 * 
 * 给出 1->1->2->3->3->null，返回 1->2->3->null
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月17日 下午2:21:41
 */
public class Pnum0112 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln1_1 = new ListNode(1);
        ListNode ln1_2 = new ListNode(1);
        ListNode ln2_1 = new ListNode(2);
        ListNode ln3_1 = new ListNode(3);
        ListNode ln3_2 = new ListNode(3);
        
        ln1_1.next = ln1_2;
        ln1_2.next = ln2_1;
        ln2_1.next = ln3_1;
        ln3_1.next = ln3_2;
        
        ln1_1.print();
        
        Pnum0112 pnum0112 = new Pnum0112();
        ListNode newHead = pnum0112.deleteDuplicates(ln1_1);
        
        newHead.print();
    }
    
    /**
     * 
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(null == head) {
            return head;
        }
        
        ListNode loopNode = head;
        ListNode nextNode = loopNode.next;
        
        while(null != nextNode) {
            if(loopNode.val == nextNode.val) {
                nextNode = nextNode.next;
                loopNode.next = nextNode;
            } else {
                loopNode = nextNode;
                nextNode = loopNode.next;
            }
        }
        
        return head;
    }

}
