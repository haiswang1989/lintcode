package com.lintcode.t201808;

import java.util.Stack;

import com.lintcode.common.ListNode;

/**
 * 加一链表
 * 
 * 给定一个非负整数，这个整数表示为一个非空的单链表，每个节点表示这个整数的一位。返回这个整数加一。
 * 除了0本身，所有数字在最高位前都没有0。
 * 列表的头节点存的是这个整数的最高位。
 * 
 * 给出链表1 -> 2 -> 3 -> null，返回 1 -> 2 -> 4 -> null。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月10日 下午5:08:39
 */
public class Pnum0904 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln1 = new ListNode(9);
        ListNode ln2 = new ListNode(9);
        ListNode ln3 = new ListNode(9);
        
        ln1.next = ln2;
        ln2.next = ln3;
        
        Pnum0904 pnum0904 = new Pnum0904();
        ListNode re = pnum0904.plusOne(ln1);
        re.print();
    }
    
    /**
     * @param head: the first Node
     * @return: the answer after plus one
     */
    public ListNode plusOne(ListNode head) {
        // Write your code here
        Stack<Integer> stackOne = new Stack<>();
        ListNode loopNode = head;
        while(null!=loopNode) {
            stackOne.push(loopNode.val);
            loopNode = loopNode.next;
        }
        
        Stack<Integer> stackTwo = new Stack<>();
        boolean hasCarry = false;
        boolean firstEle = true;
        while(!stackOne.isEmpty()) {
            int value = stackOne.pop();
            if(firstEle) {
                ++value; 
                firstEle = false;
            } else {
                if(hasCarry) {
                    ++value;
                }
            }
            
            if(value >= 10) {
                hasCarry = true;
                value %= 10; 
            } else {
                hasCarry = false;
            }
            
            stackTwo.push(value);
        }
        
        if(hasCarry) {
            stackTwo.push(1);
        }
        
        ListNode newListHead = null;
        ListNode newListLoop = null;
        while(!stackTwo.isEmpty()) {
            ListNode node = new ListNode(stackTwo.pop());
            if(null == newListHead) {
                newListLoop = node;
                newListHead = node;
            } else {
                newListLoop.next = node;
                newListLoop = node;
            }
        }
        
        return newListHead;
        
    }

}
