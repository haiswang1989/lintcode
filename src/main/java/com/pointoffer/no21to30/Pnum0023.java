package com.pointoffer.no21to30;

/**
 * 二叉搜索树的后序遍历序列
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：286438
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月31日 上午9:44:53
 */
public class Pnum0023 {

    public static void main(String[] args) {
        //int[] sequence = {1,4,3,6,8,7,5};
        //int[] sequence = {4,3,8,7,5};
        //int[] sequence = {1,3,6,7,5};
        
        int[] sequence = {4,1,3,6,8,7,5};
        Pnum0023 pnum0023 = new Pnum0023();
        System.out.println(pnum0023.VerifySquenceOfBST(sequence));
    }
    
    /**
     * 
     * 二叉搜索树的特点
     * 
     * 1：任意一个结点的左子树的所有结点都小于右子树的所有结点
     * 
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(null==sequence || 0==sequence.length) {
            return false;
        }
        
        int fromIndex = 0;
        int endIndex = sequence.length - 1;
        return byRecursion(sequence, fromIndex, endIndex);
    }
    
    /**
     * 
     * 大致的思路,最后一个结点是head结点
     * 
     * 找到head结点在 list中的位置,使得左边的结点都小于head结点,右边的结点都大于head结点
     * 如果找不到这样的位置,那么就不是"查找二叉树"的后续遍历列表
     * 递归check,直到最后一个结点
     * 
     * 
     * @param sequence
     * @param fromIndex
     * @param endIndex
     * @return
     */
    public boolean byRecursion(int[] sequence, int fromIndex, int endIndex) {
        if(fromIndex == endIndex) {
            return true;
        }
        
        int head = sequence[endIndex];
        //左右子树
        int separateLeftRightPointIndex = -1;
        //是否找到分割左右子树的分界点
        boolean hasFindSeparateLeftRightPoint = false;
        for(int i=fromIndex; i<=endIndex; i++) {
            if(hasFindSeparateLeftRightPoint) {
                if(sequence[i] < head) {
                    return false;
                }
            } else {
                if(sequence[i] >= head) {
                    hasFindSeparateLeftRightPoint = true;
                    separateLeftRightPointIndex = i;
                }
            }
        }
        
        if(separateLeftRightPointIndex == endIndex) { //只有左子树
            return byRecursion(sequence, fromIndex, endIndex-1);
        } else if(separateLeftRightPointIndex == fromIndex) { //只有右子树
            return byRecursion(sequence, fromIndex + 1, endIndex);
        } else { //同时又左右子树
            return byRecursion(sequence, fromIndex, separateLeftRightPointIndex-1) && byRecursion(sequence, separateLeftRightPointIndex, endIndex-1);
        }
    }
}
