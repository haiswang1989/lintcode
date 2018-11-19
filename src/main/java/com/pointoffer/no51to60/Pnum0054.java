package com.pointoffer.no51to60;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 
 * 字符流中第一个不重复的字符
 * 
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月2日 下午6:03:04
 */
public class Pnum0054 {
    
    //只出现一次的字符串
    private LinkedHashSet<Character> appearOnce = new LinkedHashSet<>();
    
    //已经出现的字符串
    private HashSet<Character> appearChar = new HashSet<>();
    
    public static void main(String[] args) {
        
        Pnum0054 pnum0054 = new Pnum0054();
        pnum0054.Insert('g');
        System.out.println(pnum0054.FirstAppearingOnce());
        pnum0054.Insert('o');
        System.out.println(pnum0054.FirstAppearingOnce());
        pnum0054.Insert('o');
        System.out.println(pnum0054.FirstAppearingOnce());
        pnum0054.Insert('g');
        System.out.println(pnum0054.FirstAppearingOnce());
        pnum0054.Insert('l');
        System.out.println(pnum0054.FirstAppearingOnce());
        pnum0054.Insert('e');
        System.out.println(pnum0054.FirstAppearingOnce());
    }
    
    //Insert one char from stringstream
    public void Insert(char ch) {
        if(appearChar.contains(ch)) {
            appearOnce.remove(ch);
        } else {
            appearChar.add(ch);
            appearOnce.add(ch);
        }
    }
    
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if(appearOnce.isEmpty()) {
            return '#';
        } else {
            return appearOnce.iterator().next();
        }
    }

}
