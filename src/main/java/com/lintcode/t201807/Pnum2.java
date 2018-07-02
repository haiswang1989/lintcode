package com.lintcode.t201807;

/**
 * 2. 尾部的零
 * 
 * 设计一个算法，计算出n阶乘中尾部零的个数
 * 
 * 11! = 39916800
 * 
 * O(logN)的时间复杂度
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月2日 上午9:59:15
 */
public class Pnum2 {

    public static void main(String[] args) {
        System.out.println(trailingZeros(25));
    }
    
    /**
     * 
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public static long trailingZeros(long n) {
        long zeroCnt = 0;
        while(n > 0) {
            zeroCnt += n / 5;
            n /= 5;
        }
        
        return zeroCnt;
    }

}
