package com.lintcode.t201808;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 数据流中第一个唯一的数字
 * 
 * 给一个连续的数据流,写一个函数返回终止数字到达时的第一个唯一数字（包括终止数字）,如果在终止数字前无唯一数字或者找不到这个终止数字, 返回 -1.
 * 
 * 给一个数据流 [1, 2, 2, 1, 3, 4, 4, 5, 6] 以及一个数字 5, 返回 3
 * 
 * 给一个数据流 [1, 2, 2, 1, 3, 4, 4, 5, 6] 以及一个数字 7, 返回 -1
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月13日 上午11:08:52
 */
public class Pnum0685 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1, 2, 2, 1, 5, 4, 4, 5, 6};
        Pnum0685 pnum0685 = new Pnum0685();
        System.out.println(pnum0685.firstUniqueNumber(arr, 6));
    }
    
    /**
     * 
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        if(null == nums) {
            return -1;
        }
        
        boolean findStopNum = false;
        HashMap<Integer, Integer> numsCnt = new HashMap<>();
        LinkedHashSet<Integer> once = new LinkedHashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(numsCnt.containsKey(num)) {
                numsCnt.put(num, numsCnt.get(num) + 1);
                once.remove(num);
            } else {
                numsCnt.put(num, 1);
                once.add(num);
            }
            
            if(num == number) {
                findStopNum = true;
                break;
            }
        }
        
        if(!findStopNum) {
            return -1;
        }
        
        if(0!=once.size()) {
            return once.toArray(new Integer[0])[0];
        }
        
        return -1;
    }
}
