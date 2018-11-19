package com.pointoffer.no51to60;

import java.util.ArrayList;
import java.util.List;

import com.lintcode.common.TreeNode;

/**
 * 把二叉树打印成多行
 * 
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月5日 上午10:11:51
 */
public class Pnum0060 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rets = new ArrayList<>();
        if(null == pRoot) {
            return rets;
        }
        
        List<TreeNode> list_1 = new ArrayList<>();
        List<TreeNode> list_2 = new ArrayList<>();
        list_1.add(pRoot);
        boolean flag = true;
        while(flag ? 0!=list_1.size() : 0!=list_2.size()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if(flag) {
                list_2.clear();
                for (TreeNode treeNode : list_1) {
                    arrayList.add(treeNode.val);
                    if(null!=treeNode.left) {
                        list_2.add(treeNode.left);
                    }
                    
                    if(null!=treeNode.right) {
                        list_2.add(treeNode.right);
                    }
                }
            } else {
                list_1.clear();
                for (TreeNode treeNode : list_2) {
                    arrayList.add(treeNode.val);
                    if(null!=treeNode.left) {
                        list_1.add(treeNode.left);
                    }
                    
                    if(null!=treeNode.right) {
                        list_1.add(treeNode.right);
                    }
                }
            }
            flag = !flag;
            rets.add(arrayList);
        }
        
        return rets;
    }

}
