package com.pointoffer.no41to50;

/**
 * 
 * 左旋转字符串
 * 
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 下午2:57:52
 */
public class Pnum0043 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str  = "abcXYZdef";
        
        Pnum0043 pnum0043 = new Pnum0043();
        String re = pnum0043.LeftRotateString(str, 3);
        System.out.println(re);
    }
    
    public String LeftRotateString(String str,int n) {
        if(null==str || 0==str.length()) {
            return str;
        }
        
        int length = str.length();
        n %= length;
        
        StringBuffer sBuilder = new StringBuffer(length);
        sBuilder.append(str.substring(n)).append(str.substring(0, n));
        return sBuilder.toString();
    }
}
