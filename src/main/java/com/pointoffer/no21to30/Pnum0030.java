package com.pointoffer.no21to30;

/**
 * 
 * 连续子数组的最大和
 * 
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月31日 下午3:48:03
 */
public class Pnum0030 {

    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        
        Pnum0030 pnum0029 = new Pnum0030();
        pnum0029.FindGreatestSumOfSubArray(array);
    }
    
    public int FindGreatestSumOfSubArray(int[] array) {
        if(null==array || 0==array.length) {
            return 0;
        }
        
        //历史的最大值,以及最大值的开始和结束索引
        int maxFromIndex = -1;
        int maxEndIndex = -1;
        int max = Integer.MIN_VALUE;
        
        //当前的最大值,以及当前最大值的开始和结束索引
        int currFromIndex = -1;
        int currEndIndex = -1;
        int currMax = Integer.MIN_VALUE;
        
        //当前和
        int sum = 0;
        
        for(int i=0; i<array.length; i++) {
            if(currFromIndex == -1) {
                currFromIndex = i;
                currEndIndex = i;
            }
            
            sum += array[i];
            if(sum < 0) {
                if(sum > currMax) {
                    currMax = sum;
                }
                
                if(currMax > max) {
                    maxFromIndex = currFromIndex;
                    maxEndIndex = currEndIndex;
                    max = currMax;
                } 
                
                sum = 0;
                currFromIndex = -1;
                currEndIndex = -1;
                currMax = Integer.MIN_VALUE;
            } else {
                if(sum > currMax) {
                    currEndIndex = i;
                    currMax = sum;
                }
            }
        }
        
        if(max > currMax) {
            System.out.println(maxFromIndex + ":" + maxEndIndex + ":" + max);
        } else {
            System.out.println(currFromIndex + ":" + currEndIndex + ":" + currMax);
        }
        
        return max > currMax ? max : currMax;
    }
}
