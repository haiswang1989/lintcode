package com.pointoffer.no61to66;

import java.util.Stack;

import com.lintcode.common.TreeNode;

/**
 * 
 * 二叉搜索树的第k个结点
 * 
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月6日 下午3:10:53
 */
public class Pnum0062 {

    public static void main(String[] args) {
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        
        
        tn4.left = tn2;
        tn4.right = tn6;
        
        tn2.left = tn1;
        tn2.right = tn3;
        
        tn6.left = tn5;
        tn6.right = tn7;
        
        
//        tn1.right = tn2;
//        tn2.right = tn3;
//        tn3.right = tn4;
//        tn4.right = tn5;
//        tn5.right = tn6;
        
        
        Pnum0062 pnum0062_ = new Pnum0062();
        TreeNode ret = pnum0062_.KthNode(tn4, 1);
        System.out.println(ret.val);
    }
    
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if(null == pRoot) {
            return null;
        }
        
        TreeNode loopNode = pRoot;
        Stack<TreeNode> nodes = new Stack<>();
        
        int index = 0;
        while(null!=loopNode || !nodes.isEmpty()) {
            if(null != loopNode) {
                nodes.push(loopNode);
                loopNode = loopNode.left;
            } else {
                TreeNode popNode = nodes.pop();
                if(++index == k) {
                    return popNode;
                } 
                
                loopNode = popNode.right;
            }
        }
        
        return null;
    }
    
    
}
