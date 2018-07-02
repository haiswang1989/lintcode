package com.lintcode.t201807;

/**
 * 
 * 1. A + B 问题
 * 
 * 如果 a=1 并且 b=2，返回3
 * 
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月2日 上午9:46:56
 */
public class Pnum1 {

    public static void main(String[] args) {
        int a = 3; 
        int b = 4;
        System.out.println(aplusb(a, b));
    }
    
    /**
     * 
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b 
     */
    public static int aplusb(int a, int b) {
        // write your code here
        while(true) {
            int temp1 = a & b;
            if(temp1 == 0) {
                return a | b;
            } else {
                a = a ^ b;
                b = temp1 << 1;
            }
        }
    }
}
