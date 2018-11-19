package com.pointoffer.no51to60;

import com.lintcode.common.TreeNode;

/**
 * 
 * 对称的二叉树
 * 
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * 两个节点A和B对称等价于: 
 * 1：这两个节点上存储的值相等
 * 2：节点A的左子树节点和节点B的右子树上的节点是对称的
 * 3：节点A的右子树节点和节点A的左子树上的节点是对称的
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月5日 上午10:10:41
 */
public class Pnum0058 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        TreeNode tn8 = new TreeNode(8);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn6_1 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn7_1 = new TreeNode(7);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn5_1 = new TreeNode(5);
        
        tn8.left = tn6;
        tn8.right = tn6_1;
        tn6.left = tn5;
        tn6.right = tn7;
        
        tn6_1.left = tn7_1;
        tn6_1.right = tn5_1;
        
        Pnum0058 pnum0058_ = new Pnum0058();
        boolean isSuccess = pnum0058_.isSymmetrical(tn8);
        System.out.println(isSuccess);
    }
    
    boolean isSymmetrical(TreeNode pRoot) {
        if(null==pRoot) {
            return true;
        }
        
        return isSymmetricalTree(pRoot.left, pRoot.right);
    }
    
    /**
     * 
     * @param leftTree
     * @param rightTree
     * @return
     */
    boolean isSymmetricalTree(TreeNode leftTree, TreeNode rightTree) {
        if(null!=leftTree && null!=rightTree) {
            return leftTree.val == rightTree.val && 
                    isSymmetricalTree(leftTree.left, rightTree.right) && 
                    isSymmetricalTree(leftTree.right, rightTree.left);
        } else if(null==leftTree && null==rightTree) {
            return true;
        }
        
        return false;
    }
}
