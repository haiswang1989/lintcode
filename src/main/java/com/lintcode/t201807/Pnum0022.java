package com.lintcode.t201807;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.lintcode.common.NestedInteger;
import com.lintcode.common.NestedIntegerImpl;

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月5日 上午10:06:24
 */
public class Pnum0022 {

    public static void main(String[] args) {
        
        NestedInteger nt1 = new NestedIntegerImpl(true, 1, null);
        NestedInteger nt2 = new NestedIntegerImpl(true, 2, null);
        
        NestedInteger nt3 = new NestedIntegerImpl(true, 3, null);
        NestedInteger nt4 = new NestedIntegerImpl(true, 4, null);
        
        List<NestedInteger> listNestedInteger = new ArrayList<>();
        listNestedInteger.add(nt3);
        listNestedInteger.add(nt4);
        
        NestedInteger nt5 = new NestedIntegerImpl(false, null, listNestedInteger);
        
        List<NestedInteger> input = new ArrayList<>();
        input.add(nt1);
        input.add(nt2);
        input.add(nt5);
        
        Pnum0022 pnum22 = new Pnum0022();
        System.out.println(Arrays.toString(pnum22.flatten(input).toArray()));
        
    }
    
    /**
     * 不用递归的方式就用stack来实现
     * 
     * @param nestedList a list of NestedInteger
     * @return a list of integer
     */
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> resultList = new ArrayList<>();
        Stack<Iterator<NestedInteger>> itersStack = new Stack<>();
        Iterator<NestedInteger> iter = nestedList.iterator();
        itersStack.push(iter);
        
        while(itersStack.size() != 0) {
            iter = itersStack.pop();
            while(iter.hasNext()) {
                NestedInteger nestedInteger = iter.next();
                if(nestedInteger.isInteger()) {
                    resultList.add(nestedInteger.getInteger());
                } else {
                    //当遇到了链表,就将自己压如栈中
                    itersStack.push(iter); 
                    //再将当前链表压如栈中,这样break出去一会,再从栈中获取到该list进行遍历
                    itersStack.push(nestedInteger.getList().iterator());
                    break;
                }
            }
        }
        
        return resultList;
    }
}
