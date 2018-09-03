package com.lintcode.t201807;

import java.util.ArrayList;
import java.util.List;

import com.lintcode.common.TreeNode;

/**
 * Search Range in Binary Search Tree
 * 
 * 给定一个二叉搜索树以及一个范围,找出二叉搜索树中在这个范围内的元素
 * 
 * 如果有 k1 = 10 和 k2 = 22, 你的程序应该返回 [12, 20, 22].
 *          20
 *      8       22
 *    4  12
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月4日 上午11:42:06
 */
public class Pnum0011 {

    public static void main(String[] args) {
        
        TreeNode tn20 = new TreeNode(20);
        TreeNode tn8 = new TreeNode(8);
        TreeNode tn22 = new TreeNode(22);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn12 = new TreeNode(12);
        
        tn20.left = tn8;
        tn20.right = tn22;
        
        tn8.left = tn4;
        tn8.right = tn12;
        
        Pnum0011 pnum11 = new Pnum0011();
        List<Integer> retList = pnum11.searchRange(tn20, 10, 22);
        System.out.println(retList.toString());
    }

    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> retList = new ArrayList<>();
        if(null != root) {
            searchRangeByRecursion(root, k1, k2, retList);
        }
        
        return retList;
    }
    
    /**
     * 
     * @param node
     * @param k1
     * @param k2
     * @param retList
     */
    public void searchRangeByRecursion(TreeNode node, int k1, int k2, List<Integer> retList) {
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        
        boolean needSearchLeftChild = false;
        boolean needSearchRightChild = false;
        
        if(node.val >= k1 && node.val <= k2) {
            needSearchLeftChild = true;
            needSearchRightChild = true;
        } else if(node.val < k1) {
            needSearchRightChild = true;
        } else if(node.val > k2) {
            needSearchLeftChild = true;
        }
        
        if(needSearchLeftChild && null != leftNode) {
            searchRangeByRecursion(leftNode, k1, k2, retList);
        }
        
        if(needSearchLeftChild && needSearchRightChild) {
            retList.add(node.val);
        }
        
        if(needSearchRightChild && null != rightNode) {
            searchRangeByRecursion(rightNode, k1, k2, retList);
        }
    }
}
