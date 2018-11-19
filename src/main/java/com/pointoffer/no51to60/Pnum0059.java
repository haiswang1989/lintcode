package com.pointoffer.no51to60;

import java.util.ArrayList;
import java.util.Stack;

import com.lintcode.common.TreeNode;

/**
 * 
 * 按之字形顺序打印二叉树
 * 
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月5日 上午10:11:15
 */
public class Pnum0059 {

    public static void main(String[] args) {
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        
        tn1.left = tn2;
        tn1.right = tn3;
        
        Pnum0059 pnum0059_ = new Pnum0059();
        ArrayList<ArrayList<Integer>> rets = pnum0059_.Print(tn1);
        System.out.println(rets);
    }
    
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(null == pRoot) {
            return new ArrayList<>();
        }
        
        Stack<TreeNode> stack_1 = new Stack<>();
        Stack<TreeNode> stack_2 = new Stack<>();
        stack_1.add(pRoot);
        boolean flag = true;
        
        ArrayList<ArrayList<Integer>> rets = new ArrayList<>();
        
        while(flag ? !stack_1.isEmpty() : !stack_2.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if(flag) {
                while(!stack_1.isEmpty()) {
                    TreeNode treeNode = stack_1.pop();
                    arrayList.add(treeNode.val);
                    if(null!=treeNode.left) {
                        stack_2.push(treeNode.left);
                    }
                    
                    if(null!=treeNode.right) {
                        stack_2.push(treeNode.right);
                    }
                }
            } else {
                while(!stack_2.isEmpty()) {
                    TreeNode treeNode = stack_2.pop();
                    arrayList.add(treeNode.val);
                    if(null!=treeNode.right) {
                        stack_1.push(treeNode.right);
                    }
                    
                    if(null!=treeNode.left) {
                        stack_1.push(treeNode.left);
                    }
                }
            }
            
            flag=!flag;
            rets.add(arrayList);
        }
        
        return rets;
    }

}
