package com.everyday;

import java.util.Arrays;

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月13日 上午8:01:23
 */
public class D0813 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {11,7,18,3,5,4,10,9};
        Fastsort0813 fastsort = new Fastsort0813(arr);
        fastsort.sort();
        System.out.println(Arrays.toString(arr));
        
        int[] arr1 = {11,7,18,3,5,4,10,9};
        Heapsort0813 heapsort = new Heapsort0813(arr1);
        heapsort.sort();
        System.out.println(Arrays.toString(arr1));
        
        int[] arrForTopn = {11,7,18,3,5,4,10,9};
        Topn0813 topn = new Topn0813(arrForTopn, 5);
        int[] ret = topn.topn();
        System.out.println(Arrays.toString(ret));
        
        int[] arrKLargest = {11,7,18,3,5,4,10,9,1,2,20,25,12,13,55,66,33,99,78,89,55};
        for(int i=1; i<=arrKLargest.length; i++) {
            int[] arrKLargest_1 = {11,7,18,3,5,4,10,9,1,2,20,25,12,13,55,66,33,99,78,89,55};
            KLargest0813 kLargestByFastsort = new KLargest0813(arrKLargest_1, i);
            System.out.print(kLargestByFastsort.kLargest() + ", ");
        }
        System.out.println();
    }

}

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月13日 上午8:02:02
 */
class Fastsort0813 {
    
    private int[] arr;
    
    public Fastsort0813(int[] arrArgs) {
        this.arr = arrArgs;
    }
    
    public void sort() {
        fastsort(0, arr.length-1);
    }
    
    private void fastsort(int fromIndex, int endIndex) {
        if(fromIndex < endIndex) {
            int i = fromIndex;
            int j = endIndex;
            
            int baseIndex = i;
            int base = arr[baseIndex];
                    
            while(i < j) {
                while(i < j && arr[j] > base) {
                    j--;
                }
                
                if(i < j) {
                    arr[baseIndex] = arr[j];
                    baseIndex = j;
                }
                
                while(i < j && arr[i] <= base) {
                    i++;
                }
                
                if(i < j) {
                    arr[baseIndex] = arr[i];
                    baseIndex = i;
                }
            }
            
            arr[baseIndex] = base;
            fastsort(fromIndex, baseIndex-1);
            fastsort(baseIndex+1, endIndex);
        }
    }
}

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月13日 上午8:08:40
 */
class Heapsort0813 {
    private int[] arr;
    
    public Heapsort0813(int[] arrArgs) {
        this.arr = arrArgs;
    }
    
    public void sort() {
        int length = arr.length;
        int adjsutIndex = length / 2 - 1;
        for(int i=adjsutIndex; i>=0; i--) {
            adjustHeap(i, length);
        }
        
        for(int j=length-1; j>=0; j--) {
            swap(0, j);
            adjustHeap(0, j);
        }
    }
    
    private void adjustHeap(int adjustIndex, int length) {
        int temp = arr[adjustIndex];
        int leftChildIndex = 2 * adjustIndex + 1;
        
        for(int k=leftChildIndex; k<length; k=2*k+1) {
            int rightChildIndex = leftChildIndex + 1;
            if(rightChildIndex < length && arr[rightChildIndex] > arr[leftChildIndex]) {
                k = rightChildIndex;
            }
            
            if(arr[k] > temp) {
                arr[adjustIndex] = arr[k];
                adjustIndex = k;
            } else {
                break;
            }
            
            leftChildIndex = 2 * adjustIndex + 1;
        }
        
        arr[adjustIndex] = temp;
    }
    
    /**
     * 
     * @param index1
     * @param index2
     */
    private void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;; 
    }
}

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月13日 上午8:17:48
 */
class Topn0813 {
    
    private int[] arr;
    int n;
    
    public Topn0813(int[] arrArgs, int nArgs) {
        this.arr = arrArgs;
        this.n = nArgs;
    }
    
    public int[] topn() {
        int[] ret = new int[n];
        System.arraycopy(arr, 0, ret, 0, n);
        doAdjust(ret);
        for(int i=n; i<arr.length; i++) {
            if(ret[0] < arr[i]) {
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
    
    public void adjustHeap(int[] ret, int adjustIndex, int length) {
        int temp = ret[adjustIndex];
        int leftChildIndex = 2 * adjustIndex + 1;
        for(int k=leftChildIndex; k<length; k=2*k+1) {
            int rightChildIndex = leftChildIndex + 1;
            if(rightChildIndex < length && ret[rightChildIndex] < ret[k]) {
                k = rightChildIndex;
            }
            
            if(ret[k] < temp) {
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

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月13日 上午8:53:07
 */
class KLargest0813 {
    
    private static final int FASTSORT_THRESHOLD = 10;
    
    private int[] arr;
    private int k;
    private int kIndex;
    
    public KLargest0813(int[] arrArgs, int kArgs) {
        this.arr = arrArgs;
        this.k = kArgs;
        this.kIndex = this.k - 1;
    }
    
    public int kLargest() {
        return halfFastsort(0, arr.length-1);
    }
    
    private int halfFastsort(int fromIndex, int endIndex) {
        if(endIndex - fromIndex <= FASTSORT_THRESHOLD) {
            fastsort(fromIndex, endIndex);
            return arr[kIndex];
        }
        
        int i = fromIndex;
        int j = endIndex;
        
        int baseIndex = i;
        int base = arr[baseIndex];
        
        while(i < j) {
            while(i < j && arr[j] > base) {
                j--;
            }
            
            if(i < j) {
                arr[baseIndex] = arr[j];
                baseIndex = j;
            }
            
            while(i < j && arr[i] <= base) {
                i++;
            }
            
            if(i < j) {
                arr[baseIndex] = arr[i];
                baseIndex = i;
            }
        }
        
        arr[baseIndex] = base;
        if(baseIndex == kIndex) {
            return base;
        } else if(kIndex < baseIndex) {
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
                while(i < j && arr[j] > base) {
                    j--;
                }
                
                if(i < j) {
                    arr[baseIndex] = arr[j];
                    baseIndex = j;
                }
                
                while(i < j && arr[i] <= base) {
                    i++;
                }
                
                if(i < j) {
                    arr[baseIndex] = arr[i];
                    baseIndex = i;
                }
            }
            
            arr[baseIndex] = base;
            fastsort(fromIndex, baseIndex-1);
            fastsort(baseIndex+1, endIndex);
        }
    }
}
