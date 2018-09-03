package com.lintcode.t201807;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import com.lintcode.common.TreeNode;

/**
 * 二叉树的后序遍历
 * 
 * 给出一棵二叉树，返回其节点值的后序遍历
 * 
 * 给出一棵二叉树 {1,#,2,3}
 * 返回 [3,2,1]
 * 
 * 你能使用非递归实现么？
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月5日 下午6:04:51
 */
public class Pnum0068 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        
        tn1.left = tn2;
        tn1.right = tn3;
        
        Pnum0068 pnum0068 = new Pnum0068();
        List<Integer> resultList = pnum0068.postorderTraversal(tn1);
        System.out.println(Arrays.toString(resultList.toArray()));
    }
    
    /**
     * 
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> resultList = new ArrayList<>();
        if(null!=root) {
            //recursion(root, resultList);
            nonRecursion(root, resultList);
        }
        
        return resultList;
    }
    
    /**
     * 
     * @param node
     * @param resultList
     */
    private void nonRecursion(TreeNode node, List<Integer> resultList) {
        Stack<TreeNode> stack = new Stack<>();
        //已经访问过right结点的结点
        HashSet<TreeNode> hasVisitNodes = new HashSet<>();
        TreeNode tNode = node;
        while(null!=tNode || 0!=stack.size()) {
            if(null!=tNode) { 
                //一直访问left结点,直到叶子结点
                stack.push(tNode);
                tNode = tNode.left;
            } else {
                tNode = stack.pop(); //从堆栈中pop出一个结点
                if(hasVisitNodes.contains(tNode)) { //check该结点的right结点是否访问过
                    resultList.add(tNode.val); //如果访问过了,直接打印该结点
                    tNode = null; //将tNode设置为null,让重新从栈中pop出元素
                } else { //该结点的right结点没有访问过
                    hasVisitNodes.add(tNode); //访问该结点的right结点 
                    stack.push(tNode); //将该结点push到stack中
                    tNode = tNode.right; //访问该结点的right结点
                }
            }
        }
    }
    
    /**
     * 
     * @param node
     * @param resultList
     */
    private void recursion(TreeNode node, List<Integer> resultList) {
        
        TreeNode leftChildNode = node.left;
        TreeNode rightChildNode = node.right;
        
        if(null != leftChildNode) {
            recursion(leftChildNode, resultList);
        }
        
        if(null != rightChildNode) {
            recursion(rightChildNode, resultList);
        }
        
        resultList.add(node.val);
    }   
}
