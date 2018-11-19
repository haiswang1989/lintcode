package com.pointoffer.no61to66;

import java.util.ArrayList;

/**
 * 
 * 数据流中的中位数
 * 
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法往数据流中插入数据，使用GetMedian()方法获取当前读取数据的中位数
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月6日 下午3:12:01
 */
public class Pnum0063 {
    
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int elementCount = 0;
    
    public static void main(String[] args) {
        
        Pnum0063 pnum0063_ = new Pnum0063();
        pnum0063_.Insert(1);
        System.out.println(pnum0063_.GetMedian());
        pnum0063_.Insert(3);
        System.out.println(pnum0063_.GetMedian());
        pnum0063_.Insert(2);
        System.out.println(pnum0063_.GetMedian());
        pnum0063_.Insert(5);
        System.out.println(pnum0063_.GetMedian());
        pnum0063_.Insert(4);
        System.out.println(pnum0063_.GetMedian());
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * 以下是我的解决方案
     * 基本思想：
     * INSERT
     * 插入排序,因为元素是一个一个加入的,所以时间复杂度是O(logN)
     * 
     * GET
     * 数组,时间复杂度是O(1)
     *
     */
    public void Insert(Integer num) {
        insertByBinarySearch(num);
        elementCount++;
    }
    
    public Double GetMedian() {
        if(elementCount == 0) {
            return null;
        }
        
        int middleIndex = elementCount / 2;
        if(elementCount % 2 == 0) { //偶数个元素
            return (arrayList.get(middleIndex-1) + arrayList.get(middleIndex)) / 2.0;
        } else { //奇数个元素
            return arrayList.get(middleIndex).doubleValue();
        }
    }
    
    public void insertByBinarySearch(int num) {
        int fromIndex = 0;
        int endIndex = arrayList.size() - 1;
        withRecursion(num, fromIndex, endIndex);
    }
    
    public void withRecursion(int num, int fromIndex, int endIndex) {
        if(fromIndex > endIndex) {
            arrayList.add(num);
            return;
        }
        
        int min = arrayList.get(fromIndex);
        int max = arrayList.get(endIndex);
        
        int middleIndex = (fromIndex + endIndex) / 2;  
        if(num <= min) {
            arrayList.add(fromIndex, num);
        } else if(num >= max) {
            arrayList.add(endIndex+1, num);
        } else {
            if(fromIndex + 1 == endIndex) {
                arrayList.add(endIndex, num);
            } else {
                int middle = arrayList.get(middleIndex);
                if(middle == num) {
                    arrayList.add(middleIndex, num);
                } else if(middle > num) {
                    withRecursion(num, fromIndex, middleIndex);
                } else {
                    withRecursion(num, middleIndex, endIndex);
                }
            }
        }
    }
}
