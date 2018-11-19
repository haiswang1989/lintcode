package com.pointoffer.no21to30;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：242086
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月30日 下午5:20:25
 */
public class Pnum0021 {

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5}; 
        int[] popA = {4,3,5,1,2};
        
        Pnum0021 pnum0021_ = new Pnum0021();
        boolean is = pnum0021_.IsPopOrder(pushA, popA);
        System.out.println(is);
    }
    
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int pushALength = pushA.length;
        int popALength = popA.length;
        Stack<Integer> stack = new Stack<>();
        
        int i=0, j=0;
        for(; i<pushALength && j<popALength; ) {
            if(pushA[i] == popA[j]) {
                j++;
                i++;
            } else if(!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            } else {
                stack.push(pushA[i]);
                i++;
            }
        }
        
        while(!stack.isEmpty()) {
            if(stack.pop() != popA[j++]) {
                return false;
            } 
        }
        
        return true;
    }
}
