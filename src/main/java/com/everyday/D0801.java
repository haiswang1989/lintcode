package com.everyday;

import java.util.Arrays;

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月1日 上午8:11:13
 */
public class D0801 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {11,7,18,3,5,4,10,9};
        Fastsort0801 fastsort0801 = new Fastsort0801(arr);
        fastsort0801.sort();
        System.out.println(Arrays.toString(arr));
        
        int[] arr1 = {11,7,18,3,5,4,10,9};
        Heapsort0801 heapsort0801 = new Heapsort0801(arr1);
        heapsort0801.sort();
        System.out.println(Arrays.toString(arr1));
        
        int[] arrKLargest = {11,7,18,3,5,4,10,9,1,2,20,25,12,13,55,66,33,99,78,89,55};
        for(int i=1; i<=arrKLargest.length; i++) {
            int[] arrKLargest_1 = {11,7,18,3,5,4,10,9,1,2,20,25,12,13,55,66,33,99,78,89,55};
            KLargest0801 kLargestByFastsort = new KLargest0801(arrKLargest_1, i);
            System.out.print(kLargestByFastsort.kLargest() + ", ");
        }
        System.out.println();
        
        int[] arrForTopn = {11,7,18,3,5,4,10,9};
        Topn0801 topn = new Topn0801(arrForTopn, 5);
        int[] ret = topn.topn();
        System.out.println(Arrays.toString(ret));
    }
}

/**
 * 快排
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月1日 上午8:11:10
 */
class Fastsort0801 {
    
    private int[] arr;
    
    public Fastsort0801(int[] arrArgs) {
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
 * @date 2018年8月1日 上午9:36:50
 */
class Heapsort0801 {
    
    private int[] arr;
    
    public Heapsort0801(int[] arrArgs) {
        this.arr = arrArgs;
    }
    
    public void sort() {
        
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
        int leftChildIndex = 2 * adjustIndex + 1;
        
        for(int k=leftChildIndex; k<length; k = 2*k + 1) {
            int rightChildIndex = leftChildIndex + 1;
            if(rightChildIndex < length && arr[leftChildIndex] < arr[rightChildIndex]) {
                k = rightChildIndex;
            }
            
            if(arr[k] > temp) {
                arr[adjustIndex] = arr[k];
                adjustIndex = k;
            } else {
                break;
            }
            
            //调整leftChildIndex
            leftChildIndex = 2 * adjustIndex + 1;
        }
        
        arr[adjustIndex] = temp;
    }
    
    private void swap(int fromIndex, int toIndex) {
        int temp = arr[fromIndex];
        arr[fromIndex] = arr[toIndex];
        arr[toIndex] = temp;
    }
}

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月1日 上午9:45:28
 */
class KLargest0801 {
    
    private static final int FASTSORT_THRESHOLD = 10;
    
    private int[] arr;
    private int k;
    private int kIndex;
    
    public KLargest0801(int[] arrArgs, int kArgs) {
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
        if(baseIndex < kIndex) { //右半边
            return halfFastsort(baseIndex+1, endIndex);
        } else if(baseIndex > kIndex) { //左半边
            return halfFastsort(fromIndex, baseIndex-1);
        } else {
            return base;
        }
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
 * @date 2018年8月1日 上午10:12:27
 */
class Topn0801 {
    
    private int[] arr;
    private int n;
    
    public Topn0801(int[] arrArgs, int nArgs) {
        this.arr = arrArgs;
        this.n = nArgs;
    }
    
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
        int adjustIndex = ret.length / 2 - 1;
        for(int i=adjustIndex; i>=0; i--) {
            adjustHeap(ret, i, ret.length);
        }
    }
    
    private void adjustHeap(int[] ret, int adjustIndex, int length) {
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
