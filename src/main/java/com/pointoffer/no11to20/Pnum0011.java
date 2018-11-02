package com.pointoffer.no11to20;

/**
 * 
 * 二进制中1的个数
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：290098
 * 
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月29日 下午2:55:33
 */
public class Pnum0011 {

    public static void main(String[] args) {
        Pnum0011 pnum0011 = new Pnum0011();
        System.out.println(pnum0011.NumberOf1(5));
        
    }
    
    /**
     * n & (n - 1) 可以将n最右边的1变成0
     * 
     * 5 0101
     * 5-1=4 0100
     * 5 & 4 = 0100 //最右边的1变成0了
     * 
     * 6 0110
     * 6-1=5 0101
     * 6 & 5 = 0100 //最右边的1变成0了
     * 
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n=n & (n-1);
        }
        
        return count;
    }
}
