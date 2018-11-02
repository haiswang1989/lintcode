package com.lintcode.t201809;

import com.lintcode.common.TreeNode;

/**
 * 二叉查找树的中序后继
 * 
 * 给定一个二叉查找树(什么是二叉查找树)，以及一个节点，求该节点在中序遍历的后继，如果没有返回null
 * 
 * 给出 tree = [2,1] node = 1
 *      2
 *    /
 *   1
 * 返回 node 2
 * 
 * 给出 tree = [2,1,3] node = 2
 *      2
 *    /   \
 *   1     3
 * 返回 node 3
 * 
 * 挑战
 * O(h)，其中h是BST的高度
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年9月29日 上午10:17:36
 */
public class Pnum0448 {
    
    public static void main(String[] args) {
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        
        
        tn3.left = tn1;
        tn3.right = tn4;
        tn1.right = tn2;
        Pnum0448 pnum0448 = new Pnum0448();
        TreeNode retNode = pnum0448.inorderSuccessor(tn3, tn2);
        System.out.println(retNode.val);
    }
    
    /**
     * 1:是left结点,且为叶子结点,那么返回该结点的parent结点
     * 2:
     * 
     * 
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(null == root || null == p) {
            return null;
        }
        
        
        
        return null;
    }
}
