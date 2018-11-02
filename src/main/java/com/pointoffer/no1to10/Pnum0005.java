package com.pointoffer.no1to10;

import java.util.Stack;

/**
 * 
 * 用两个栈实现队列
 * 
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：314591
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月19日 上午9:21:03
 */
public class Pnum0005 {
    
    private Stack<Integer> stack1 = new Stack<Integer>();
    
    private Stack<Integer> stack2 = new Stack<Integer>();
    
    private boolean isStackMode = true;
    
    public void push(int node) {
        if(!isStackMode) {
            isStackMode = true;
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        } 
        
        stack1.push(node);
        
    }
    
    public int pop() {
        if(isStackMode) {
            isStackMode = false;
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }
    
    public static void main(String[] args) {
        
        Pnum0005 pnum0005 = new Pnum0005();
        
        pnum0005.push(1);
        pnum0005.push(2);
        pnum0005.push(3);
        
        System.out.println(pnum0005.pop());
        pnum0005.push(4);
        System.out.println(pnum0005.pop());
        pnum0005.push(5);
        System.out.println(pnum0005.pop());
        System.out.println(pnum0005.pop());
        System.out.println(pnum0005.pop());
    }
}
