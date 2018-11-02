package com.pointoffer.no1to10;

import com.lintcode.common.TreeNode;

/**
 * 
 * 重建二叉树
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：474205
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月18日 下午1:54:19
 */
public class Pnum0004 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] pre = {3,7,11,13,18,29,40,63,88,122,89,123,64,90,129,91,131,43,66,93,134,135,95,67,98,144,16,22,30,46,72,102,146,148,33,48,73,105,149,151,107,153,25,36,52,79,109,157,112,160,80,55,85,117,163,165,37};
        int[] in = {3,7,18,88,122,63,123,89,40,90,129,64,131,91,29,134,93,135,66,95,43,67,98,144,13,11,30,46,72,146,102,148,22,149,105,151,73,107,153,48,33,16,109,157,79,112,160,52,80,36,55,85,163,117,165,25,37};
        
//        int[] pre = {1,2,4,7,3,5,6,8};
//        int[] in = {4,7,2,1,5,3,8,6};
        
        Pnum0004 Pnum0004 = new Pnum0004();
        TreeNode tn = Pnum0004.reConstructBinaryTree(pre, in);
        System.out.println("----" + tn);
    }
    
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(null == pre || 0 == pre.length) {
            return null;
        }
        
        return recursion(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    
    /**
     * 
     * @param pre
     * @param preFromIndex
     * @param preEndIndex
     * @param in
     * @param inFromIndex
     * @param inEndIndex
     * @return
     */
    public TreeNode recursion(int[] pre, int preFromIndex, int preEndIndex, int[] in, int inFromIndex, int inEndIndex) {
        if(preFromIndex == preEndIndex) {
            return new TreeNode(pre[preEndIndex]);
        }
        
        //head结点的值
        int headVal = pre[preFromIndex];
        
        //head结点在中序遍历中的位置,用于拆分左右子树
        //位置的左边是左子树
        //位置的右边是右子树
        int headInIndex = getIndex(headVal, in);
        
        //左子树
        TreeNode leftTree = null;
        //左子树在"前序遍历"数组中的最后一个结点的位置
        //右子树的开始结点在该结点之后
        int preLeftTreeEndIndex = preFromIndex;
        if(headInIndex != inFromIndex) {
            //左子树不为NULL
            //左子树的所有结点在中序遍历的数组中的起始和结束位置
            int inLeftTreeFromIndex = inFromIndex;
            int inLeftTreeEndIndex = headInIndex - 1;
            
            //左子树结点的个数,用于定位左子树在前序遍历数组中的结束位置
            int inLeftTreeNodeCount = inLeftTreeEndIndex - inLeftTreeFromIndex + 1;
            //左子树所有结点在前序遍历的数组中的起始和结束位置
            int preLeftTreeFromIndex = preFromIndex + 1;
            preLeftTreeEndIndex = preLeftTreeFromIndex + inLeftTreeNodeCount - 1;
            leftTree = recursion(pre, preLeftTreeFromIndex, preLeftTreeEndIndex, in, inLeftTreeFromIndex, inLeftTreeEndIndex);
        } 
        
        //右子树
        TreeNode rightTree = null;
        if(headInIndex != inEndIndex) {
            //右子树不为NULL
            //右子树的所有结点在中序遍历的数组中的起始和结束位置
            int inRightTreeFromIndex = headInIndex + 1;
            int inRightTreeEndIndex = inEndIndex;
            //右子树结点的个数,用于定位右子树在前序遍历数组中的结束位置
            int inRightTreeNodeCount = inRightTreeEndIndex - inRightTreeFromIndex + 1;
            
            //右子树所有结点在前序遍历的数组中的起始和结束位置
            int preRightTreeFromIndex =  preLeftTreeEndIndex + 1;
            int preRightTreeEndIndex = preRightTreeFromIndex + inRightTreeNodeCount - 1;
            rightTree = recursion(pre, preRightTreeFromIndex, preRightTreeEndIndex, in, inRightTreeFromIndex, inRightTreeEndIndex);
        }
        
        TreeNode treeHead = new TreeNode(headVal);
        treeHead.left = leftTree;
        treeHead.right = rightTree;
        return treeHead;
    }
    
    /**
     * 获取目标元素在目标数组中的位置
     * 
     * @param target
     * @param in
     * @return
     */
    public int getIndex(int target, int[] targetArray) {
        for(int i=0; i<targetArray.length; i++) {
            if(targetArray[i] == target) {
                return i;
            }
        }
        
        //NOT REACH
        return -1;
    }
}
