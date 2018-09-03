package com.lintcode.t201807;

/**
 * 
 * Implement strStr()
 * 
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 * 
 * 如果 source = "source" 和 target = "target"，返回 -1。
 * 如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。
 * 
 * O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月4日 下午4:33:43
 */
public class Pnum0013 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        // write your code here
        if(null==source || null==target || source.length() < target.length()) {
            return -1;
        }
        
        
        
        return byJavaApi(source, target);
    }
    
    /**
     * 
     * @param source
     * @param target
     * @return
     */
    public int byJavaApi(String source, String target) {
        return source.indexOf(target);
    }
    
    /**
     * 
     * @param source
     * @param target
     * @return
     */
    public int byKMP(String source, String target) {
        return -1;
    }
}
