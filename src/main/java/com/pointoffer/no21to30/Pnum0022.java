package com.pointoffer.no21to30;

import java.util.ArrayList;
import java.util.List;

import com.lintcode.common.TreeNode;

/**
 * 
 * 从上往下打印二叉树
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：253926
 * 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月30日 下午5:47:43
 */
public class Pnum0022 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        TreeNode tn1_1 = new TreeNode(1);
        TreeNode tn1_2 = new TreeNode(2);
        TreeNode tn1_3 = new TreeNode(3);
        TreeNode tn1_4 = new TreeNode(4);
        TreeNode tn1_5 = new TreeNode(5);
        TreeNode tn1_6 = new TreeNode(6);
        TreeNode tn1_7 = new TreeNode(7);
        
        tn1_1.left = tn1_2;
        tn1_1.right = tn1_3;
        tn1_2.left = tn1_4;
        tn1_2.right = tn1_5;
        tn1_3.left = tn1_6;
        tn1_3.right = tn1_7;
        
        Pnum0022 pnum0022 = new Pnum0022();
        ArrayList<Integer> ret = pnum0022.PrintFromTopToBottom(tn1_1);
        System.out.println(ret.toString());
    }
    
    
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(null == root) {
            return ret;
        }
        
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        
        list1.add(root);
        boolean loopList1 = true;
        
        while(0!=list1.size() || 0!=list2.size()) {
            if(loopList1) {
                list2.clear();
                for (TreeNode treeNode : list1) {
                    ret.add(treeNode.val);
                    TreeNode leftChild = treeNode.left;
                    if(null != leftChild) {
                        list2.add(leftChild);
                    }
                    
                    TreeNode rightChild = treeNode.right;
                    if(null != rightChild) {
                        list2.add(rightChild);
                    }
                }
            } else {
                list1.clear();
                for (TreeNode treeNode : list2) {
                    ret.add(treeNode.val);
                    TreeNode leftChild = treeNode.left;
                    if(null != leftChild) {
                        list1.add(leftChild);
                    }
                    
                    TreeNode rightChild = treeNode.right;
                    if(null != rightChild) {
                        list1.add(rightChild);
                    }
                }
            }
            
            loopList1 = !loopList1;
        }
        
        return ret;
    }

}
