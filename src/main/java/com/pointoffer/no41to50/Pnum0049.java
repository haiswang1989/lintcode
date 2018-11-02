package com.pointoffer.no41to50;

/**
 * 把字符串转换成整数
 * 
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月2日 下午2:22:46
 */
public class Pnum0049 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        
        Pnum0049 pnum0049 = new Pnum0049();
        int strInt = pnum0049.StrToInt("1a33");
        System.out.println(strInt);
        
    }
    
    public int StrToInt(String str) {
        if(str.length() > 11) {
            return 0;
        }
        
        int length = str.length();
        
        int strInt = 0;
        int bitType = 1;
        
        boolean firstIsZero = false;
        
        for(int i=length-1; i>=0; i--) {
            char ch = str.charAt(i);
            if(ch>'0' && ch<='9') {
                strInt += bitType * (ch - '0');
                firstIsZero = false;
            } else if(ch=='0') { 
                firstIsZero = true;
            } else if(ch=='-' || ch=='+') {
                if(i == 0) {
                    if(ch=='-') {
                        strInt *= -1;
                    }
                } else {
                    return -1;
                }
            } else {
                return 0;
            }
            
            bitType *= 10;
        }
        
        if(firstIsZero) {
            return 0;
        }
        
        return strInt;
    }
}
