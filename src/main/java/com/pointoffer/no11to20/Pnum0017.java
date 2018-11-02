package com.pointoffer.no11to20;

import com.lintcode.common.TreeNode;

/**
 * 树的子结构
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：326681
 * 
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月30日 上午9:23:14
 */
public class Pnum0017 {

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
        
        
        TreeNode tn2_3 = new TreeNode(3);
        TreeNode tn2_6 = new TreeNode(6);
        TreeNode tn2_7 = new TreeNode(7);
        tn2_3.left = tn2_6;
        tn2_3.right = tn2_7;
        
        
//        TreeNode tn8_1  = new TreeNode(8);
//        TreeNode tn8_2  = new TreeNode(8);
//        TreeNode tn9_1  = new TreeNode(9);
//        TreeNode tn2_1  = new TreeNode(2);
//        TreeNode tn5  = new TreeNode(5);
//        
//        TreeNode tn8_3  = new TreeNode(8);
//        TreeNode tn9_2  = new TreeNode(9);
//        TreeNode tn2_2  = new TreeNode(2);
//        
//        tn8_1.right = tn8_2;
//        tn8_2.right = tn9_1;
//        tn9_1.right = tn2_1;
//        tn2_1.right = tn5;
//        
//        tn8_3.right = tn9_2;
//        tn9_2.right = tn2_2;
        
        
        Pnum0017 pnum0017 = new Pnum0017();
        boolean hasSubTree = pnum0017.HasSubtree(tn1_1, tn2_3);
        System.out.println(hasSubTree);
    }
    
    /**
     * 
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(null == root1 || null == root2 ) {
            return false;
        }
        
        return isSubTreeWithRecursion(root1, root2);
    }
    
    /**
     * 
     * 递归遍历node1的结点 
     * 当遇到node1.val == node2.val时就再递归遍历两树是否equals
     * 
     * @param node1
     * @param node2
     * @return
     */
    public boolean isSubTreeWithRecursion(TreeNode node1,TreeNode node2) {
        boolean isTrue = false;
        if(node1.val == node2.val) {
            isTrue = isEquals(node1, node2);
            if(isTrue) {
                return true;
            }
        }
        
        TreeNode leftNode = node1.left;
        if(null!=leftNode) {
            isTrue = isSubTreeWithRecursion(leftNode, node2);
            if(isTrue) {
                return true;
            }
        } 
        
        
        TreeNode rightNode = node1.right;
        if(null!=rightNode) {
            isTrue = isSubTreeWithRecursion(rightNode, node2);
            if(isTrue) {
                return true;
            }
        } 
        
        
        return false;
    }
    
    /**
     * 
     * @param node1
     * @param node2
     * @return
     */
    public boolean isEquals(TreeNode node1, TreeNode node2) {
        if(null != node1 && null != node2) {
            if(node1.val == node2.val) {
                return isEquals(node1.left, node2.left) && isEquals(node1.right, node2.right); 
            } else {
                return false;
            }
        } else if(null == node2) {
            return true;
        } else {
            return false;
        }
    }
}
