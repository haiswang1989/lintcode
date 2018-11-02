package com.pointoffer.no1to10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import com.lintcode.common.ListNode;

/**
 * 从头到尾打印链表
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：690865
 * 
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月18日 上午11:13:11
 */
public class Pnum0003 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        
        Pnum0003 Pnum0003 = new Pnum0003();
        ArrayList<Integer> al = Pnum0003.printListFromTailToHead(ln1);
        System.out.println(Arrays.toString(al.toArray()));
    }
    
    /**
     * 借助栈先进后出的特性
     * 
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(null == listNode) {
            return new ArrayList<>();
        }
        
        Stack<Integer> stack = new Stack<>();
        while(null!=listNode) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        
        ArrayList<Integer> alRet = new ArrayList<>();
        while (0!=stack.size()) {
            alRet.add(stack.pop());
        }
        
        return alRet;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /**
     * 大致思路就是反转链表,然后再遍历链表
     * 
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        if(null == listNode) {
            return new ArrayList<>();
        }
        
        ListNode beforeNode = null;
        ListNode currNode = listNode;
        ListNode nextNode = currNode.next;
        
        while(null!=currNode && nextNode != null) {
            ListNode nextNextTemp = nextNode.next;
            currNode.next = beforeNode;
            nextNode.next = currNode;
            beforeNode = currNode;
            currNode = nextNode;
            nextNode = nextNextTemp;
        }
        
        ArrayList<Integer> alRet = new ArrayList<>();
        while (null!=currNode) {
            alRet.add(currNode.val);
            currNode = currNode.next;
        }
        
        return alRet;
    }
    
}
