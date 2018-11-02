package com.pointoffer.no11to20;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：350005
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * 如果要求在原数组上操作,不允许创建新的数组的情况下用我的方式
 * 如果可以创建新的数组,那么就会方便很多
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月29日 下午4:29:41
 */
public class Pnum0013 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {2,4,6,1,3,5,7};
        
        Pnum0013 pnum0013 = new Pnum0013();
        pnum0013.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
    
    /**
     * 
     * @param array
     */
    public void reOrderArray(int[] array) {
        if(null == array || 0 == array.length) {
            return;
        }
        int length = array.length;
        int swapCnt = 0;
        for(int i=0; i<length;) {
            if(i + swapCnt == length) {
                break;
            }
            
            if(isEven(array[i])) { //如果遇到了偶数,那么会进行移动,这个时候i就不需要累加了
                int temp = array[i];
                System.arraycopy(array, i+1, array, i, length - i - 1);
                array[length-1] = temp;
                swapCnt++;
            } else {
                i++;
            }
        }
    }
    
    /**
     * 
     * @param target
     * @return
     */
    public boolean isEven(int target) {
        return target % 2 == 0;
    }
}
