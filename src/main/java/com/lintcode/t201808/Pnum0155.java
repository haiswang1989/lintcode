package com.lintcode.t201808;

import com.lintcode.common.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度
 * 
 * 二叉树的最小深度为根节点到最近叶子节点的距离
 * 
 * 给出一棵如下的二叉树
 * 
 *      1
 *   /     \ 
 *  2       3
 *        /    \
 *       4      5  
 * 这个二叉树的最小深度为 2
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月30日 下午2:35:27
 */
public class Pnum0155 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        
        tn2.left = tn1;
        tn2.right = tn4;
        
        tn4.left = tn3;
        tn4.right = tn5;
        
        
//        tn1.left = tn2;
//        tn2.left = tn3;
        
        Pnum0155 pnum0155 = new Pnum0155();
        System.out.println(pnum0155.minDepth(tn2));
        
        
        
    }
    
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        
        return minDepthWithRecursion(root, 1);
    }
    
    public int minDepthWithRecursion(TreeNode node, int currLevel) {
        TreeNode leftChildNode = node.left;
        TreeNode rightChildNode = node.right;
        
        if(null == leftChildNode && null == rightChildNode) {
            //左右结点同时为NULL的时候,找到了叶子结点,即最短路径找到了
            return currLevel;
        } else if(null == leftChildNode) {
            //如果左孩子为NULL,那么就计算右孩子
            return minDepthWithRecursion(rightChildNode, currLevel + 1);
        } else if(null == rightChildNode) {
            //如果右孩子为NULL,那么就计算左孩子
            return minDepthWithRecursion(leftChildNode, currLevel + 1);
        } else {
            //都不为NULL,两个孩子都计算,取小的
            int leftChildLevel = minDepthWithRecursion(leftChildNode, currLevel + 1);
            int rightChildLevel = minDepthWithRecursion(rightChildNode, currLevel + 1);
            return  leftChildLevel <= rightChildLevel ? leftChildLevel : rightChildLevel;
        }
    }
}
