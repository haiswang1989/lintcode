package com.lintcode.t201807;

import java.util.LinkedList;
import java.util.Queue;

import com.lintcode.common.TreeNode;

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月4日 上午10:10:21
 */
public class Pnum0007 {

    public static void main(String[] args) {
        
//        TreeNode tn3 = new TreeNode(3);
//        TreeNode tn9 = new TreeNode(9);
//        TreeNode tn20 = new TreeNode(20);
//        TreeNode tn15 = new TreeNode(15);
//        TreeNode tn7 = new TreeNode(7);
//        tn3.left = tn9;
//        tn3.right = tn20;
//        tn20.left = tn15;
//        tn20.right = tn7;
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        
        tn1.left = tn2;
        tn2.left = tn3;
        tn3.left = tn4;
        
        
        Pnum0007 pnum7 = new Pnum0007();
        String values = pnum7.serialize(tn1);
        System.out.println(values);
        
        TreeNode node = pnum7.deserialize(values);
        System.out.println(node);
    }
    
    /**
     * 
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder resultBuilder = new StringBuilder();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        serializeLevel(resultBuilder, nodes);
        return resultBuilder.toString();
    }
    
    /**
     * 
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        String value = values[0];
        TreeNode createNode = new TreeNode(Integer.parseInt(value));
        deserializeLevel(values, createNode, 0);
        return createNode;
    }
    
    /////////////////////层序遍历(一层一层的遍历)////////////////////
    private void serializeLevel(StringBuilder resultBuilder, Queue<TreeNode> nodes) {
        TreeNode pollNode = null;
        
        while(0!=nodes.size()) {
            pollNode = nodes.poll();
            
            if(null!=pollNode) {
                resultBuilder.append(pollNode.val);
                resultBuilder.append(",");
            } else {
                resultBuilder.append("#");
                resultBuilder.append(",");
                continue;
            }
            
            TreeNode leftNode = pollNode.left;
            if(null == leftNode) {
                nodes.add(null);
            } else {
                nodes.add(leftNode);
            }
            
            TreeNode rightNode = pollNode.right;
            if(null == rightNode) {
                nodes.add(null);
            } else {
                nodes.add(rightNode);
            }
        }
    }
    
    
    private void deserializeLevel(String[] values, TreeNode node, int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = leftChildIndex + 1;
        
        if(leftChildIndex < values.length) {
            String value = values[leftChildIndex];
            if(!"#".equals(value) && !"".equals(value)) {
                TreeNode leftChildNode = new TreeNode(Integer.parseInt(value));
                node.left = leftChildNode;
                deserializeLevel(values, leftChildNode, leftChildIndex);
            } 
        }
        
        if(rightChildIndex < values.length) {
            String value = values[rightChildIndex];
            if(!"#".equals(value) && !"".equals(value)) {
                TreeNode rightChildNode = new TreeNode(Integer.parseInt(value));
                node.right = rightChildNode;
                deserializeLevel(values, rightChildNode, rightChildIndex);
            } 
        }
    }
    
    ///////////////////////深度优先搜索///////////////////
    private void serializeDFS() {
        
    }
    
    private void deserializeDFS() {
        
    }
    
    /////////////////////广度优先搜索////////////////////
    private void serializeBFS() {
        
    }
    
    private void deserializeBFS() {
        
    }
    
    
}
