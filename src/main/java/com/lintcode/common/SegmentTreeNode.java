package com.lintcode.common;

/**
 * 线段树
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月31日 上午10:56:53
 */
public class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this(start, end, 0);
    }
    
    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }
}
