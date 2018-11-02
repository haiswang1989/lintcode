package com.pointoffer.no1to10;

/**
 * 斐波那契数列
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：396378
 * 
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * 
 * 0,1,1,2,3,5,8....
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月29日 上午11:10:12
 */
public class Pnum0007 {

    public static void main(String[] args) {
        Pnum0007 pnum0007 = new Pnum0007();
        for(int i=0; i<10; i++) {
            System.out.print(pnum0007.Fibonacci(i) + ",");
        }
        
    }
    
    /**
     * 
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }
        
        int indexNBeforeBeforeValue = 0;
        int indexNBeforeVaue = 1;
        
        int indexNValue = 0;
        int index = 2;
        while(index++ <= n) {
            indexNValue = indexNBeforeVaue + indexNBeforeBeforeValue;
            indexNBeforeBeforeValue = indexNBeforeVaue;
            indexNBeforeVaue = indexNValue;
        }
        
        return indexNValue;
    }
}
