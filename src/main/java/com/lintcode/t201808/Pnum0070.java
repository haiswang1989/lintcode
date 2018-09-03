package com.lintcode.t201808;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.lintcode.common.TreeNode;

/**
 * 二叉树的层次遍历 II
 * 
 * 给出一棵二叉树，返回其节点值从底向上的层次序遍历
 * （按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）
 * 
 * 给出一棵二叉树 {3,9,20,#,#,15,7}
 *      3
 *    9   20
 *       15 7
 * 
 * [
 *  [15,7]
 *  [9,20]
 *  [3] 
 * ]
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月29日 下午3:49:48
 */
public class Pnum0070 {

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
        
        Pnum0070 pnum0070 = new Pnum0070();
        List<List<Integer>> ret = pnum0070.levelOrderBottom(tn3);
        System.out.println(ret);
    }
    
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        if(null == root) {
            return new ArrayList<>();
        }
        
        Stack<List<Integer>> ret = new Stack<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode loopNode = root;
        queue.offer(null);
        
        List<Integer> levelList = new ArrayList<>();
        while(null!=loopNode || 0!=queue.size()) {
            if(null == loopNode) {
                ret.push(levelList);
                if(0 == queue.size()) {
                    break;
                }
                queue.add(null);
                levelList = new ArrayList<>(); 
                loopNode = queue.poll();
            }
            
            levelList.add(loopNode.val);
            if(null!=loopNode.left) {
                queue.add(loopNode.left);
            }
            
            if(null!=loopNode.right) {
                queue.add(loopNode.right);
            }
            
            loopNode = queue.poll();
        }
        
        ret.push(levelList);
        
        List<List<Integer>> retList = new ArrayList<>();
        while(!ret.isEmpty()) {
            retList.add(ret.pop());
        }
        
        return retList;
    }
}
