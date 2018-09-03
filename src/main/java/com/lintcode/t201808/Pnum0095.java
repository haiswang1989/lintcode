package com.lintcode.t201808;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.lintcode.common.TreeNode;

/**
 * 验证二叉查找树
 * 
 * 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
 * 
 * 一棵BST定义为：
 * 节点的左子树中的值要严格小于该节点的值。
 * 节点的右子树中的值要严格大于该节点的值。
 * 左右子树也必须是二叉查找树。
 * 一个节点的树也是二叉查找树。
 * 
 * 样例
 * 一个例子：
 *      2
 *     / \
 *    1   4
 *       / \
 *      3   5
 * 上述这棵二叉树序列化为 {2,1,4,#,#,3,5}.
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月30日 上午9:16:41
 */
public class Pnum0095 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        
        tn2.left = tn1;
        tn2.right = tn4;
        
        tn4.left = tn3;
        tn4.right = tn5;
        
        Pnum0095 pnum0095 = new Pnum0095();
        System.out.println(pnum0095.isValidBST(tn2));
                
    }
    
    /**
     * 
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        //return isValidByInorderTraversal(root);
        return isValidByRecusion(root, null, null);
    }
    
    /**
     * 通过递归的形式
     * 
     * 判定标准
     * 
     * 左孩子小于根节点,右孩子大于根节点同时还要满足
     * 左子树的结点都比根结点小
     * 右子树的结点都比根结点大
     * @param node
     * @param min 注意这边min和max是可以为null的,如果是null就不进行check,用Integer.MAX_VALUE和Integer.MIN_VALUE会有边界情况
     * @param max
     * @return
     */
    public boolean isValidByRecusion(TreeNode node, Integer min, Integer max) {
        if(null == node) {
            return true;
        }
        
        if(null!=min && node.val <= min) {
            return false;
        }
        
        if(null!=max && node.val >= max) {
            return false;
        }
        
        return isValidByRecusion(node.left, min, node.val) && isValidByRecusion(node.right, node.val, max);
    }
    
    
    /**
     * 大致思路就是通过中序遍历,先遍历整个BST
     * 如果最终的结果是从小到大的有序排序着的就是"合法"的,否则就不是 
     * @return
     */
    public boolean isValidByInorderTraversal(TreeNode root) {
        if(null == root) {
            return true;
        }
        
        List<Integer> rets = inorderTraversal(root);
        Integer before = null;
        boolean isValid = true;
        for (Integer val : rets) {
            if(null!=before) {
                isValid &= val > before;
            }
            
            before = val;
            if(!isValid) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * 中序遍历
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode loopNode = node;
        while(null!=loopNode || 0!=nodes.size()) {
            if(null == loopNode) {
                loopNode = nodes.pop();
                ret.add(loopNode.val);
                loopNode = loopNode.right;
            } else {
                nodes.push(loopNode);
                loopNode = loopNode.left;
            }
        }
        
        return ret;
    }
}
