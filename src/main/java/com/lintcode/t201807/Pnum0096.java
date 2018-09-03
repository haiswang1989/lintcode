package com.lintcode.t201807;

import com.lintcode.common.ListNode;

/**
 * 链表划分
 * 
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
 * 你应该保留两部分内链表节点原有的相对顺序。
 * 
 * 给定链表 1->4->3->2->5->2->null，并且 x=3
 * 返回 1->2->2->4->3->5->null
 * 
 * 思路,找到第一个大于等于X的结点,然后把这个结点的以后任何小鱼X的结点都放到这个结点的前面
 * 需要注意的是如果找到的这个结点是第一个结点的时候,需要更新,返回的头结点不是head
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月19日 上午11:35:03
 */
public class Pnum0096 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln1 = new ListNode(1);
        ListNode ln2_1 = new ListNode(2);
        ListNode ln2_2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        
        ln1.next = ln4;
        ln4.next = ln3;
        ln3.next = ln2_1;
        ln2_1.next = ln5;
        ln5.next = ln2_2;
        
        
        ln1.print();
        Pnum0096 pnum0096 = new Pnum0096();
        ListNode newHead = pnum0096.partition(ln1, 3);
        newHead.print();
    }
    
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(null == head || null == head.next) {
            return head;
        }
        
        //第一个大于等于X的结点和该结点的前置结点
        ListNode moreNode = null;
        ListNode moreNodeBefore = null;
        
        //遍历结点和遍历结点的前置结点
        ListNode loopNode = head;
        ListNode loopNodeBefore = null;
        
        //返回的链表的头结点
        ListNode retHead = head;
        
        //moreNode是否已经找到
        boolean findMoreNode = false;
        
        while(null!=loopNode) {
            if(loopNode.val >= x) {
                //moreNode找到了就不要更换了,就找第一个好了
                if(!findMoreNode) { 
                    findMoreNode = true;
                    //更新找到的第一个大于X的结点,以该结点为界限,用于移动小的结点
                    moreNode = loopNode;
                    moreNodeBefore = loopNodeBefore;
                }
                
                //更新当前遍历结点和当前遍历结点的前一个结点
                loopNodeBefore = loopNode;
                loopNode = loopNode.next;
            } else {
                if(null == moreNode) {
                    //更新当前遍历结点和当前遍历结点的前一个结点
                    loopNodeBefore = loopNode;
                    loopNode = loopNode.next;
                } else {
                    ListNode loopNodeNext = loopNode.next;
                    //将loopNode直接删除
                    //A(loopNodeBefore)->B(loopNode)->C(loopNodeNext)
                    //A(loopNodeBefore)->C(loopNodeNext)
                    //注意删除结点,loopNodeBefore结点不会变化
                    loopNodeBefore.next = loopNodeNext;

                    if(null != moreNodeBefore) {
                        moreNodeBefore.next = loopNode;
                        loopNode.next = moreNode;
                        //调整moreNode的前结点
                        moreNodeBefore = loopNode;
                    } else {
                        loopNode.next = moreNode;
                        //设置moreNode的钱结点
                        moreNodeBefore = loopNode;
                        //设置调整后的链表的头结点
                        retHead = loopNode;
                    }
                    
                    //更新当前遍历结点
                    loopNode = loopNodeNext;
                }
            }
        }
        
        return retHead;
    }
}
