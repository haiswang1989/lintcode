package com.pointoffer.no11to20;

import com.lintcode.common.TreeNode;

/**
 * 二叉树的镜像
 * 
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：192187
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月30日 上午11:03:39
 */
public class Pnum0018 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public void Mirror(TreeNode root) {
        if(null == root) {
            return;
        }
        
        mirrorWithRecursion(root);
    }
    
    /**
     * 
     * @param node
     */
    public void mirrorWithRecursion(TreeNode node) {
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        
        if(null!=leftNode) {
            mirrorWithRecursion(leftNode);
        }
        
        if(null!=rightNode) {
            mirrorWithRecursion(rightNode);
        }
        
        node.left = rightNode;
        node.right = leftNode;
    }
}
