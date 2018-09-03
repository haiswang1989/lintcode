package com.everyday;

import java.util.Arrays;

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年6月26日 上午9:22:03
 */
public class D0625 {

    public static void main(String[] args) {
        int[] arrForHeapsort = {11,7,18,3,5,4,10,9};
        Heapsort0625 heapsort = new Heapsort0625(arrForHeapsort);
        heapsort.dosort();
        System.out.println(Arrays.toString(arrForHeapsort));
        
        int[] arrForTopn = {11,7,18,3,5,4,10,9};
        Topn0626 topn = new Topn0626(arrForTopn, 5);
        int[] ret = topn.topn();
        System.out.println(Arrays.toString(ret));
        
        int[] arrKLargest = {11,7,18,3,5,4,10,9,1,2,20,25,12,13,55,66,33,99,78,89,55};
        for(int i=1; i<=arrKLargest.length; i++) {
            int[] arrKLargest_1 = {11,7,18,3,5,4,10,9,1,2,20,25,12,13,55,66,33,99,78,89,55};
            KLargest0628 kLargestByFastsort = new KLargest0628(arrKLargest_1, i);
            System.out.print(kLargestByFastsort.kLargest() + ", ");
        }
        System.out.println();
    }

}

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年6月28日 上午8:39:27
 */
class KLargest0628 {
    
    private static final int FASTSORT_THRESHOLD = 10;
    
    private int[] arr;
    private int k;
    private int kIndex;
    
    public KLargest0628(int[] arrArgs, int kArgs) {
        this.arr = arrArgs;
        this.k = kArgs;
        this.kIndex = this.k - 1;
    }
    
    public int kLargest() {
        return halfFastsort(0, arr.length-1);
    }
    
    public int halfFastsort(int fromIndex, int endIndex) {
        if(endIndex - fromIndex <= FASTSORT_THRESHOLD) {
            fastsort(fromIndex, endIndex);
            return arr[kIndex];
        }
        
        int i = fromIndex;
        int j = endIndex;
        
        int baseIndex = i;
        int base = arr[baseIndex];
        
        while(i < j) {
            while(i < j && arr[i] > base) {
                i++;
            }
            
            if(i < j) {
                arr[baseIndex] = arr[i];
                baseIndex = i;
            }
            
            while(i < j && arr[j] <= base) {
                j--;
            }
            
            if(i < j) {
                arr[baseIndex] = arr[j];
                baseIndex = j;
            }
        }
                
        arr[baseIndex] = base;
        if(baseIndex == kIndex) {
            return base;
        } else if(baseIndex > kIndex) {
            return halfFastsort(fromIndex, baseIndex-1);
        } else {
            return halfFastsort(baseIndex+1, endIndex);
        }
    }
    
    /**
     * 
     * @param fromIndex
     * @param endIndex
     */
    private void fastsort(int fromIndex, int endIndex) {
        if(fromIndex < endIndex) {
            
            int i = fromIndex;
            int j = endIndex;
            
            int baseIndex = i;
            int base = arr[baseIndex];
            
            while(i < j) {
                while(i < j && arr[i] > base) {
                    i++;
                }
                
                if(i < j) {
                    arr[baseIndex] = arr[i];
                    baseIndex = i;
                }
                
                while(i < j && arr[j] <= base) {
                    j--;
                }
                
                if(i < j) {
                    arr[baseIndex] = arr[j];
                    baseIndex = j;
                }
            }
                    
            arr[baseIndex] = base;
            fastsort(fromIndex, baseIndex-1);
            fastsort(baseIndex+1, endIndex);
        }
    }
}

/**
 * 堆排序
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年6月25日 上午9:32:11
 */
class Heapsort0625 {
    
    private int[] arr;
    
    public Heapsort0625(int[] arrArgs) {
        this.arr = arrArgs;
    }
    
    public void dosort() {
    
        int length = arr.length;
        int adjustIndex = length / 2 - 1;
        
        for(int i=adjustIndex; i>=0; i--) {
            adjustHeap(i, length);
        }
        
        for(int j=length-1; j>=0; j--) {
            swap(0, j);
            adjustHeap(0, j);
        }
        
        
    }
    
    private void adjustHeap(int adjustIndex, int length) {
        
        int temp = arr[adjustIndex];
        int leftChildIndex = 2*adjustIndex + 1;
        
        for(int i=leftChildIndex; i<length; i=2*i+1) {
            int rightChildIndex = leftChildIndex + 1;
            
            if(rightChildIndex < length && arr[rightChildIndex] > arr[leftChildIndex]) {
                i = rightChildIndex;
            }
            
            if(arr[i] > temp) {
                arr[adjustIndex] = arr[i];
                adjustIndex = i;
            } else {
                break;
            }
            
            leftChildIndex = 2*adjustIndex + 1;
        }
        
        arr[adjustIndex] = temp;
    }
    
    private void swap(int swapIndex1, int swapIndex2) {
        int temp = arr[swapIndex1];
        arr[swapIndex1] = arr[swapIndex2];
        arr[swapIndex2] = temp;
    }
}

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年6月26日 上午9:22:36
 */
class Topn0626 {
    
    private int[] arr;
    private int n;
    
    public Topn0626(int[] arrArgs, int nArgs) {
        this.arr = arrArgs;
        this.n = nArgs;
    }
    
    /**
     * 
     * @return
     */
    public int[] topn() {
        
        int[] ret = new int[n];
        System.arraycopy(arr, 0, ret, 0, n);
        doAdjust(ret);
        
        for(int i=n; i<arr.length; i++) {
            if(arr[i] > ret[0]) {
                ret[0] = arr[i];
                doAdjust(ret);
            }
        }
        
        return ret;
    }
    
    private void doAdjust(int[] ret) {
        int length = ret.length;
        int adjustIndex = length / 2 - 1;
        for(int i=adjustIndex; i>=0; i--) {
            adjustHeap(ret, i, length);
        }
    }
    
    private void adjustHeap(int[] ret, int adjustIndex, int length) {
        int temp = ret[adjustIndex];
        int leftChildIndex = 2 * adjustIndex + 1;
        for(int k=leftChildIndex; k<length; k=2*k+1) {
            int rightChildIndex = leftChildIndex + 1;
            
            if(rightChildIndex < length && ret[rightChildIndex] < ret[leftChildIndex]) {
                k = rightChildIndex;
            }
            
            if(ret[k] < ret[adjustIndex]) {
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
