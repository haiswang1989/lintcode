package com.pointoffer.no51to60;

import java.util.Arrays;

/**
 * 构建乘积数组
 * 
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月2日 下午2:55:57
 */
public class Pnum0051 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[] A = {2,3,4,5,6}; 
        Pnum0051 pnum0051 = new Pnum0051();
        int[] b = pnum0051.multiply(A);
        System.out.println(Arrays.toString(b));
    }
    
    /**
     * 
     * 从前往后构建前向乘积数组C
     * 从后往前构建后向乘积数组D
     * 
     * 然后通过C和D来构建B
     * 
     * 如 
     * A = {1,2,3};
     * 
     * C = {1,2,6}
     * D = {3,6,6};
     * 
     * B = {};
     * 
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        if(null==A || 0==A.length) {
            return A;
        }
        
        int length = A.length;
        
        //前向乘积数组
        int[] C = new int[length];
        C[0] = 1; //第一个补充0
        for(int i=1; i<length; i++) {
            C[i] = C[i-1] * A[i-1];
        }
        
        //后向乘积数组
        int[] D = new int[length];
        D[0] = 1;
        for(int i=1; i<length; i++) {
            D[i] = D[i-1] * A[length-i];
        }
        
        
        int[] B = new int[length];
        for(int i=0; i<length; i++) {
            B[i] = C[i] * D[length - 1 -i];
        }
        
        return B;
    }
}
