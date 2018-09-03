package com.lintcode.t201808;

import java.util.Stack;

import com.lintcode.common.DoublyListNode;
import com.lintcode.common.TreeNode;

/**
 * 将二叉查找树转换成双链表
 * 
 * 将一个二叉查找树按照中序遍历转换成双向链表
 * 
 * 给定一个二叉查找树
 *          4
 *       2     5
 *     1   3
 * 
 * 返回 1<->2<->3<->4<->5
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月9日 上午10:26:40
 */
public class Pnum0378 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        
        tn4.left = tn2;
        tn4.right = tn5;
        
        tn2.left = tn1;
        tn2.right = tn3;
        
        Pnum0378 pnum0378 = new Pnum0378();
        DoublyListNode head = pnum0378.bstToDoublyList(tn4);
        System.out.println(head);
    }
    
    /**
     * 
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if(null == root) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode loopNode = root;
        DoublyListNode beforeNode = null;
        DoublyListNode head = null;
        
        while(null != loopNode || 0 != stack.size()) {
            if(null == loopNode) {
                loopNode = stack.pop();
                if(null == beforeNode) {
                    beforeNode = new DoublyListNode(loopNode.val);
                    head = beforeNode;
                } else {
                    DoublyListNode node = new DoublyListNode(loopNode.val);
                    beforeNode.next = node;
                    node.prev = beforeNode;
                    beforeNode = node;
                }
                loopNode = loopNode.right;
            } else {
                stack.push(loopNode);
                if(null != loopNode.left) {
                    loopNode = loopNode.left;
                } else {
                    loopNode = null;
                }
            }
        }
        
        return head;
    }   
    
    /**
     * 
     * @param beforeNode
     * @param loopNode
     */
    public void addNode(DoublyListNode beforeNode, TreeNode loopNode) {
        DoublyListNode node = new DoublyListNode(loopNode.val);
        beforeNode.next = node;
        node.prev = beforeNode;
        beforeNode = node;
    }
}
