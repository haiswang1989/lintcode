package com.pointoffer.no31to40;

import com.lintcode.common.TreeNode;

/**
 * 二叉树的深度
 * 
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 上午10:59:37
 */
public class Pnum0038 {

    public static void main(String[] args) {
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        
        tn1.left = tn2;
        tn2.left = tn3;
        tn3.left = tn4;
                
        
        Pnum0038 pnum0038_ = new Pnum0038();
        System.out.println(pnum0038_.TreeDepth(tn1));
    }
    
    public int TreeDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        
        return withRecursion(root) + 1;
    }
    
    public int withRecursion(TreeNode node) {
        TreeNode leftChildNode = node.left;
        TreeNode rightChildNode = node.right;
        
        if(null!=leftChildNode && null!=rightChildNode) {
            return Math.max(withRecursion(rightChildNode), withRecursion(leftChildNode)) + 1;
        } else if(null!=leftChildNode) {
            return withRecursion(leftChildNode) + 1;
        } else if(null!=rightChildNode) {
            return withRecursion(rightChildNode) + 1;
        } else {
            return 0;
        }
    }
}
