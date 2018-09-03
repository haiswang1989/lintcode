package com.lintcode.t201808;

import com.lintcode.common.TreeNode;

/**
 * 二叉树的最大深度
 * 
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的距离。
 * 
 * 给出一棵如下的二叉树:
 *      1
 *     / \ 
 *    2   3
 *       / \
 *      4   5
 * 
 * 这个二叉树的最大深度为3
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月30日 上午11:42:08
 */
public class Pnum0097 {

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
        
        Pnum0097 pnum0097 = new Pnum0097();
        System.out.println(pnum0097.maxDepth(tn2));
    }
    
    /**
     * 
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        return maxDepthWithRecursion(root, 0);
    }
    
    /**
     * 
     * @param root
     * @return
     */
    public int maxDepthWithRecursion(TreeNode node, int currLevel) {
        if(null == node) {
            return currLevel;
        }
        
        TreeNode leftChildNode = node.left;
        TreeNode rightChildNode = node.right;
        
        ++currLevel;
        int leftChildLevel = maxDepthWithRecursion(leftChildNode, currLevel);
        int rightChildLevel = maxDepthWithRecursion(rightChildNode, currLevel);
        return  leftChildLevel >= rightChildLevel ? leftChildLevel : rightChildLevel;
    }

}
