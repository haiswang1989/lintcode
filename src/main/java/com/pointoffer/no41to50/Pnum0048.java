package com.pointoffer.no41to50;

/**
 * 
 * 不用加减乘除做加法
 * 
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月2日 上午10:58:51
 */
public class Pnum0048 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Pnum0048 pnum0048 = new Pnum0048();
        int sum = pnum0048.Add(1, 2);
        System.out.println(sum);
        
    }
    
    /**
     * 
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        if(0 == num1) {
            return num2;
        } else if(0 == num2) {
            return num1;
        }
        
        while((num1 & num2) != 0) {
            int tmp = num1 & num2;
            num1 = num1 ^ num2;
            num2 = tmp << 1;
        }
        
        return num1 ^ num2;
    }

}
