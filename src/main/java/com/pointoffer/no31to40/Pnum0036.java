package com.pointoffer.no31to40;

import java.util.Stack;

import com.lintcode.common.ListNode;

/**
 * 两个链表的第一个公共结点
 * 
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 上午10:13:41
 */
public class Pnum0036 {

    public static void main(String[] args) {
        
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln6 = new ListNode(6);
        ListNode ln7 = new ListNode(7);
        
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln6;
        ln6.next = ln7;
        
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ListNode ln6_1 = new ListNode(6);
        ListNode ln7_1 = new ListNode(7);
        ln4.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6_1;
        ln6_1.next = ln7_1;
        
        Pnum0036 pnum0035 = new Pnum0036();
        ListNode re = pnum0035.FindFirstCommonNode(ln1, ln4);
        System.out.println(re.val);
    }
    
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(null==pHead1 || null==pHead2) {
            return null;
        }
        
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        
        ListNode pHead1LoopNode = pHead1;
        while(null!=pHead1LoopNode) {
            stack1.push(pHead1LoopNode);
            pHead1LoopNode = pHead1LoopNode.next;
        }
        
        ListNode pHead2LoopNode = pHead2;
        while(null!=pHead2LoopNode) {
            stack2.push(pHead2LoopNode);
            pHead2LoopNode = pHead2LoopNode.next;
        }
        
        ListNode firstPublicListNode = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.peek().val == stack2.pop().val) {
                firstPublicListNode = stack1.pop();
            } else {
                return firstPublicListNode;
            }
        }
        
        return firstPublicListNode;
    }
    
    ////////////////////////////////////如下的方式是采用先"反转"再比较的方式//////////////////////////////////////////
    public ListNode FindFirstCommonNode_1(ListNode pHead1, ListNode pHead2) {
        if(null==pHead1 || null==pHead2) {
            return null;
        }
        
        ListNode newPHead1 = reserve(pHead1);
        ListNode newPHead2 = reserve(pHead2);
        
        ListNode newP1LoopNode = newPHead1;
        ListNode newP2LoopNode = newPHead2;
        
        ListNode firstPublicListNode = null;
        while(null!=newP1LoopNode && null!=newP2LoopNode) {
            if(newP1LoopNode.val != newP2LoopNode.val) {
                return firstPublicListNode;
            } else {
                firstPublicListNode = newP1LoopNode;
                newP1LoopNode = newP1LoopNode.next;
                newP2LoopNode = newP2LoopNode.next;
            }
        }
        
        return firstPublicListNode;
    }
    
    
    public ListNode reserve(ListNode node) {
        ListNode beforeNode = null;
        ListNode loopNode = node;
        ListNode nextNode = null;
        while(null!=loopNode) {
            nextNode = loopNode.next;
            loopNode.next = beforeNode;
            beforeNode = loopNode;
            loopNode = nextNode;
        }
        
        return beforeNode;
    }
}
