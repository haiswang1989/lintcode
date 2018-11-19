package com.pointoffer.no51to60;

import com.lintcode.common.ListNode;

/**
 * 删除链表中重复的结点
 * 
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月5日 上午10:07:41
 */
public class Pnum0056 {

    public static void main(String[] args) {
        
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln3_1 = new ListNode(3);
        ListNode ln3_2 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln4_1 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln3_1;
        ln3_1.next = ln3_2;
        ln3_2.next = ln4;
        ln4.next = ln4_1;
        ln4_1.next = ln5;
        
        Pnum0056 pnum0056 = new Pnum0056();
        ListNode newHead = pnum0056.deleteDuplication(ln1);
        System.out.println(newHead);
    }
    
    /**
     * 这题我没有做出来
     * 技巧一：
     * 头结点可能就是重复的需要删除,所以创建一个不存在的头结点,next结点就是链表的头结点,这样返回的结点就是不存在结点的next结点
     * 
     * 技巧二：
     * 在遇到重复结点以后,内部一个一个的遍历直到找到不重复的结点,统一删除
     * 
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if(null==pHead) {
            return pHead;
        }
        
        //构建一个不存在的结点
        //避免头结点是重复结点不停调整Head的尴尬
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode beforeNode = newHead;
        ListNode loopNode = pHead;
        
        while(null!=loopNode && null!=loopNode.next) {
            if(loopNode.val == loopNode.next.val) {
                //遇到重复结点以后,不停的遍历,直到遍历到不相等的结点
                //可能存在2个以上的重复
                int val = loopNode.val;
                while(null!=loopNode && val==loopNode.val) {
                    loopNode = loopNode.next;
                }
                
                beforeNode.next = loopNode;
            } else {
                beforeNode = loopNode;
                loopNode = loopNode.next;
            }
        }
        
        return newHead.next;
    }
}
