package com.pointoffer.no31to40;

import com.lintcode.common.TreeNode;

/**
 * 
 * 平衡二叉树
 * 
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 定义：
 * 平衡二叉树就是左子树和右子树的高度差不能超过1
 * 且左右子树必须是平衡二叉树；
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 上午11:36:03
 */
public class Pnum0039 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        
        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn4.right = tn5;
        
        
        Pnum0039 pnum0039_ = new Pnum0039();
        System.out.println(pnum0039_.IsBalanced_Solution(tn1));
    }
    
    public boolean IsBalanced_Solution(TreeNode root) {
        if(null == root) {
            return true;
        }
        
        return isBalance(root);
    }
    
    public boolean isBalance(TreeNode node) {
        if(null == node) {
            return true;
        }
        
        TreeNode leftChild = node.left;
        TreeNode rightChild = node.right;
        
        int leftDepth = null==leftChild ? 0 : depth(leftChild);
        int rightDepth = null==rightChild ? 0 : depth(rightChild);
        
        if(Math.abs(leftDepth-rightDepth) > 1) {
            return false;
        }
        
        return isBalance(leftChild) && isBalance(rightChild);
    }
    
    /**
     * 
     * @param node
     * @return
     */
    public int depth(TreeNode node) {
        TreeNode leftChild = node.left;
        TreeNode rightChild = node.right;
        if(null!=leftChild && null!=rightChild) {
            return Math.max(depth(leftChild), depth(rightChild)) + 1;
        } else if(null!=leftChild) {
            return depth(leftChild) + 1;
        } else if(null!=rightChild) {
            return depth(rightChild) + 1;
        } else {
            return 0;
        }
    }
}
