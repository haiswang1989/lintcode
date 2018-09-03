package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * Delete Node in a Linked List
 * 
 * 给定一个单链表中的一个等待被删除的节点(非表头或表尾)。请在在O(1)时间复杂度删除该链表节点。
 * 
 * 
 * Linked list is 1->2->3->4, and given node 3, delete the node in place 1->2->4
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月9日 上午10:02:25
 */
public class Pnum0372 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        
        Pnum0372 pnum0372 = new Pnum0372();
        pnum0372.deleteNode(ln3);
        
        ln1.print();
    }
    
    /*
     * @param node: the node in the list should be deletedt
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        //大致思路就是将当前结点的后面一个结点的值赋值给当前结点
        //然后让当前结点的next设置为当前结点的next结点的next结点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
