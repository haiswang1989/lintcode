package com.lintcode.t201807;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.lintcode.common.TreeNode;

/**
 * 
 * 二叉树的前序遍历
 * 
 * 根 - 左 - 右
 * 
 * 给出一棵二叉树，返回其节点值的前序遍历。
 * 1
 *    2
 * 3
 * 
 * 返回 [1,2,3].
 * 
 * 你能使用非递归实现么？
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月5日 下午3:22:20
 */
public class Pnum0066 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        
        tn1.left = tn2;
        tn1.right = tn3;
        
        Pnum0066 pnum66 = new Pnum0066();
        
        List<Integer> resultList = pnum66.preorderTraversal(tn1);
        System.out.println(Arrays.toString(resultList.toArray()));
    }
    
    /**
     * 
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> resultList = new ArrayList<>();
        if(null == root) {
            return resultList;
        }
        
        //recursion(root, resultList);
        nonRecursion(root, resultList);
        return resultList;
    }
    
    /**
     * 非递归方式
     * @param node
     * @param resultList
     */
    private void nonRecursion(TreeNode node, List<Integer> resultList) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tNode = node;
        
        while(stack.size() != 0 || null!=tNode) {
            if(null!=tNode) {
                resultList.add(tNode.val);
                TreeNode rightChildNode = tNode.right;
                if(null!=rightChildNode) {
                    stack.push(rightChildNode);
                }
                
                tNode = tNode.left;
            } else {
                tNode = stack.pop();
            }
        }
    }
    
    /**
     * 递归方式
     * @param node
     * @param resultList
     */
    private void recursion(TreeNode node, List<Integer> resultList) {
        resultList.add(node.val);
        TreeNode leftChildNode = node.left;
        TreeNode rightChildNode = node.right;
        
        if(null != leftChildNode) {
            recursion(leftChildNode, resultList);
        }
        
        if(null != rightChildNode) {
            recursion(rightChildNode, resultList);
        }
    }
}
