package com.pointoffer.no61to66;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * 
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *  {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， 
 *  {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月6日 下午3:12:53
 */
public class Pnum0064 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {2,3,4,2,6,2,5,1};
        Pnum0064 pnum0064_ = new Pnum0064();
        ArrayList<Integer> resp = pnum0064_.maxInWindows(array, 3);
        System.out.println(resp.toString());
    }
    
    /**
     * (最大值)
     * 头部 <<<<<<<<<<<<<< 尾巴
     * 
     * 思想：
     * 1：最大值在头部,但是需要考虑出了窗口(最大值的Index+Size >= 当前的Index),头部的最大值需要删除
     * 2：每个Element都要从尾巴往头部遍历比较,如果Element大于尾巴的值,那么尾巴的值需要删除,因为他不可能是"窗口"中的最大值
     * 3：当Element的Index + 1大于Size,那么就要输出窗口最大值了
     * 
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if(null==num || 0==num.length || size<=0 || size>num.length) {
            return result;
        }
        
        
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0; i<num.length; i++) {
            if(!queue.isEmpty()) {
                //查看头部的index + size与当前的index(i)比较
                //如果<=i 那么说明还在"窗口内",否则已经在窗口外,需要删除
                if(i >= queue.peek() + size) {
                    queue.pop();
                }
                
                //头部存储的是最大值
                //当前element从尾巴往头比较
                //如果窗口中的element小于当前的element直接删除
                //因为他们永远都不会是窗口中的最大值了
                while(!queue.isEmpty() && num[i] >= num[queue.getLast()]) {
                    //移除尾巴上的最大值
                    queue.removeLast();
                }
            }
            
            //将数据的index加入到尾巴
            queue.offer(i);
            if(i + 1 >= size) {
                //获取但不移除头部
                result.add(num[queue.peek()]);
            }
        }
        
        return result;
    }
}
