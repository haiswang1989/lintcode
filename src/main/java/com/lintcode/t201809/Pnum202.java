package com.lintcode.t201809;

import com.lintcode.common.SegmentTreeNode;

/**
 * 线段树的查询
 * 
 * 对于一个有n个数的整数数组，在对应的线段树中, 根节点所代表的区间为索引0到n-1, 每个节点有一个额外的属性max，值为该节点所代表的数组区间start到end内的最大值。
 * 
 * 为SegmentTree设计一个 query 的方法，接受3个参数root, start和end，线段树root所代表的数组中子区间[start, end]内的最大值
 * 
 * 对于数组 [1, 4, 2, 3], 对应的线段树为：
 * 
 *                [0, 3, max=4]
 *               /             \
 *       [0,1,max=4]        [2,3,max=3]
 *       /         \        /         \
 * [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
 * 
 * query(root, 1, 1), return 4
 * query(root, 1, 2), return 4
 * query(root, 2, 3), return 3
 * query(root, 0, 2), return 4
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年9月3日 上午9:38:25
 */
public class Pnum202 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        SegmentTreeNode stn1 = new SegmentTreeNode(0, 3, 4);
        SegmentTreeNode stn2 = new SegmentTreeNode(0, 1, 4);
        SegmentTreeNode stn3 = new SegmentTreeNode(2, 3, 3);
        SegmentTreeNode stn4 = new SegmentTreeNode(0, 0, 1);
        SegmentTreeNode stn5 = new SegmentTreeNode(1, 1, 4);
        SegmentTreeNode stn6 = new SegmentTreeNode(2, 2, 2);
        SegmentTreeNode stn7 = new SegmentTreeNode(3, 3, 3);
        
        stn1.left = stn2;
        stn1.right = stn3;
        
        stn2.left = stn4;
        stn2.right = stn5;
        
        stn3.left = stn6;
        stn3.right = stn7;
        
    }
    
    /**
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        return queryByRecursion(root, start, end);
    }
    
    /**
     * 
     * @param node
     * @param start
     * @param end
     * @return
     */
    public int queryByRecursion(SegmentTreeNode node, int start, int end) {
        int nodeStart = node.start;
        int nodeEnd = node.end;
        if(nodeStart == start) {
            if(nodeEnd == end) {
                return node.max;
            } else if(nodeEnd < end) {
                //NOT REACH?
                return -1;
            } else {
                //nodeEnd > end
                SegmentTreeNode leftChildNode = node.left;
                SegmentTreeNode rightChildNode = node.right;
                if(end <= leftChildNode.end) {
                    return queryByRecursion(leftChildNode, start, end);
                } else {
                    return Math.max(leftChildNode.max, queryByRecursion(rightChildNode, rightChildNode.start, end));
                }
            }
        } else if(nodeStart < start) {
            //NOT REACH?
            return -1;
        } else { 
            //nodeStart > start
            SegmentTreeNode leftChildNode = node.left;
            SegmentTreeNode rightChildNode = node.right;
            if(leftChildNode.end>=start) {
                if(leftChildNode.end >= end) {
                    return queryByRecursion(leftChildNode, start, end);
                } else {
                    return Math.max(queryByRecursion(leftChildNode, start, leftChildNode.end), 
                            queryByRecursion(rightChildNode, rightChildNode.start, end));
                }
            } else {
                return queryByRecursion(rightChildNode, start, end);
            }
        }
    }
}
