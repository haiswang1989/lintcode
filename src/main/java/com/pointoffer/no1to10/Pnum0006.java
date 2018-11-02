package com.pointoffer.no1to10;

/**
 * 旋转数组的最小数字
 * 
 * 时间限制：3秒 空间限制：32768K 热度指数：430080
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月19日 上午9:47:52
 */
public class Pnum0006 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[] array = {3,4,5,1,2};
        Pnum0006 pnum0006 = new Pnum0006();
        int min = pnum0006.minNumberInRotateArray(array);
        System.out.println(min);
    }
    
    /**
     * 
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        int length = 0;
        if(null==array || 0==(length=array.length)) {
            return 0;
        }
        
        int fromIndex = 0;
        int endIndex = length - 1;
        
        return byBinarySearch(fromIndex, endIndex, array);
    }
    
    /**
     * 二分查找
     * @param fromIndex
     * @param endIndex
     * @param array
     * @return
     */
    public int byBinarySearch(int fromIndex, int endIndex, int[] array) {
        if(fromIndex == endIndex) {
            return array[fromIndex];
        } else if(fromIndex + 1 == endIndex) {
            return array[fromIndex] > array[endIndex] ? array[endIndex] : array[fromIndex];
        }
        
        int middleIndex = (fromIndex + endIndex) / 2;
        if(array[middleIndex] >= array[fromIndex]) {
            fromIndex = middleIndex;
        } else {
            endIndex = middleIndex;
        }
        
        return byBinarySearch(fromIndex, endIndex, array);
    }
}
