package com.pointoffer.no21to30;

/**
 * 
 * 数组中出现次数超过一半的数字
 * 
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月31日 下午3:02:49
 */
public class Pnum0028 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1,2,3,2,5,4,2};
        Pnum0028 pnum0027 = new Pnum0028();
        int ret = pnum0027.MoreThanHalfNum_Solution(array);
        System.out.println(ret);
    }
    
    /**
     * 
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if(null==array || 0==array.length) {
            return 0;
        }
        
        int targetNum = array[0];
        int targetNumCnt = 1;
        
        for(int i=1; i<array.length; i++) {
            if(targetNum == 0) {
                targetNum = array[i];
                targetNumCnt = 1;
            } else {
                if(array[i] == targetNum) {
                    targetNumCnt++;
                } else {
                    if(--targetNumCnt == 0) {
                        targetNum = 0;
                    }
                }
            }
        }
        
        if(targetNum == 0) {
            return 0;
        }
        
        //最后再check一下,因为如果这样的数可能不存在
        int targetNumAllCnt = 0;
        for (int i : array) {
            if(targetNum == i) {
                targetNumAllCnt++;
            }
        }
        
        if(targetNumAllCnt > array.length / 2) {
            return targetNum;
        }
        
        return 0;
    }
    
    /**
     * 如果一定存在,那么可以用如下方式实现
     * 如果不一定存在,那么下面的方式就不行
     */
    /*
    public int MoreThanHalfNum_Solution(int[] array) {
        if(null==array || 0==array.length) {
            return 0;
        }
        
        int targetNum = array[0];
        int targetNumCnt = 1;
        
        for(int i=1; i<array.length; i++) {
            if(targetNum == 0) {
                targetNum = array[i];
                targetNumCnt = 1;
            } else {
                if(array[i] == targetNum) {
                    targetNumCnt++;
                } else {
                    if(--targetNumCnt == 0) {
                        targetNum = 0;
                    }
                }
            }
        }
        
        return targetNum;
    }
    */
}
