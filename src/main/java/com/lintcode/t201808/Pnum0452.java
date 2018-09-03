package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 删除链表中的元素
 * 
 * 删除链表中等于给定值val的所有节点。
 * 
 * 给出链表 1->2->3->3->4->5->3, 和 val = 3, 你需要返回删除3之后的链表：1->2->4->5。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月10日 上午9:22:46
 */
public class Pnum0452 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3_1 = new ListNode(3);
        ListNode ln3_2 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(3);
        
        ln1.next = ln2;
        ln2.next = ln3_1;
        ln3_1.next = ln3_2;
        ln3_2.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        
        Pnum0452 pnum0452 = new Pnum0452();
        ListNode re = pnum0452.removeElements(ln1, 3);
        re.print();
    }
    
    /**
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        
        //遍历结点的前面一个结点
        ListNode beforeNode = null;
        //遍历结点
        ListNode loopNode = head;
        //返回的List的头结点
        ListNode newHead = head;
        
        while(null!=loopNode) {
            if(loopNode.val == val) {
                if(null == beforeNode) {
                    //链表的头结点和删除值一致,需要更新返回List的头结点
                    newHead = loopNode.next;
                } else {
                    //删除结点
                    beforeNode.next = loopNode.next;
                }
            } else {
                //更新遍历结点的前置结点
                beforeNode = loopNode;
            }
            
            //继续处理下一个结点
            loopNode = loopNode.next;
        }
        
        return newHead;
    }
}
