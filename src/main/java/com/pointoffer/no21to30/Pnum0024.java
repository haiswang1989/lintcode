package com.pointoffer.no21to30;

import java.util.ArrayList;
import java.util.Stack;

import com.lintcode.common.TreeNode;

/**
 * 
 * 二叉树中和为某一值的路径
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：255003
 * 
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月31日 下午2:15:23
 */
public class Pnum0024 {

    public static void main(String[] args) {
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        
        tn1.left = tn2;
        tn1.right = tn5;
        
        tn2.left = tn3;
        tn2.right = tn4;
        
        Pnum0024 pnum0024_ = new Pnum0024();
        ArrayList<ArrayList<Integer>> rets = pnum0024_.FindPath(tn1, 6);
        System.out.println(rets);
    }
    
    /**
     * 
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> rets = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode loopNode = root;
        ArrayList<Integer> ret = new ArrayList<>();
        int sum = 0;
        
        TreeNode popNode = null;
        
        while(null!=loopNode || !stack.isEmpty()) {
            if(null!=loopNode) {
                sum += loopNode.val;
                ret.add(loopNode.val);
                if(isLeaf(loopNode)) {
                    if(sum == target) {
                        addToList(rets, new ArrayList<>(ret));
                    } 
                    
                    sum -= loopNode.val;
                    ret.remove(ret.size()-1);
                    if(null!=popNode) {
                        sum -= popNode.val;
                        ret.remove(ret.size()-1);
                        popNode = null;
                    }
                    
                    loopNode = null;
                } else {
                    popNode = null;
                    stack.push(loopNode);
                    loopNode = loopNode.left;
                }
            } else {
                popNode = stack.pop();
                loopNode = popNode.right;
            }
        }
        
        return rets;
    }
    
    /**
     * 是否是叶子结点
     * @param treeNode
     * @return
     */
    public boolean isLeaf(TreeNode treeNode) {
        return null==treeNode.left && null==treeNode.right;
    }
    
    public void addToList(ArrayList<ArrayList<Integer>> rets, ArrayList<Integer> ret) {
        if(rets.size() == 0) {
            rets.add(ret);
        } else {
            int index = 0;
            
            for (ArrayList<Integer> r : rets) {
                if(r.size() <= ret.size()) {
                    rets.add(index+1, ret);
                    return;
                } 
                
                index++;
            }
            
            rets.add(ret);
        }
    } 
}
