package com.pointoffer.no21to30;

import java.util.ArrayList;

/**
 * 
 * 最小的K个数
 * 
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月31日 下午3:29:47
 */
public class Pnum0029 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[] input = {4,5,1,6,2,7,3,8};
        
        Pnum0029 pnum0028 = new Pnum0029();
        ArrayList<Integer> ret = pnum0028.GetLeastNumbers_Solution(input, 4);
        System.out.println(ret.toString());
    }
    
    /**
     * 
     * TOPN问题
     * 
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if(null==input || 0==input.length || 0==k || input.length < k) {
            return new ArrayList<>();
        }
        
        int[] ret = new int[k];
        System.arraycopy(input, 0, ret, 0, k);
        
        adjsutHeap(ret);
        
        for(int i=k; i<input.length; i++) {
            if(input[i] < ret[0]) {
                ret[0] = input[i];
                adjsutHeap(ret);
            }
        }
        
        ArrayList<Integer> retList = new ArrayList<>();
        for (int num : ret) {
            retList.add(num);
        }
        
        return retList;
    }
    
    public void adjsutHeap(int[] ret) {
        int adjustIndex = ret.length / 2 - 1;
        for(int i=adjustIndex; i>=0; i--) {
            doAdjust(ret, i, ret.length);
        }
    }
    
    public void doAdjust(int[] ret, int adjustIndex, int length) {
        int temp = ret[adjustIndex];
        int leftChildIndex = 2 * adjustIndex + 1;
        
        for(int k=leftChildIndex; k<length; k=2*k+1) {
            int rightChildIndex = leftChildIndex + 1;
            if(rightChildIndex < length && ret[rightChildIndex] > ret[leftChildIndex]) {
                k = rightChildIndex;
            }
            
            if(ret[k] > temp) {
                ret[adjustIndex] = ret[k];
                adjustIndex = k;
            } else {
                break;
            }
            
            leftChildIndex = 2 * adjustIndex + 1;
        }
        
        ret[adjustIndex] = temp;
    }
}
