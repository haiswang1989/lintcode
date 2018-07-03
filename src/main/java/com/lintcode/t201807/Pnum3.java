package com.lintcode.t201807;

/**
 * 统计数字
 * 
 * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 * 
 * 例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月3日 下午2:50:12
 */
public class Pnum3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(digitCounts(1, 12));
    }
    
    /*
     * 
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public static int digitCounts(int k, int n) {
        return method_2(k, n);
    }
    
    //////////////比较蠢的版本,计算每一个数字中包含的K的个数(通过不停的取余和除法运算),然后进行累加/////////////
    public static int method_2(int k, int n) {
        int count = 0;
        for(int i=0; i<=n; i++) {
            count += count(k, i);
        }
        
        return count;
    }
    
    public static int count(int k, int digit) {
        int count = 0;
        while(true) {
            int d = digit % 10;
            if(d == k) {
                count++;
            } 
            
            digit /= 10;
            if(digit == 0) {
                break;
            }
        }
        return count;
    }

}
