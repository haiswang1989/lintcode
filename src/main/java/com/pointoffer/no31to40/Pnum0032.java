package com.pointoffer.no31to40;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * 把数组排成最小的数
 * 
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 上午9:40:11
 */
public class Pnum0032 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Pnum0032 pnum0032_ = new Pnum0032();
        
        int[] numbers = {3,32,321};
        String resp = pnum0032_.PrintMinNumber(numbers);
        System.out.println(resp);
    }
    
    /**
     * 需要对数组的中的元素进行排序,从小到大
     * 但是排序的方式比较特殊 x和y比较 不是单纯的check x > y ?
     * 而是check xy 和 yx哪个比较大  当成字符串来比较
     * 
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int[] numbers) {
        
        if(null==numbers || 0==numbers.length) {
            return "";
        }
        
        Integer[] nums = new Integer[numbers.length];
        int index = 0;
        for (int i : numbers) {
            nums[index++] = i;
        }
        
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 + "" + o2).compareTo(o2 + "" + o1);
            }
        });
        
        StringBuilder sBuilder = new StringBuilder();
        for (Integer integer : nums) {
            sBuilder.append(integer);
        }
        
        return sBuilder.toString();
    }
}
