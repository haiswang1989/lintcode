package com.pointoffer.no1to10;

/**
 * 矩形覆盖
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：217354
 * 
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * 思路：
 * f(n)表示2*N的大矩形覆盖的方法总数
 * f(1) = 1
 * f(2) = 2
 * f(3) = 3
 * f(4) = 5
 * 看规律是
 * f(n) = f(n-2) + f(n-1);
 * 
 * 分析:
 * f(n) 可以拆分 2*1的小矩形横过来放 那么该种方式的有 f(n-2)种方式 
 * 2*1的小矩形竖着放,那么该种方式有f(n-1)种方式
 * 
 * 所以f(n) = f(n-1) + f(n-2)就很明显了
 * 
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月29日 下午2:06:34
 */
public class Pnum0010 {

    public static void main(String[] args) {
        
        Pnum0010 pnum0010 = new Pnum0010();
        
        for(int i=0; i<10; i++) {
            System.out.print(pnum0010.RectCover(i) + ",");
        }
    }
    
    /**
     * 
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target == 0) {
            return 0;
        } else if(target == 1) {
            return 1;
        } else if(target == 2) {
            return 2;
        }
        
        int[] array = new int[target + 1];
        array[1] = 1;
        array[2] = 2;
        
        for(int i=3; i<=target; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        
        return array[target];
    }

}
