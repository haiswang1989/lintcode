package com.lintcode.t201808;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * First Unique Number in a Stream II
 * 
 * We need to implement a data structure named DataStream. There are two methods required to be implemented:
 * 
 * void add(number) // add a new number
 * int firstUnique() // return first unique number
 * 
 * add(1)
 * add(2)
 * firstUnique() => 1
 * add(1)
 * firstUnique() => 2
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月13日 上午10:01:26
 */
public class Pnum0960 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        DataStream dataStream = new DataStream();
        dataStream.add(1);
        dataStream.add(2);
        System.out.println(dataStream.firstUnique());
        dataStream.add(1);
        System.out.println(dataStream.firstUnique());
    }

}

class DataStream {
    
    //已经出现过的数据
    HashSet<Integer> hasAppearNums;
    
    //出现过一次的数据
    LinkedHashSet<Integer> onecNums;
    
    public DataStream(){
        // do intialization if necessary
        hasAppearNums = new HashSet<>();
        onecNums = new LinkedHashSet<>();
    }
    
    /**
     * 
     * @param num: next number in stream
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if(hasAppearNums.contains(num)) {
            onecNums.remove(num);
        } else {
            hasAppearNums.add(num);
            onecNums.add(num);
        }
    }

    /**
     * 
     * @return: the first unique number in stream
     */
    public int firstUnique() {
        // write your code here
        if(onecNums.size()!=0) {
            return onecNums.toArray(new Integer[0])[0];
        }
        
        return -1;
    }
}
