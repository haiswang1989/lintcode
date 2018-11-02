package com.pointoffer.no11to20;

import java.util.ArrayList;

/**
 * 
 * 顺时针打印矩阵
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：343101
 * 
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵
 * 1  2  3  4 
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月30日 上午11:31:35
 */
public class Pnum0019 {

    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        
        //int[][] matrix = {{1},{2},{3},{4},{5}};
        
        int[][] matrix = {{1,2,3,4}};
        
        Pnum0019 pnum0019 = new Pnum0019();
        ArrayList<Integer> ret = pnum0019.printMatrix(matrix);
        System.out.println(ret.toString());
    }
    
    /**
     * 
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        
        if(null == matrix || 0 == matrix.length) {
            return new ArrayList<>();
        }
        
        int up = 0; //往上搜索时,上排有几排已经被访问过
        int down = 0; //往下搜索时,下排有几排已经被访问过
        int left = 0; //往左搜索时,左列有几列已经被访问过
        int right = 0; //往右搜索时,右列有几列已经被访问过
        
        int yIndexLength = matrix.length;
        int xIndexLength = matrix[0].length;
        
        int yIndex = 0;
        int xIndex = 0;
        
        //标记当前往哪个方向查找
        boolean searchRight = true;
        boolean searchLeft = false;
        boolean searchDown = false;
        boolean searchUp = false;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(true) {
            result.add(matrix[yIndex][xIndex]);
            if(searchRight) {
                //往右搜索
                xIndex++;
            } else if(searchLeft) {
                //往左搜索
                xIndex--;
            } else if(searchDown) {
                //往下搜索
                yIndex++;
            } else if(searchUp) {
                //往上搜索
                yIndex--;
            } else {
                //NOT REACH
            }
            
            //当前xIndex的合法范围
            int legalMinXIndex = 0+left;
            int legalMaxXIndex = (xIndexLength-1)-right;
            
            //当前yIndex的合法范围
            int legalMinYIndex = 0+up;
            int legalMaxYIndex = (yIndexLength-1)-down;
            
            //判定有没有越界
            if(xIndex<legalMinXIndex || xIndex>legalMaxXIndex) {
                //x越界
                if(searchRight) {
                    searchRight = false;
                    searchDown = true;
                    yIndex++;
                    xIndex--;
                    up++;
                } else {
                    searchLeft = false;
                    searchUp = true;
                    yIndex--;
                    xIndex++;
                    down++;
                }
            } else if(yIndex<legalMinYIndex || yIndex>legalMaxYIndex) {
                //y越界
                if(searchDown) {
                    searchDown = false;
                    searchLeft = true;
                    yIndex--;
                    xIndex--;
                    right++;
                } else {
                    searchUp = false;
                    searchRight = true;
                    yIndex++;
                    xIndex++;
                    left++;
                }
            } else {
                //合法
            }
            
            //如果上面越界,那么调整以后,还是越界,那么表示以及访问结束了
            if((xIndex<legalMinXIndex || xIndex>legalMaxXIndex) || (yIndex<legalMinYIndex || yIndex>legalMaxYIndex)) {
                break;
            }
        }
        
        return result;
    }
}
