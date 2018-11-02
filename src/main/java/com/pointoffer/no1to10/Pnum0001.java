package com.pointoffer.no1to10;

/**
 * 二维数组中的查找
 * 
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：929077
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月17日 下午5:36:21
 */
public class Pnum0001 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[][] a = {{1,2,8,9},{4,7,10,13}};
        
        Pnum0001 Pnum0001 = new Pnum0001();
        System.out.println(Pnum0001.Find_2(7, a));
        
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //网上看到的解决方案,同时使用了列递增和行递增的特性
    //思路:从二维数组的右上角的元素开始查询
    //如果该元素大于tagret,那么该列可以忽略
    //如果该元素小于target,那么该行可以忽略
    /**
     * 
     * @param target
     * @param array
     * @return
     */
    public boolean Find_2(int target, int [][] array) {
        if(null == array || 0 == array.length || 0 == array[0].length) {
            return false;
        }
        
        //有多少行
        int y = array.length;
        //每行有多少元素
        int x = array[0].length;
        
        int xIndex = x - 1;
        int yIndex = 0;
        while(xIndex>=0 && yIndex<y) {
            int upperRightEle = array[yIndex][xIndex]; 
            if(upperRightEle == target) {
                return true;
            } else if(upperRightEle > target) {
                //忽略列
                xIndex = xIndex - 1;
            } else {
                //忽略行
                yIndex = yIndex + 1;
            }
        }
        
        return false;
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //只使用了每行的递增这个特性,没有使用每列递增的特性
    //每行check最小和最大值,然后使用递归查找
    
    /**
     * 
     * @param target
     * @param array
     * @return
     */
    public boolean Find_1(int target, int [][] array) {
        if(null == array || 0 == array.length || 0 == array[0].length) {
            return false;
        }
        
        //有多少行
        int y = array.length;
        //每行有多少元素
        int x = array[0].length;
        
        for(int yIndex = 0; yIndex < y; yIndex++) {
            int begin = array[yIndex][0];
            int end = array[yIndex][x-1];
            if(target >= begin && target<=end) {
                if(binarySearch(target, array[yIndex], 0, x-1)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * 
     * @param target
     * @param array
     * @param fromIndex
     * @param endIndex
     * @return
     */
    public boolean binarySearch(int target, int[] array, int fromIndex, int endIndex) {
        if(array[fromIndex] == target || array[endIndex] == target) {
            return true;
        }
        
        if(fromIndex == endIndex || fromIndex+1 == endIndex) {
            return false;
        }
        
        int middleIndex = (fromIndex + endIndex) / 2;
        if(array[middleIndex] == target) {
            return true;
        } else if(array[middleIndex] > target) {
            return binarySearch(target, array, fromIndex, middleIndex);
        } else {
            return binarySearch(target, array, middleIndex, endIndex);
        }
    }
}
