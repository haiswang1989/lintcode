package com.pointoffer.no31to40;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 
 * 第一个只出现一次的字符
 * 
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 上午9:48:02
 */
public class Pnum0034 {

    public static void main(String[] args) {
        
        String name = "wanghaishengw";
        
        Pnum0034 pnum0033 = new Pnum0034();
        int index = pnum0033.FirstNotRepeatingChar(name);
        System.out.println(index);
    }
    
    public int FirstNotRepeatingChar(String str) {
        if(null==str || 0==str.length()) {
            return -1;
        }
        
        LinkedHashMap<Character, Integer> appearOnecCharWithIndex = new LinkedHashMap<>();
        HashMap<Character, Integer> charCnt = new HashMap<>();
        
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(charCnt.containsKey(c)) {
                int cnt = charCnt.get(c);
                if(cnt == 1) {
                    appearOnecCharWithIndex.remove(c);
                }
                
                charCnt.put(c, cnt+1);
            } else {
                charCnt.put(c, 1);
                appearOnecCharWithIndex.put(c, i);
            }
        }
        
        if(appearOnecCharWithIndex.size() == 0) {
            return -1;
        }
        
        return appearOnecCharWithIndex.entrySet().iterator().next().getValue(); 
    }

}
