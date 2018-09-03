package com.lintcode.t201807;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.lintcode.common.TreeNode;

/**
 * 二叉树的中序遍历
 * 
 * 给出一棵二叉树,返回其中序遍历
 * 
 * 给出二叉树 {1,#,2,3},
 * 
 * 你能使用非递归算法来实现么?
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月5日 下午5:34:20
 */
public class Pnum0067 {

    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        
        tn1.left = tn2;
        tn1.right = tn3;
        
        Pnum0067 pnum0067 = new Pnum0067();
        List<Integer> resultList = pnum0067.inorderTraversal(tn1);
        System.out.println(Arrays.toString(resultList.toArray()));
        
    }
    
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> resultList = new ArrayList<>();
        if(null!=root) {
            //recursion(root, resultList);
            nonRecursion(root, resultList);
        }
        
        return resultList;
    }
    
    /**
     * 非递归实现
     * @param root
     * @param resultList
     */
    private void nonRecursion(TreeNode root, List<Integer> resultList) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tNode = root;
        
        while(null!=tNode || 0!=stack.size()) {
            if(null!=tNode) {
                stack.push(tNode);
                tNode = tNode.left;
            } else {
                tNode = stack.pop();
                resultList.add(tNode.val);
                tNode = tNode.right;
            }
        }
    }
    
    /**
     * 递归实现
     * @param root
     * @param resultList
     */
    private void recursion(TreeNode node, List<Integer> resultList) {
        TreeNode leftChildNode = node.left;
        TreeNode rightChildNode = node.right;
        
        if(null!=leftChildNode) {
            recursion(leftChildNode, resultList);
        }
        
        resultList.add(node.val);
        
        if(null!=rightChildNode) {
            recursion(rightChildNode, resultList);
        }
    }
}
