package com.pointoffer.no41to50;

import java.util.Stack;

/**
 * 
 * 翻转单词顺序列
 * 
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 下午2:58:32
 */
public class Pnum0044 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = " ";
        Pnum0044 pnum0044 = new Pnum0044();
        String re = pnum0044.ReverseSentence(str);
        System.out.println("----" + re + "-------------");
    }
    
    public String ReverseSentence(String str) {
        if(null==str || 0==str.length()) {
            return str;
        }
        
        String[] words = str.split(" ");
        if(0==words.length) {
            return str;
        }
        
        Stack<String> wordsInStack = new Stack<>();
        for (String word : words) {
            wordsInStack.push(word);
        }
        
        StringBuffer sBuilder = new StringBuffer();
        while(!wordsInStack.isEmpty()) {
            sBuilder.append(wordsInStack.pop()).append(" ");
        }
        
        return sBuilder.substring(0, sBuilder.length() - 1);
    }

}
