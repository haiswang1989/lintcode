package com.lintcode.t201807;

import java.util.LinkedList;
import java.util.List;

/**
 * Fizz Buzz 问题
 * 
 * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数
 * 如果这个数被3整除，打印fizz
 * 如果这个数被5整除，打印buzz
 * 如果这个数能同时被3和5整除，打印fizz buzz.
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月4日 上午11:02:40
 */
public class Pnum0009 {

    public static void main(String[] args) {
        
    }
    
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> ret = new LinkedList<>();
        for(int i=1; i<=n; ++i) {
            if(i % 15 == 0) {
                ret.add("fizz buzz");
            } else if(i % 5 == 0) {
                ret.add("buzz");
            } else if(i % 3 == 0) {
                ret.add("fizz");
            } else {
                ret.add(i + "");
            }
        }
        
        return ret;
    }

}
