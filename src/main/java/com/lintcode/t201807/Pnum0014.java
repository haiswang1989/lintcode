package com.lintcode.t201807;

/**
 * 二分查找
 * 
 * 给定一个排序的整数数组（升序）和一个要查找的整数target，用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1
 * 
 * 在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2。
 * 
 * 如果数组中的整数个数超过了2^32，你的算法是否会出错？
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月4日 下午5:44:25
 */
public class Pnum0014 {

    public static void main(String[] args) {
        
        Pnum0014 pnum14 = new Pnum0014();
        int[] ary = {1, 2, 3, 3, 4, 5, 10};
        int index = pnum14.binarySearch(ary, 1);
        System.out.println(index);
    }
    
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if(null == nums || 0 == nums.length) {
            return -1;
        }
        
        int fromIndex = 0;
        int endIndex = nums.length - 1;
        
        while(fromIndex <= endIndex) {
            int middleIndex = (endIndex + fromIndex) / 2;
            if(nums[middleIndex] == target) {
                //往前数,找到最先等于target的index
                while(middleIndex-1 >= fromIndex && nums[middleIndex-1] == target) {
                    --middleIndex;
                }
                
                return middleIndex;
            } else if(nums[middleIndex] > target) {
                endIndex = middleIndex-1;
            } else {
                fromIndex = middleIndex+1;
            }
        }
        
        return -1;
    }
}
