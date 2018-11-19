package com.pointoffer.no21to30;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 
 * 字符串的排列
 * 
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月31日 下午2:53:41
 */
public class Pnum0027 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "abc";
        Pnum0027 pnum0027_ = new Pnum0027();
        ArrayList<String> rets = pnum0027_.Permutation(str);
        System.out.println(rets);
    }
    
    public ArrayList<String> Permutation(String str) {
        if(null==str || "".equals(str)) {
            return new ArrayList<>();
        }
        
        //使用treeset,保证返回值的顺序
        TreeSet<String> rets = new TreeSet<>();
        char[] arr = str.toCharArray();
        withRecursion(arr, 0, arr.length, rets);
        return new ArrayList<>(rets);
    }
    
    /**
     * 思路：
     * 1:将第一个元素依次和后面的所有元素进行交换
     * 2:按住第一个元素保持不变,后面的元素再依次和他后面的元素进行交换(递归)
     * 3:直到最后一个元素
     *  
     * @param arr
     * @param index
     * @param size
     * @param rets
     */
    public void withRecursion(char[] arr, int index, int size, TreeSet<String> rets) {
        if(index + 1 == size) {
            rets.add(new String(arr));
            return;
        }
        
        for(int i=index; i<size; i++) {
            //这边交换完成以后
            swap(arr, index, i);
            withRecursion(arr, index + 1, size, rets);
            //这边需要还原
            swap(arr, index, i);
        }
    }
    
    public void swap(char[] arr, int index1, int index2) {
        char tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
