package com.pointoffer.no31to40;

import java.util.ArrayList;

/**
 * 
 * 丑数
 * 
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 上午9:41:53
 */
public class Pnum0033 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        
        Pnum0033 pnum0033_ = new Pnum0033();
        for(int i=0; i<=10; i++) {
            System.out.println(pnum0033_.GetUglyNumber_Solution(i));
        }
    }
    
    /**
     * 
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) {
            return 0;
        }
        
        ArrayList<Integer> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1);
        
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        
        for(int i=1; i<index; i++) {
            int nextUglyNumber = min(uglyNumbers.get(i2)*2, uglyNumbers.get(i3)*3, uglyNumbers.get(i5)*5);
            uglyNumbers.add(nextUglyNumber);
            
            while(uglyNumbers.get(i2) * 2 <= nextUglyNumber) {
                i2++;
            }
            
            while(uglyNumbers.get(i3) * 3 <= nextUglyNumber) {
                i3++;
            }
            
            while(uglyNumbers.get(i5) * 5 <= nextUglyNumber) {
                i5++;
            }
        }
        
        return uglyNumbers.get(index-1);
    }
    
    /**
     * 
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    
    /**
     * 大致思路
     * 就是将所有的丑数按照从小到大的排序,
     * 假设当前最大的丑数为unMax
     * 新的丑数肯定是已经找到的丑数分别与2,3,5的乘积的结果中大于unMax的最小值
     * 比如：
     * 当前的丑数列表是1,2,3 那么unMax = 3
     * 1,2,3分别于2,3,5的乘积为
     * 1*2 = 2
     * 1*3 = 3
     * 1*5 = 5
     * 2*2 = 4
     * 2*3 = 6
     * 2*5 = 10
     * 3*2 = 6
     * 3*3 = 9
     * 3*5 = 15
     * 这些乘积中大于3的最小值为4,所以下一个丑数就是4
     * 
     * 我的这个实现方式有个缺陷,每次2,3,5都需要与所有的丑数进行乘积
     * 
     * @param index
     * @return
     */
    /*
    public int GetUglyNumber_Solution(int index) {
        if(0 == index) {
            return 0;
        }
        
        ArrayList<Integer> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1);
        
        while(uglyNumbers.size() < index) {
            int currMax = uglyNumbers.get(uglyNumbers.size()-1);
            int maxMin = Integer.MAX_VALUE;
            for (Integer uglyNumber : uglyNumbers) {
                int un2 = uglyNumber * 2;
                int un3 = uglyNumber * 3;
                int un5 = uglyNumber * 5;
                
                if(un2 > currMax && un2 < maxMin) {
                    maxMin = un2;
                }
                
                if(un3 > currMax && un3 < maxMin) {
                    maxMin = un3;
                }
                
                if(un5 > currMax && un5 < maxMin) {
                    maxMin = un5;
                }
            }
            
            uglyNumbers.add(maxMin);
        }
        
        return uglyNumbers.get(index-1);
    }
    */
}
