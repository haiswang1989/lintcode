package com.lintcode.t201807;

/**
 * 搜索二维矩阵
 * 
 * 写出一个高效的算法来搜索 m × n矩阵中的值。
 * 这个矩阵具有以下特性：
 * 每行中的整数从左到右是排序的
 * 每行的第一个数大于上一行的最后一个整数
 * 
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * 
 * 给出 target = 3，返回 true
 * 
 * O(log(n) + log(m)) 时间复杂度
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月5日 下午2:36:29
 */
public class Pnum0028 {

    public static void main(String[] args) {
        
        int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        Pnum0028 pnum28 = new Pnum0028();
        System.out.println(pnum28.searchMatrix(matrix, 5));
    }
    
    /**
     * 
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(null == matrix) {
            return false;
        }
        
        //行数
        int rowCount = matrix.length;
        if(rowCount == 0) {
            return false;
        }
        
        //列数
        int columnCount = matrix[0].length;
        if(columnCount == 0) {
            return false;
        }
        
        //小于二位矩阵的最小值
        //大于二维矩阵的最大值
        if(matrix[0][0] > target || matrix[rowCount-1][columnCount-1] < target) {
            return false;
        }
        
        for(int row=0; row<rowCount; row++) {
            int rowFirstEle = matrix[row][0];
            int rowLastEle = matrix[row][columnCount - 1];
            if(rowFirstEle == target || rowLastEle == target) {
                return true;
            }
            
            if(target < rowFirstEle) {
                return false;
            } else {
                if(target < rowLastEle) {
                    for(int column=1; column<columnCount; column++) {
                        if(matrix[row][column] == target) {
                            return true;
                        }
                    }
                    
                    return false;
                } 
            }
        }
        
        return false;
    }
}
