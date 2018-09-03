package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 链表插入排序
 * 
 * Given 1->3->2->0->null, return 0->1->2->3->null
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月7日 上午11:22:31
 */
public class Pnum0173 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln1 = new ListNode(1);
        ListNode ln3 = new ListNode(3);
        ListNode ln2 = new ListNode(2);
        ListNode ln0 = new ListNode(0);
        
        ln1.next = ln3;
        ln3.next = ln2;
        ln2.next = ln0;
        
        ln1.print();
        
        Pnum0173 pnum0173 = new Pnum0173();
        ListNode newRe = pnum0173.insertionSortList(ln1);
        newRe.print();
        
    }
    
    /**
     * 
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if(null == head || null == head.next) {
            return head;
        }
        
        //返回的List的头结点
        ListNode newListHead = null;
        //老List的遍历结点
        ListNode oldListLoop = head;
        while(null!=oldListLoop) {
            //新List的遍历结点
            ListNode newListLoop = newListHead;
            //新List的遍历结点的前置结点,这两个结点是用来在中间插入元素的
            ListNode newListLoopBefore = null;
            //新list的第一个结点
            if(null == newListHead) {
                newListHead = oldListLoop;
                oldListLoop = oldListLoop.next;
                newListHead.next = null;
            } else {
                //将旧List中的结点插入到新的List中
                while(null != newListLoop) {
                    if(newListLoop.val < oldListLoop.val) {
                        //还没有找到合适的位置,继续遍历新List
                        newListLoopBefore = newListLoop;
                        newListLoop = newListLoop.next;
                    } else {
                        ListNode oldListLoopNext = oldListLoop.next;
                        if(null == newListLoopBefore) {
                            //老List中元素最小,放到最前面,注意这边需要调整返回的新的List的Head
                            oldListLoop.next = newListLoop;
                            newListHead = oldListLoop;
                        } else {
                            //放到中间
                            newListLoopBefore.next = oldListLoop;
                            oldListLoop.next = newListLoop;
                        }
                        
                        oldListLoop = oldListLoopNext;
                        break;
                    }
                }
                
                //老List中的结点最大,直接放到结尾
                if(null == newListLoop) {
                    ListNode oldListLoopNext = oldListLoop.next;
                    newListLoopBefore.next = oldListLoop;
                    oldListLoop.next = null;
                    oldListLoop = oldListLoopNext;
                }
            }
        }
        
        return newListHead;
    }
}
