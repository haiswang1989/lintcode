package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 给一个来自已经排过序的循环链表的节点，写一个函数来将一个值插入到循环链表中，并且保持还是有序循环链表。给出的节点可以是链表中的任意一个单节点。返回插入后的新链表。
 * 
 * 3->5->1 是一个循环链表，所以 3 是 1 的下一个节点。3->5->1 与 5->1->3 相同
 * 
 * 给一个链表：3->5->1
 * 插入值 4
 * 返回 5->1->3->4
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月10日 上午10:57:28
 */
public class Pnum0599 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln3 = new ListNode(3);
        ListNode ln5 = new ListNode(5);
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        
        ln3.next = ln5;
        ln5.next = ln1;
        ln1.next = ln2;
        ln2.next = ln3;
        
        Pnum0599 pnum0599 = new Pnum0599();
        pnum0599.insert(ln3, 7);
        
        System.out.println(ln1);
    }
    
    /**
     * 
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here
        ListNode newNode = new ListNode(x);
        //List为null,注意必须有环
        if(null == node) {
            newNode.next = newNode;
            return newNode;
        }
        
        //List是单个结点
        if(node.next == node) {
            node.next = newNode;
            newNode.next = node;
            return node;
        }
        
        //比较结点,用于判定链表已经遍历了一圈
        ListNode compareNode = node;
        //遍历结点的前置结点
        ListNode beforeLoopNode = node;
        //遍历结点
        ListNode loopNode = node.next;
        //是否已经插入
        boolean hasInsert = false;
        
        //环的交界处,可能找不到交界处(链表的所有元素都是相等的)
        ListNode cyclePointNodeBefore = beforeLoopNode;
        ListNode cyclePointNode = loopNode;
        
        while(compareNode != loopNode) {
            //如果compareNode和loopNode相等的时候,就表示遍历了一圈了
            //当前置结点的值比遍历结点的值大的时候,表示到了交界处,记录下这个位置
            //当x是最大元素或者最小元素的时候,就需要插在这边
            if(beforeLoopNode.val > loopNode.val) {
                cyclePointNodeBefore = beforeLoopNode;
                cyclePointNode = loopNode;
            } else {
                //找到了插入位置
                if(beforeLoopNode.val <= x && loopNode.val >= x) {
                    beforeLoopNode.next = newNode;
                    newNode.next = loopNode;
                    hasInsert = true;
                    break;
                } 
            }
            
            //没找到插入位置继续往下插入
            beforeLoopNode = loopNode;
            loopNode = loopNode.next;
        }
        
        if(!hasInsert) {
            cyclePointNodeBefore.next = newNode;
            newNode.next = cyclePointNode;
        }
        
        return node;
    }
}