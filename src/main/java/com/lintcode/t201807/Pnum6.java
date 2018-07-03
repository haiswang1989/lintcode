package com.lintcode.t201807;

import java.util.Arrays;

/**
 * 合并排序数组 II
 * 
 * 合并两个排序的整数数组A和B变成一个新的数组。
 * 
 * 给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
 * 
 * 你能否优化你的算法，如果其中一个数组很大而另一个数组很小？
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月3日 下午3:42:32
 */
public class Pnum6 {
    
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[] B = {2,4,5,6};
        Pnum6 p = new Pnum6();
        System.out.println(Arrays.toString(p.mergeSortedArray(A, B)));
    }
    
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if(null==A || 0==A.length) {
            return B;
        } else if(null==B || 0==B.length) {
            return A;
        }
        
        int newAryLength = A.length + B.length;
        int[] ret = new int[newAryLength];
        
        int aIndex=0,bIndex=0;
        int retIndex = 0;
        for(; aIndex<A.length && bIndex<B.length; ) {
            if(A[aIndex] < B[bIndex]) {
                ret[retIndex++] = A[aIndex++];
            } else {
                ret[retIndex++] = B[bIndex++];
            }
        }
        
        if(aIndex < A.length) { //B全部取完了
            System.arraycopy(A, aIndex, ret, retIndex, A.length - aIndex);
        } else { //A全部取完了
            System.arraycopy(B, bIndex, ret, retIndex, B.length - bIndex);
        }
        
        return ret;
    }
}
