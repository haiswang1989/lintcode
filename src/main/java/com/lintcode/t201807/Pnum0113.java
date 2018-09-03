package com.lintcode.t201807;

import com.lintcode.common.ListNode;

/**
 * 删除排序链表中的重复数字 II
 * 
 * 给定一个排序链表，删除所有重复的元素只留下原链表中没有重复的元素。
 * 
 * 给出 1->2->3->3->4->4->5->null，返回 1->2->5->null
 * 
 * 给出 1->1->1->2->3->null，返回 2->3->null
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月17日 下午4:28:43
 */
public class Pnum0113 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln1_1 = new ListNode(1);
        ListNode ln1_2 = new ListNode(1);
        ListNode ln1_3 = new ListNode(1);
        
        ListNode ln2_1 = new ListNode(2);
        ListNode ln2_2 = new ListNode(2);
        ListNode ln3_1 = new ListNode(3);
        ListNode ln3_2 = new ListNode(3);
        
        ln1_1.next = ln1_2;
        ln1_2.next = ln1_3;
        ln1_3.next = ln2_1;
        ln2_1.next = ln2_2;
        ln2_2.next = ln3_1;
        ln3_1.next = ln3_2;
        
        ln1_1.print();
        
        Pnum0113 pnum0113 = new Pnum0113();
        ListNode newNode = pnum0113.deleteDuplicates(ln1_1);
        newNode.print();
        
    }
    
    /**
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(null == head) {
            return null;
        }
        
        ListNode beforeNode = null; //当前遍历的前面一个结点
        ListNode loopNode = head; //当前遍历的结点
        ListNode nextNode = head.next; //当前遍历的结点的后面一个结点
        //是否重复了,如果出现重复了,那么loopNode也需要丢弃
        boolean isDuplicate = false;
        while(null != nextNode) {
            if(loopNode.val == nextNode.val) { 
                //如果两个相连的结点重复,那么就把next结点删除了
                //比如A->B->C,如果A和B重复,就把B删除,直接A->C
                isDuplicate = true;
                nextNode = nextNode.next; 
                loopNode.next = nextNode;
            } else {
                //相连结点不重复了,check一下上一对相连的结点是否重复
                //如果重复了,那么loopNode也需要丢弃
                //比如 A->B(loopNode)->C(nextNode),check一下A和B是否重复(isDuplicate变量标识)
                //如果isDuplicate为true,那么B也要删除
                if(isDuplicate) {
                    //loopNode从nextNode开始
                    loopNode = nextNode;
                    //如果beforeNode不为NULL,那么调整beforeNode的next,将B删除
                    if(null != beforeNode) {
                        beforeNode.next = loopNode;
                    }
                    //调整nextNode
                    nextNode = nextNode.next;
                } else {
                    //前面相连的两个结点不重复,现在两个相连的结点不重复
                    //A->B->C这三个结点都不重复
                    if(null != beforeNode) {
                        //将beforeNode和loopNode连接
                        beforeNode.next = loopNode;
                        //重新调整beforeNode
                        beforeNode = loopNode;
                    } else {
                        //beforeNode第一次非null,调整head结点
                        beforeNode = loopNode;
                        head = beforeNode;
                    }
                    
                    //重新调整loopNode和nextNode
                    loopNode = nextNode;
                    nextNode = nextNode.next;
                }
                
                isDuplicate = false;
            }
        }
        
        //退出循环以后,如果isDuplicate为true,那么最后一个loopNode也需要删除
        if(isDuplicate && null != beforeNode) {
            beforeNode.next = null;
        }
        
        if(null == beforeNode) {
            return null;
        } else {
            return head;
        }
    }
    

}
