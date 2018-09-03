package com.lintcode.t201807;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 主元素 III
 * 
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k
 * 
 * 数组中只有唯一的主元素
 * 
 * 给出数组 [3,1,2,3,2,3,3,4,4,4] ，和 k = 3，返回 3
 * 
 * 要求时间复杂度为O(n)，空间复杂度为O(k)
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月11日 下午4:34:54
 */
public class Pnum0048 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] ary1 = {1,1,1,1,2,2,2,2,2,2,3};
        
        Pnum0048 pnum0048 = new Pnum0048();
        int ret1 = pnum0048.majorityNumber_1(Arrays.asList(ary1));
        System.out.println("主元素I : " + ret1);
        
        Integer[] ary3 = {3,1,2,3,2,3,3,4,4,4};
        int ret3 = pnum0048.majorityNumber_3(Arrays.asList(ary3), 3);
        System.out.println("主元素III : " + ret3);
    }
    
    /**
     * 
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    public int majorityNumber_3(List<Integer> nums, int k) {
        // write your code here
        return byHashMap(nums, k);
    }
    
    /**
     * 
     * @param nums
     * @param k
     * @return
     */
    private int byHashMap(List<Integer> nums, int k) {
        int size = nums.size();
        int cntThreshold = size / k; 
                
        
        HashMap<Integer, Integer> numsCnt = new HashMap<>();
        for (Integer num : nums) {
            if(numsCnt.containsKey(num)) {
                numsCnt.put(num, numsCnt.get(num) + 1);
            } else {
                numsCnt.put(num, 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : numsCnt.entrySet()) {
            if(entry.getValue() > cntThreshold) {
                return entry.getKey();
            }
        }
        
        return -1;
    }
    
    private int me(List<Integer> nums, int k) {
        HashMap<Integer, Integer> numsCnt = new HashMap<>(); 
        int storeCnt = k - 1;
        
        //需要删除的KEY
        Set<Integer> needRemoveKeys = new HashSet<>();
        
        for (int num : nums) {
            needRemoveKeys.clear();
            if(numsCnt.size() < storeCnt) {
                numsCnt.put(num, 1);
            } else {
                Set<Integer> keys = numsCnt.keySet();
                for (Integer key : keys) {
                    int cnt = numsCnt.get(key);
                    if(key == num) {
                        numsCnt.put(key, cnt + 1);
                    } else {
                        if(cnt - 1 <= 0) {
                            //需要删除的key
                            needRemoveKeys.add(key);
                        } else {
                            numsCnt.put(key, cnt - 1);
                        }
                    }
                }
                
                for (Integer needRemoveKey : needRemoveKeys) {
                    numsCnt.remove(needRemoveKey);
                }
                
                if(needRemoveKeys.size() != 0) {
                    numsCnt.put(num, 1);
                }
            }
        }
        
        return 0;
    }
    
    /**
     * 主元素I
     * 给定一个整型数组,找出主元素,它在数组中的出现次数严格大于数组元素个数的二分之一
     * 
     * 给出数组[1,1,1,1,2,2,2],返回 1 
     * 
     * 挑战 要求时间复杂度为O(n),空间复杂度为O(1)
     *
     * 思路：
     * 遍历List,以第一个元素为基准(currNum),numCount作为当前的count,如果下一个元素和基准元素一直那么numCount++
     * 如果下一个元素和基准元素不一致,那么numCount--,当numCount<0时,将当前元素作为基准,重复上面的计算,直到List遍历
     * 结束,那么基准元素就是我们要找的主元素
     * 
     * @param nums
     * @return
     */
    public int majorityNumber_1(List<Integer> nums) {
        Integer currNum = null;
        int numCount = 1;
        
        for (Integer num : nums) {
            if(null == currNum) {
                currNum = num;
            } else {
                if(currNum == num) {
                    numCount++;
                } else {
                    numCount--;
                }
            }
            
            if(numCount < 0) {
                numCount = 1;
                currNum = num;
            }
        }
        
        return currNum;
    }
    
    /**
     * 给定一个整型数组,找到主元素,它在数组中的出现次数严格大于数组元素个数的三分之一
     * 
     * 样例 给出数组[1,2,1,2,1,3,3],返回 1
     * 
     * 要求时间复杂度为O(n),空间复杂度为O(1)
     * 
     * @param nums
     * @return
     */
    public int majorityNumber_2(List<Integer> nums) {
        return 0;
    }
}


