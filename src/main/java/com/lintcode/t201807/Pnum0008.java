package com.lintcode.t201807;

import java.util.Arrays;

/**
 * 旋转字符串
 * 
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 * 
 * 对于字符串 "abcdefg"
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * 
 * 在数组上原地旋转，使用O(1)的额外空间
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月4日 上午11:11:15
 */
public class Pnum0008 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pnum0008 pnum8 = new Pnum0008();
        char[] str = {'a','b','c','d','e','f','g'};
        pnum8.rotateString(str, 3);
        System.out.println(Arrays.toString(str));
    }
    
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        int length = str.length;
        if(0 == length) {
            return;
        }
        offset %= length;
        if(0 == offset) {
            return;
        }
        
        swap(str, 0, length-1);
        swap(str, 0, offset-1);
        swap(str, offset, length-1);
    }
    
    public void swap(char[] str, int fromIndex, int endIndex) {
        for(int i=fromIndex, j=endIndex; i<j; i++,j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}
