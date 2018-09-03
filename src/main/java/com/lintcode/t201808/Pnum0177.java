package com.lintcode.t201808;

import com.lintcode.common.TreeNode;

/**
 * 把排序数组转换为高度最小的二叉搜索树
 * 
 * 给一个排序数组（从小到大），将其转换为一棵高度最小的排序二叉树
 * 
 * 给出数组 [1,2,3,4,5,6,7], 返回
 * 
 *      4
 *    /    \
 *   2      6
 *  / \    / \
 * 1   3  5   7
 * 
 * 可能有多个答案，返回任意一个即可
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月31日 上午10:33:16
 */
public class Pnum0177 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] sortedArray = {1,2,3,4};
        Pnum0177 pnum0177 = new Pnum0177();
        TreeNode head = pnum0177.sortedArrayToBST(sortedArray);
        System.out.println("-----------------" + head);
    }
    
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if(null == A || 0 == A.length) {
            return null;
        }
        
        return sortArrayToBSTByRecursion(A, 0, A.length-1);
    }
    
    /**
     * 
     * @param A
     * @param fromIndex
     * @param endIndex
     * @return
     */
    public TreeNode sortArrayToBSTByRecursion(int[] A, int fromIndex, int endIndex) {
        int elementCnt = endIndex - fromIndex + 1;
        if(1 == elementCnt) {
            return new TreeNode(A[fromIndex]);
        } else if(2 == elementCnt) {
            TreeNode childTreeHead = new TreeNode(A[endIndex]);
            TreeNode childTreeLeftChild = new TreeNode(A[fromIndex]);
            childTreeHead.left = childTreeLeftChild;
            return childTreeHead;
        } else if(3 == elementCnt) {
            TreeNode childTreeHead = new TreeNode(A[(fromIndex+endIndex)/2]);
            TreeNode childTreeLeftChild = new TreeNode(A[fromIndex]);
            TreeNode childTreeRightChild = new TreeNode(A[endIndex]);
            childTreeHead.left = childTreeLeftChild;
            childTreeHead.right = childTreeRightChild;
            return childTreeHead;
        } else {
            int middleIndex = (endIndex + fromIndex) / 2;
            TreeNode childTreeHead = new TreeNode(A[middleIndex]);
            TreeNode childTreeLeftChild = sortArrayToBSTByRecursion(A, fromIndex, middleIndex-1);
            TreeNode childTreeRightChild = sortArrayToBSTByRecursion(A, middleIndex+1, endIndex);
            childTreeHead.left = childTreeLeftChild;
            childTreeHead.right = childTreeRightChild;
            return childTreeHead;
        }
    }
}
