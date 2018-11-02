package com.pointoffer.no31to40;

import java.util.LinkedList;
import java.util.List;

/**
 * 数组中只出现一次的数字
 * 
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 上午11:42:30
 */
public class Pnum0040 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1,2,2,3,3,4,4,5,5,6,7,7,8,8};
        
        Pnum0040 pnum0040 = new Pnum0040();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        pnum0040.FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0] + " : " + num2[0]);
    }
    
    /**
     * 这个解决思路技巧性很强
     * 
     * 如果数组中只有一个元素是只出现一次,其他的元素都是出现偶数次,那么这就好办了,所有元素异或最后的值就是出现一次的元素
     * 
     * 这样的题目第一个想到的就是异或运算
     * 
     * 但是这个题目中表明有两个元素是指出现一次,那么就需要把两个不一样的元素拆分到不同的数组中,然后确保同一个元素会被分配
     * 到同一个数组中,那么分两个数组做就ok了
     * 
     * 第一次遍历,将所有的元素进行异或,那么最终的结果就是两个不一样的元素进行异或的结果
     * 然后分析该结果,找出该结果在他的二进制表达中从右往左 第一次出现1的索引
     * 该位置的值肯定时一个数值是1另一个数是0  
     * 那么以该特征为分界线 将数值分成两份  然后分别做异或
     * 
     * 
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array,int[] num1 , int[] num2) {
        if(null==array || 0==array.length) {
            return;
        }
        
        int xor = array[0];
        for (int i=1; i<array.length; i++) {
            xor ^= array[i];
        }
        
        int index = binaryFirstOneIndex(xor);
        
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        for(int i=0; i<array.length; i++) {
            if(binaryIndexIsOne(array[i], index)) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }
        
        xor = 0;
        for (Integer i : list1) {
            xor ^= i;
        }
        num1[0] = xor;
        
        
        xor = 0;
        for (Integer i : list2) {
            xor ^= i;
        }
        num2[0] = xor;
    }
    
    /**
     * 找到指定数的二进制从右往左第一个为1的索引
     * 
     * 0001 -> 1
     * 0010 -> 2
     * 0100 -> 3
     * 
     * @param target
     * @return
     */
    public int binaryFirstOneIndex(int target) {
        int index = 1;
        while((target & 1) == 0) {
            target = target >> 1;
            index++;
        }
        
        return index;
    }
    
    /**
     * 找到指定数的二进制从右往第index的数是不是1
     * 
     * @param target
     * @param index
     * @return
     */
    public boolean binaryIndexIsOne(int target, int index) {
        return ((target >> (index-1)) & 1) == 1 ? true : false;
    }
}
