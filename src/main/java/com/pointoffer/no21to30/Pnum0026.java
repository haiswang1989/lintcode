package com.pointoffer.no21to30;

import java.util.ArrayList;
import java.util.List;

import com.lintcode.common.TreeNode;

/**
 * 
 * 二叉搜索树与双向链表
 * 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月31日 下午2:52:39
 */
public class Pnum0026 {

    public static void main(String[] args) {
        
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn8 = new TreeNode(8);
        TreeNode tn10 = new TreeNode(10);
        TreeNode tn12 = new TreeNode(12);
        TreeNode tn14 = new TreeNode(14);
        TreeNode tn16 = new TreeNode(16);
        
        tn10.left = tn6;
        tn10.right = tn14;
        
        tn6.left = tn4;
        tn6.right = tn8;
        
        tn14.left = tn12;
        tn14.right = tn16;
        
        Pnum0026 pnum0026_ = new Pnum0026();
        TreeNode newHead =  pnum0026_.Convert(tn10);
        System.out.println(newHead);
        
    }
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(null == pRootOfTree) {
            return null;
        }
        
        List<TreeNode> nodes = new ArrayList<>();
        inOrderWithRecursion(pRootOfTree, nodes);
        
        TreeNode beforeNode = null;
        TreeNode head = null;
        for (TreeNode treeNode : nodes) {
            if(null!=beforeNode) {
                beforeNode.right = treeNode;
                treeNode.left = beforeNode;
            } else {
                head = treeNode;
                head.left = null;
            }
            
            beforeNode = treeNode;
            beforeNode.right = null;
        }
        
        return head;
    }
    
    public void inOrderWithRecursion(TreeNode treeNode, List<TreeNode> nodes) {
        TreeNode leftChildNode = treeNode.left;
        if(null!=leftChildNode) {
            inOrderWithRecursion(leftChildNode, nodes);
        }
        nodes.add(treeNode);
        TreeNode rightChildNode = treeNode.right;
        if(null!=rightChildNode) {
            inOrderWithRecursion(rightChildNode, nodes);
        }
    }
}
