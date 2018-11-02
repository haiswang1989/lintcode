package com.pointoffer.no1to10;

/**
 * 
 * 替换空格
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：785125
 * 
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月18日 上午10:04:07
 */
public class Pnum0002 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pnum0002 pnum0002 = new Pnum0002();
        StringBuffer sb = new StringBuffer("  We Are Happy ");
        String ret = pnum0002.replaceSpace(sb);
        System.out.println(ret);
    }
    
    /**
     * 在原字符串的基础之上进行修改
     * 1：首先先统计字符串中' '的个数
     * 2：设置字符串新的长度
     * 3：从后往前进行遍历替换
     * 
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        
        if(null == str || 0==str.length()) {
            return null == str ? null : str.toString();
        }
        
        int blankCnt = 0;
        int oldLength = str.length();
        for(int i=0; i<oldLength; i++) {
            if(str.charAt(i) == ' ') {
                blankCnt++;
            }
        }
        
        if(0 == blankCnt) {
            return str.toString();
        }
        
        int newLength = oldLength + (3-1) * blankCnt;
        str.setLength(newLength);
        
        int addIndex = newLength - 1;
        for(int i=oldLength-1; i>=0; i--) {
            if(str.charAt(i) == ' ') {
                str.setCharAt(addIndex--, '0');
                str.setCharAt(addIndex--, '2');
                str.setCharAt(addIndex--, '%');
            } else {
                str.setCharAt(addIndex--, str.charAt(i));
            }
        }
        
        return str.toString();
    }
    
    /**
     * 
     * 这个做法比较简单,重新创建一个StringBuilder,然后遍历入参
     * 将入参的StringBuffer中的字符串一个一个的copy到新建的StringBuilder中
     * 遇到' '就copy '%','2','0'三个字符
     * 
     * @param str
     * @return
     */
    public String replaceSpace_2(StringBuffer str) {
        
        if(null == str || 0==str.length()) {
            return null == str ? null : str.toString();
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(str.charAt(i));
            }
        }
        
        return builder.toString();
    }
}
