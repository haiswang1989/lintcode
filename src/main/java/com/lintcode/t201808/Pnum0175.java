package com.lintcode.t201808;

import java.util.LinkedList;

import com.lintcode.common.TreeNode;

/**
 * 
 * 翻转一棵二叉树
 * 
 *   1         1
 *  / \       / \
 * 2   3  => 3   2
 *    /       \
 *   4         4
 *   
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月31日 上午9:36:05
 */
public class Pnum0175 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        
        tn1.left = tn2;
        tn1.right = tn3;
        tn3.left = tn4;
        
        Pnum0175 pnum0175 = new Pnum0175();
        pnum0175.invertBinaryTree(tn1);
        
        System.out.println("-----------");
    }
    
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        //invertBinaryTreeByRecursion(root);
        withOutRecursion(root);
    }
    
    /**
     * 递归的方式实现
     * @param node
     */
    public void invertBinaryTreeByRecursion(TreeNode node) {
        if(null==node) {
            return;
        }
        
        TreeNode leftChild = node.left;
        TreeNode rightChild = node.right;
        
        node.left = rightChild;
        node.right=leftChild;
        
        invertBinaryTreeByRecursion(leftChild);
        invertBinaryTreeByRecursion(rightChild);
    }
    
    /**
     * 非递归的方式实现
     * @param node
     */
    public void withOutRecursion(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode loopNode = node;
        
        while(null!=loopNode || 0!=queue.size()) {
            if(null==loopNode) {
                loopNode = queue.poll();
            }
            
            TreeNode leftChild = loopNode.left;
            TreeNode rightChild = loopNode.right;
            
            loopNode.left = rightChild;
            loopNode.right = leftChild;
            if(null!=loopNode.right) {
                queue.add(loopNode.right);
            }
            loopNode = loopNode.left;
        }
    }
}
