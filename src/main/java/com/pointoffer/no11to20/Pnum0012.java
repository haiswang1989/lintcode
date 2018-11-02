package com.pointoffer.no11to20;

/**
 * 
 * 数值的整数次方
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：299226
 * 
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月29日 下午3:58:17
 */
public class Pnum0012 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Pnum0012 pnum0012 = new Pnum0012();
        System.out.println(pnum0012.Power(2.0, -2));
    }
    
    public double Power(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        } else if(exponent == 1) {
            return base;
        } else if(exponent == -1) {
            return 1 / base;
        }
        
        //负数
        boolean isNagetive = false;
        long lExponent = exponent;
        if(exponent < 0) {
            isNagetive = true;
            lExponent *= -1L;
        }
        
        boolean isOdd = false;
        if(exponent % 2 != 0) {
            isOdd = true;
            exponent -= 1;
        }
        
        double result = withRecursion(base, lExponent);
        if(isOdd) {
            result *= base;
        }
        
        if(isNagetive) {
            result = 1 / result;
        }
        
        return result;
    }
    
    /**
     * 
     * @param base
     * @param exponent
     * @return
     */
    public double withRecursion(double base, long exponent) {
        if(exponent == 1) {
            return base;
        }
        
        exponent >>= 1;
        double halfBase = withRecursion(base, exponent);
        return halfBase * halfBase;
    }
}
