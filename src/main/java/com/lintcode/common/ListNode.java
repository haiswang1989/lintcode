package com.lintcode.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
    
    public void print() {
        ListNode loopNode = this;
        while(null != loopNode) {
            System.out.print(loopNode.val + ",");
            loopNode = loopNode.next;
        }
        
        System.out.println();
    }
    
    @Override
    public String toString() {
        return val + "";
    }
}
