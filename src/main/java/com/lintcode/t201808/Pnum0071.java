package com.lintcode.t201808;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.lintcode.common.TreeNode;

/**
 *  二叉树的锯齿形层次遍历
 *  
 *  给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行） 
 *  
 *  给出一棵二叉树 {3,9,20,#,#,15,7}
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *  
 * 返回其锯齿形的层次遍历为：
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月29日 下午4:31:00
 */
public class Pnum0071 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn9 = new TreeNode(9);
        TreeNode tn20 = new TreeNode(20);
        TreeNode tn15 = new TreeNode(15);
        TreeNode tn7 = new TreeNode(7);
        
        tn3.left = tn9;
        tn3.right = tn20;
        tn20.left = tn15;
        tn20.right = tn7;
        
        Pnum0071 pnum0071 = new Pnum0071();
        List<List<Integer>> ret = pnum0071.zigzagLevelOrder(tn3);
        System.out.println(ret);
    }
    
    /**
     * 解决方案,用两个stack来交替遍历
     * 
     * 注意从左往右的时候 先左孩子后右孩子
     * 从右往左的时候,先右孩子后左孩子
     * 
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(null == root) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> retList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        
        //使用两个栈交替遍历
        Stack<TreeNode> stackOne = new Stack<>();
        Stack<TreeNode> stackTwo = new Stack<>();
        
        TreeNode loopNode = root;
        boolean flag = true;
        
        while(true) {
            if(null == loopNode) {
                retList.add(levelList);
                if(flag) {
                    if(stackTwo.isEmpty()) {
                        break;
                    } else {
                        loopNode = stackTwo.pop();
                    }
                } else {
                    if(stackOne.isEmpty()) {
                        break;
                    } else {
                        loopNode = stackOne.pop();
                    }
                }
                
                //换边
                flag = !flag;
                levelList = new ArrayList<>();
            }
            
            levelList.add(loopNode.val);
            if(flag) {
                //先左后右
                if(null!=loopNode.left) {
                    stackTwo.push(loopNode.left);
                }
                
                if(null!=loopNode.right) {
                    stackTwo.push(loopNode.right);
                }
                
                loopNode = stackOne.isEmpty() ? null : stackOne.pop();
            } else {
                //先右后左
                if(null!=loopNode.right) {
                    stackOne.push(loopNode.right);
                }
                
                if(null!=loopNode.left) {
                    stackOne.push(loopNode.left);
                }
                
                loopNode = stackTwo.isEmpty() ? null : stackTwo.pop();
            }
        }
        
        return retList;
    }
}
