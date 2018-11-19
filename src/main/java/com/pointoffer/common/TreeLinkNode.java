package com.pointoffer.common;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode next = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }
    
    @Override
    public String toString() {
        return val + "";
    }
}
