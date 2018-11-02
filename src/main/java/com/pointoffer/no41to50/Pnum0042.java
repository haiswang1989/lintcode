package com.pointoffer.no41to50;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 和为S的两个数字
 * 
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * 对应每个测试案例，输出两个数，小的先输出。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 下午2:57:04
 */
public class Pnum0042 {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        Pnum0042 pnum0042_ = new Pnum0042();
        ArrayList<Integer> al = pnum0042_.FindNumbersWithSum(array, 9);
        System.out.println(al.toString());
    }
    
    public ArrayList<Integer> FindNumbersWithSum(int[] array,int sum) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : array) {
            map.put(i, sum-i);
        }
        
        ArrayList<Integer> aL = new ArrayList<>();
        for (int i : array) {
            int needInt = map.get(i);
            if(map.containsKey(needInt)) {
                aL.add(i);
                aL.add(needInt);
                return aL;
            }
        }
        
        return aL;
    }
}
