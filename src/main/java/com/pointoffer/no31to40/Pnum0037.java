package com.pointoffer.no31to40;

/**
 * 数字在排序数组中出现的次数
 * 
 * 统计一个数字在排序数组中出现的次数。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 上午10:42:11
 */
public class Pnum0037 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[] array = {1,1,1,2,2,2,2,2,2,4,4,4,5,5,6};
        Pnum0037 pnum0036 = new Pnum0037();
        int count = pnum0036.GetNumberOfK(array, 2);
        System.out.println("cnt : " + count);
    }
    
    public int GetNumberOfK(int[] array , int k) {
        if(null==array || 0==array.length) {
            return 0;
        }
        
        int index = binarySearch(array, k);
        if(index == -1) {
            return 0;
        }
        
        //beforeCnt
        int beforeCnt = 0;
        for(int i=index-1; i>=0; i--) {
            if(array[i] == k) {
                beforeCnt++;
            }
        }
        
        //afterCnt
        int afterCnt = 0;
        for(int i=index; i<array.length; i++) {
            if(array[i] == k) {
                beforeCnt++;
            }
        }
        
        return beforeCnt + afterCnt;
    }
    
    /**
     * 
     * @param array
     * @param fromIndex
     * @param endIndex
     * @return
     */
    public int binarySearch(int[] array, int k) {
        int fromIndex = 0;
        int endIndex = array.length - 1;
        while(true) {
            int middleIndex = (fromIndex + endIndex) / 2;
            if(array[middleIndex] == k) {
                return middleIndex;
            } else if(array[middleIndex] > k) {
                endIndex = middleIndex;
            } else {
                fromIndex = middleIndex;
            }
            
            if(fromIndex + 1 == endIndex) {
                if(array[fromIndex] == k) {
                    return fromIndex;
                } else if(array[endIndex] == k) {
                    return endIndex;
                } else {
                    return -1;
                }
            } else if(fromIndex == endIndex) {
                return -1;
            }
        }
    }
    
}
