package com.lintcode.t201807;

import java.util.Stack;

/**
 * 带最小值操作的栈
 * 
 * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
 * 
 * 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成
 * 
 * 如下操作：push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 1，2，1
 * 
 * 注意点:
 * min()只是看下当前的最小值,并不需要从stack中移除
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月4日 下午2:07:52
 */
public class Pnum0012 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MinStack minStack = new MinStack();
        minStack.push(1);
        System.out.println(minStack.pop());
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.push(1);
        System.out.println(minStack.min());
    }
}

/**
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月4日 下午2:09:17
 */
class MinStack {
    
    private Stack<Integer> elements;
    private Stack<Integer> assistElements;
    
    public MinStack() {
        // do intialization if necessary
        elements = new Stack<>();
        assistElements = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        elements.push(number);
        if(assistElements.size() == 0) {
            assistElements.push(number);
        } else {
            int min = assistElements.peek();
            if(min < number) {
                assistElements.push(min);
            } else {
                assistElements.push(number);
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        int ret = elements.pop();
        assistElements.pop();
        return ret;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return assistElements.peek();
    }
}

