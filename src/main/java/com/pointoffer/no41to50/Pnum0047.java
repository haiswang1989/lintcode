package com.pointoffer.no41to50;

/**
 * 
 * 求1+2+3+...+n
 * 
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月2日 上午10:32:52
 */
public class Pnum0047 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Pnum0047 pnum0047 = new Pnum0047();
        int sum = pnum0047.Sum_Solution(3);
        System.out.println(sum);
    }
    
    
    public int Sum_Solution(int n) {
        int sum = 0;
        @SuppressWarnings("unused")
        boolean b = (n==0) || (sum = n + Sum_Solution(n-1)) > 0;
        return sum;
    }

}
