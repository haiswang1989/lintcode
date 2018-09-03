package com.everyday;

import java.util.Arrays;

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月27日 下午4:47:53
 */
public class D0827 {

    public static void main(String[] args) {
        
        int[] arr = {11,7,18,3,5,4,10,9};
        Fastsort0827 fastsort = new Fastsort0827(arr);
        fastsort.sort();
        System.out.println(Arrays.toString(arr));
        
        int[] arr1 = {11,7,18,3,5,4,10,9};
        Heapsort0827 heapsort = new Heapsort0827(arr1);
        heapsort.sort();
        System.out.println(Arrays.toString(arr1));
        
        int[] arrForTopn = {11,7,18,3,5,4,10,9};
        Topn0827 topn = new Topn0827(arrForTopn, 5);
        int[] ret = topn.topn();
        System.out.println(Arrays.toString(ret));
        
        int[] arrKLargest = {11,7,18,3,5,4,10,9,1,2,20,25,12,13,55,66,33,99,78,89,55};
        for(int i=1; i<=arrKLargest.length; i++) {
            int[] arrKLargest_1 = {11,7,18,3,5,4,10,9,1,2,20,25,12,13,55,66,33,99,78,89,55};
            Klargest0827 kLargestByFastsort = new Klargest0827(arrKLargest_1, i);
            System.out.print(kLargestByFastsort.kLargest() + ", ");
        }
        System.out.println();
    }
}

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月27日 下午5:17:48
 */
class Fastsort0827 {
    
    private int[] arr;
    
    public Fastsort0827(int[] arrArgs) {
        this.arr = arrArgs;
    }
    
    public void sort() {
        fastsort(0, arr.length - 1);
    }
    
    public void fastsort(int fromIndex, int endIndex) {
        
        if(fromIndex < endIndex) {
            int i = fromIndex;
            int j = endIndex;
            
            int baseIndex = i;
            int base = arr[baseIndex];
            
            while(i < j) {
                
                while(i < j && arr[j] >= base) {
                    j--;
                }
                
                if(i < j) {
                    arr[baseIndex] = arr[j];
                    baseIndex = j;
                }
                
                while(i < j && arr[i] < base) {
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
 * @date 2018年8月27日 下午5:17:53
 */
class Heapsort0827 {
    
    private int[] arr;
    
    public Heapsort0827(int[] arrArgs) {
        this.arr = arrArgs;
    }
    
    public void sort() {
        int length = arr.length;
        int adjustIndex = length / 2 - 1;
        for(int i=adjustIndex; i>=0; i--) {
            adjustHeap(i, length);
        }
        
        for(int i=length-1; i>=0; i--) {
            swap(0, i);
            adjustHeap(0, i);
        }
    }
    
    /**
     * 
     * @param adjustIndex
     * @param length
     */
    private void adjustHeap(int adjustIndex, int length) {
        int base = arr[adjustIndex];
        int leftChildIndex = 2*adjustIndex + 1;
        for(int k=leftChildIndex; k<length; k=2*k+1) {
            int rightChildIndex = leftChildIndex + 1;
            if(rightChildIndex < length && arr[rightChildIndex] > arr[leftChildIndex]) {
                k = rightChildIndex;
            }
            
            if(arr[k] > base) {
                //从下往上调整
                arr[adjustIndex] = arr[k];
                adjustIndex = k;
            } else {
                break;
            }
            
            leftChildIndex = 2*adjustIndex + 1;
        }
        
        arr[adjustIndex] = base;
    }
    
    private void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月28日 上午9:34:13
 */
class Topn0827 {
    
    private int[] arr;
    private int n;
    
    public Topn0827(int[] arrArgs, int nArgs) {
        this.arr = arrArgs;
        this.n = nArgs;
    }
    
    public int[] topn() {
        int[] ret = new int[n];
        System.arraycopy(arr, 0, ret, 0, n);
        doAdjust(ret);
        
        for(int i=n; i<arr.length; ++i) {
            if(arr[i] > ret[0]) {
                ret[0] = arr[i];
                doAdjust(ret);
            }
        }
        
        return ret;
    }
    
    public void doAdjust(int[] ret) {
        int length = ret.length;
        int adjustIndex = length / 2 - 1;
        
        for(int i=adjustIndex; i>=0; --i) {
            adjustHeap(ret, i, length);
        }
    }
    
    public void adjustHeap(int[] ret, int adjustIndex, int length) {
        int temp = ret[adjustIndex];
        
        int leftChildIndex = 2 * adjustIndex + 1;
        for(int k=leftChildIndex; k<length; k=2*k+1) {
            int rightChildIndex = leftChildIndex + 1;
            if(rightChildIndex<length && ret[rightChildIndex] < ret[leftChildIndex]) {
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
 * @date 2018年8月28日 上午9:53:45
 */
class Klargest0827 {
    
    private static final int FASTSORT_THRESHOLD = 10;
    
    private int[] arr;
    private int k;
    private int kIndex;
    
    public Klargest0827(int[] arrArgs, int kArgs) {
        this.arr = arrArgs;
        this.k = kArgs;
        this.kIndex = this.k - 1;
    }
    
    public int kLargest() {
        return halfFastsort(0, arr.length-1);
    }
    
    /**
     * 
     * @param fromIndex
     * @param endIndex
     * @return
     */
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
    public void fastsort(int fromIndex, int endIndex) {
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