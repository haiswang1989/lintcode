package com.lintcode.t201807;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lintcode.common.TreeNode;

/**
 * 二叉树的层次遍历
 * 
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 * 
 * 给一棵二叉树 {3,9,20,#,#,15,7} ：
 * 
 * 返回他的分层遍历结果：
 * 
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月6日 上午10:37:54
 */
public class Pnum0069 {

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
        
        Pnum0069 pnum0069 = new Pnum0069();
        List<List<Integer>> resultList = pnum0069.levelOrder(tn3);
        System.out.println(resultList);
    }
    
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if(null != root) {
            byQueue(root, resultList);
        }
        
        return resultList;
    }
    
    
    /**
     * 使用深度优先
     * 
     * @param node
     * @param resultList
     */
    private void byDFS(TreeNode node, List<List<Integer>> resultList) {
        
    }
    
    /**
     * 使用单队列来实现,以NULL作为行的分隔
     * 
     * @param node
     * @param resultList
     */
    private void byQueue(TreeNode node, List<List<Integer>> resultList) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        queue.offer(node);
        queue.offer(null); //先放入一个null,用于分行
        
        while(0!=queue.size()) {
            node = queue.poll(); 
            if(null == node) { //node为NULL,换行标记
                //遇到换行,且队列不为空的时候,在队尾插入一个换行
                //如果队列已经为空了(结束了),就不要再插了避免出现死循环
                if(0!=queue.size()) { 
                    queue.offer(null);
                }
                
                resultList.add(level); //将当前的List加入到结果集中
                level = new ArrayList<>(); //重新New一个List
            } else {
                level.add(node.val); //打印当前值
                //将左右孩子(NOT NULL)加入到队列中
                TreeNode leftChildNode = node.left; 
                TreeNode rightChildNode = node.right;
                if(null != leftChildNode) {
                    queue.add(leftChildNode);
                }
                
                if(null != rightChildNode) {
                    queue.add(rightChildNode);
                }
            }
        }
    }
}
