package com.lintcode.t201807;

/**
 * 第k大元素
 * 
 * 在数组中找到第k大的元素
 * 
 * 给出数组 [9,3,2,4,8]，第三大的元素是 4
 * 
 * 要求时间复杂度为O(n)，空间复杂度为O(1)
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月3日 下午3:19:32
 */
public class Pnum0005 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pnum0005 p = new Pnum0005();
        int[] nums = {9,3,2,4,8};
        int k = 3;
        System.out.println(p.kthLargestElement(k, nums));
    }
    
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        int fromIndex = 0;
        int endIndex = nums.length - 1;
        return halfFastsort(k, fromIndex, endIndex, nums);
    }
    
    /**
     * 
     * @param fromIndex
     * @param endIndex
     * @param nums
     */
    private int halfFastsort(int k, int fromIndex, int endIndex, int[] nums) {
        int kIndex = k - 1;
        if(endIndex - fromIndex <= 10) {
            fastsort(nums, fromIndex, endIndex);
            return nums[kIndex];
        }
        
        int i = fromIndex;
        int j = endIndex;
        int baseIndex = i;
        int base = nums[baseIndex];
        
        while(i < j) {
            while(i < j && nums[i] > base) {
                i++;
            }
            
            if(i < j) {
                nums[baseIndex] = nums[i];
                baseIndex = i;
            }
            
            while(i < j && nums[j] <= base) {
                j--;
            }
            
            if(i < j) {
                nums[baseIndex] = nums[j];
                baseIndex = j;
            }
        }
        
        nums[baseIndex] = base;
        if(kIndex == baseIndex) {
            return base;
        } else if(kIndex < baseIndex) { //左半边
            return halfFastsort(k, fromIndex, baseIndex-1, nums);
        } else {
            return halfFastsort(k, baseIndex+1, endIndex, nums);
        }
    }
    
    /**
     * 快速排序
     * @param nums
     * @param fromIndex
     * @param endIndex
     */
    private void fastsort(int[] nums, int fromIndex, int endIndex) {
        if(fromIndex < endIndex) {
            int i = fromIndex;
            int j = endIndex;
            int baseIndex = i;
            int base = nums[baseIndex];
            
            while(i < j) {
                while(i < j && nums[i] > base) {
                    i++;
                }
                
                if(i < j) {
                    nums[baseIndex] = nums[i];
                    baseIndex = i;
                }
                
                while(i < j && nums[j] <= base) {
                    j--;
                }
                
                if(i < j) {
                    nums[baseIndex] = nums[j];
                    baseIndex = j;
                }
            }
            
            nums[baseIndex] = base;
            fastsort(nums, fromIndex, baseIndex-1);
            fastsort(nums, baseIndex+1, endIndex);
        }
    }
}
