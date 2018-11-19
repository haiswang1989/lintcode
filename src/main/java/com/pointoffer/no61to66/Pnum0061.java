package com.pointoffer.no61to66;

import java.util.ArrayList;

import com.lintcode.common.TreeNode;

/**
 * 
 * 序列化二叉树
 * 
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月6日 下午3:08:23
 */
public class Pnum0061 {

    public static void main(String[] args) {
        
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        
        tn1.left = tn2;
        tn1.right = tn3;
        
        tn2.left = tn4;
        tn2.right = tn5;
        
        tn3.left = tn6;
        tn3.right = tn7;
        
        Pnum0061 pnum0061_ = new Pnum0061();
        String str = pnum0061_.Serialize(tn1);
        System.out.println(str);
        
        TreeNode tn = pnum0061_.Deserialize(str);
        System.out.println(tn);
    }
    
    /**
     * 序列化
     * @param root
     * @return
     */
    public String Serialize(TreeNode root) {
        if(null==root) {
            return null;
        }
        
        StringBuilder sBuilder = new StringBuilder();
        serializeWithRecursion(root, sBuilder);
        return sBuilder.toString();
    }
    
    /**
     * 递归序列化(先根遍历)
     * @param node
     * @param sBuilder
     */
    public void serializeWithRecursion(TreeNode node, StringBuilder sBuilder) {
        if(null==node) {
            sBuilder.append("#,");
            return;
        }
        
        sBuilder.append(node.val).append(",");
        serializeWithRecursion(node.left, sBuilder);
        serializeWithRecursion(node.right, sBuilder);
    }
    
    /**
     * 反序列化
     * @param str
     * @return
     */
    public TreeNode Deserialize(String str) {
        if(null==str) {
            return null;
        }
        
        String[] nodes = str.split(",", -1);
        ArrayList<String> list = new ArrayList<>();
        for (String val : nodes) {
            if(!"".equals(val)) {
                list.add(val);
            }
        }
        
        return deserializeWithRecursion(list);
    }
    
    /**
     * 
     * @param node
     * @param nodes
     * @param fromIndex
     */
    public TreeNode deserializeWithRecursion(ArrayList<String> list) {
        if(0==list.size()) {
            return null;
        }
        
        String val = list.get(0);
        list.remove(0);
        if(!"#".equals(val)) {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            TreeNode leftNode = deserializeWithRecursion(list);
            TreeNode rightNode = deserializeWithRecursion(list);
            
            node.left = leftNode;
            node.right = rightNode;
            return node;
        }
        
        return null;
    }
}
