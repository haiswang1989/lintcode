package com.pointoffer.no1to10;

/**
 * 跳台阶
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：306329
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 
 * dp(1) = 1;
 * dp(2) = 2;
 * dp(3) = 3;
 * dp(4) = 5;
 * 
 * dp(n) = dp(n-1) + dp(n-2)
 * 
 * 斐波拉切数列
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月29日 上午11:18:04
 */
public class Pnum0008 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public int JumpFloor(int target) {
        if(target == 1) {
            return 1;
        } else if(target == 2) {
            return 2;
        }
        
        int indexNBeforeBeforeValue = 1;
        int indexNBeforeVaue = 2;
        
        int indexNValue = 0;
        int index = 3;
        while(index++ <= target) {
            indexNValue = indexNBeforeVaue + indexNBeforeBeforeValue;
            indexNBeforeBeforeValue = indexNBeforeVaue;
            indexNBeforeVaue = indexNValue;
        }
        
        return indexNValue;
    }
}
