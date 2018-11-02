package com.pointoffer.no1to10;

/**
 * 
 * 变态跳台阶
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：241355
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 思路 
 * f(n)表示n个台阶的条法
 * 那么
 * 
 * f(n) 可以分解
 * 当第一次跳1阶,那么可以的条法为f(n-1)
 * 当第一次跳2阶,那么可以的条法为f(n-2)
 * 当第一次跳3阶,那么可以的条法为f(n-3)
 * ...
 * 则f(n) = f(n-1) + f(n-2) + f(n-3) + f(n-4) ... + f(1) + 1  (I)
 * 因为： 
 * f(n-1) = f(n-2) + f(n-3) + f(n-4) ... + f(1) + 1   (II)
 * 
 * (I) - (II)
 * 
 * f(n) - f(n-1) = f(n-1)
 * f(n) = f(n-1) + f(n-1)
 * f(n) = 2*f(n-1)
 * 
 * 则:
 * f(n) = 2 * f(n-1)
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月29日 上午11:23:25
 */
public class Pnum0009 {

    public static void main(String[] args) {
        Pnum0009 pnum0009 = new Pnum0009();
        for(int i=1; i<10; i++) {
            System.out.print(pnum0009.JumpFloorII(i) + ",");
        }
    }
    
    /**
     * 
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target == 1) {
            return 1;
        }
        
        int index = 2;
        int before = 1;
        while(index++ <= target) {
            before = 2 * before;
        }
        
        return before;
    }
}
