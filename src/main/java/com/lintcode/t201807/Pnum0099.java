package com.lintcode.t201807;

import com.lintcode.common.ListNode;

/**
 * 重排链表
 * 
 * 给定一个单链表L: L0→L1→…→Ln-1→Ln,
 * 重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 必须在不改变节点值的情况下进行原地操作。
 * 
 * 给出链表 1->2->3->4->null，重新排列后为1->4->2->3->null。
 * 
 * Can you do this in-place without altering the nodes' values?
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月19日 上午10:29:03
 */
public class Pnum0099 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(6);
        
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        
        Pnum0099 pnum0099 = new Pnum0099();
        pnum0099.reorderList(ln1);
        
        System.out.println("---");
    }
    
    /**
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        // write your code here
        if(null == head || null == head.next) {
            return;
        }
        
        //快慢指针找到中间结点
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(null!=fast && null!=fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode middle = slow;
        
        //从中间断开链表
        ListNode latterHalfList = middle.next;
        middle.next = null;
        
        //将后半段链表反转
        ListNode afterReversalList = reversalList(latterHalfList);
        
        ListNode list1Loop = head;
        ListNode list2Loop = afterReversalList;
        
        
        while(null != list1Loop && null != list2Loop) {
            ListNode list1Next = list1Loop.next;
            ListNode list2Next = list2Loop.next;
            
            list1Loop.next = list2Loop;
            list2Loop.next = list1Next;
            
            list1Loop = list1Next;
            list2Loop = list2Next;
        }
    }
    
    /**
     * 
     * @param list
     * @return
     */
    public ListNode reversalList(ListNode list) {
        if(null == list || null == list.next) {
            return list;
        }
        
        ListNode beforeNode = null;
        ListNode loopNode = list;
        ListNode nextNode = list.next;
        
        while(null!=nextNode) {
            loopNode.next = beforeNode;
            beforeNode = loopNode;
            loopNode = nextNode;
            nextNode = nextNode.next;
        }
        
        loopNode.next = beforeNode;
        return loopNode;
    }

}

