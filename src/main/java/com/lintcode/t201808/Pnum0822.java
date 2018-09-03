package com.lintcode.t201808;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.lintcode.common.ListNode;

/**
 * 相反的顺序存储
 * 
 * 给出一个链表，并将链表的值以in reverse order存储到数组中。
 * 
 * 您不能change原始链表的结构
 * 
 * 给定1 -> 2 -> 3 -> null，返回[3,2,1]。
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月10日 下午4:46:26
 */
public class Pnum0822 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        
        ln1.next = ln2;
        ln2.next = ln3;
        
        Pnum0822 pnum0822 = new Pnum0822();
        List<Integer> re = pnum0822.reverseStore(ln1);
        System.out.println(re);
    }
    
    /**
     * 借助stack来实现
     * @param head: the given linked list
     * @return: the array that store the values in reverse order 
     */
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        ListNode loopNode = head;
        
        Stack<Integer> stack = new Stack<>();
        while(null!=loopNode) {
            stack.add(loopNode.val);
            loopNode = loopNode.next;
        }
        
        List<Integer> re = new ArrayList<>();
        while(stack.size()!=0) {
            re.add(stack.pop());
        }
        
        return re;
    }
    
    /**
     * 先反转,在存储,再反转
     * @param head: the given linked list
     * @return: the array that store the values in reverse order 
     */
    /*
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        List<Integer> ret = new ArrayList<>();
        
        ListNode reversedListHead = reverseList(head);
        ListNode loopNode = reversedListHead;
        
        while(null!=loopNode) {
            ret.add(loopNode.val);
            loopNode = loopNode.next;
        }
        
        reverseList(reversedListHead);
        return ret;
    }
    */
    
    /**
     * 反转链表
     * @param head
     * @return
     */
    /*
    public ListNode reverseList(ListNode head) {
        if(null == head || null==head.next) {
            return head;
        }
        
        ListNode beforeLoopNode = null;
        ListNode loopNode = head;
        ListNode loopNodeNext = head.next;
        while(null!=loopNodeNext) {
            loopNode.next = beforeLoopNode;
            beforeLoopNode = loopNode;
            loopNode = loopNodeNext;
            loopNodeNext = loopNodeNext.next;
        }
        
        loopNode.next = beforeLoopNode;
        return loopNode;
    }
    */ 
}
