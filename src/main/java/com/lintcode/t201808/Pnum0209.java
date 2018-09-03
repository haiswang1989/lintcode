package com.lintcode.t201808;

/**
 * 第一个只出现一次的字符
 * 
 * 给出一个字符串，找出第一个只出现一次的字符。
 * 
 * 对于 "abaccdeff", 'b'为第一个只出现一次的字符.
 * 
 * 不使用额外的存储空间。
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月13日 上午10:07:42
 */
public class Pnum0209 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "aabc";
        Pnum0209 pnum0209 = new Pnum0209();
        char re = pnum0209.firstUniqChar(str);
        System.out.println(re);
    }
    
    /**
     * 
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        if(null==str || 0==str.length()) {
            return '\0';
        }
        
        char[] ascii = new char[128];
        for(int i=0; i<str.length(); i++) {
            ascii[str.charAt(i)]++;
        }
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ascii[ch] == 1) {
                return ch;
            }
        }
        
        return '\0';
    }
}
