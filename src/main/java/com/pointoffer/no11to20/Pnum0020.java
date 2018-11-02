package com.pointoffer.no11to20;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：202153
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月30日 下午2:24:26
 */
public class Pnum0020 {
    
    public static void main(String[] args) {
        
    }
    
}

class StachWithMin {
    
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();
    private int min = Integer.MAX_VALUE;
    
    public void push(int node) {
        stack.push(node);
        if(node < min) {
            stackMin.push(node);
            min = node;
        } else {
            stackMin.push(min);
        }
    }
    
    public void pop() {
        stackMin.pop();
        min = stackMin.peek(); //新的最小值
        stack.pop();
    }
    
    public int top() {
        stackMin.pop();
        min = stackMin.peek(); //新的最小值
        return stack.pop();
    }
    
    public int min() {
        return stackMin.peek();
    }
}