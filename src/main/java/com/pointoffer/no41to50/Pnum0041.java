package com.pointoffer.no41to50;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 和为S的连续正数序列
 * 
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16(9,10,11,12,13,14,15,16)的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月1日 下午2:56:09
 */
public class Pnum0041 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Pnum0041 pnum0041 = new Pnum0041();
        ArrayList<ArrayList<Integer>> rets = pnum0041.FindContinuousSequence(100);
        for (ArrayList<Integer> arrayList : rets) {
            System.out.println(arrayList.toString());
        }
    }
    
    /**
     * 
     * 不管sum是奇数还是偶数
     * 都可能由奇数个或者偶数个连续数值累加获得
     * 
     * 奇偶奇 -> 偶数
     * 偶奇偶 -> 奇数
     * 
     * 奇偶奇偶 ->偶数
     * 奇偶 -> 奇数
     * 
     * 
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> rets = new ArrayList<>();
        for(int numCnt=2; numCnt<sum; numCnt++) {
            if(isOdd(numCnt)) {
                //如果是奇数个元素,sum能整除元素个数,那么就存在
                if(sum % numCnt == 0) {
                    int middle = sum / numCnt;
                    if((middle - (numCnt / 2)) < 0) {
                        break;
                    }
                    
                    ArrayList<Integer> ret = getArrayList(middle, numCnt);
                    rets.add(ret);
                }
            } else {
                //如果是偶数个元素,那么要check由多少对
                //奇数对结果就是奇数
                //偶数对结果就是偶数
                //1,2,3,4 -> 2对 -> 10偶数
                //1,2,3,4,5,6 -> 3对 ->21 奇数
                int pairCnt = numCnt / 2;
                if(isOdd(sum) ? isOdd(pairCnt) : !isOdd(pairCnt)) {
                    //如果是奇数,那么就得是奇数对,如果是偶数,那么就得是偶数对
                    int onePairSum = sum / pairCnt;
                    //不管是奇数对还是偶数对,没对的总和必须是奇数,相连两个数的和不可能是偶数
                    if(isOdd(onePairSum)) {
                        int middleMax = (onePairSum + 1) / 2; 
                        int middle = sum/numCnt;
                        if((middle - (numCnt / 2)) < 0) {
                            break;
                        }
                        ArrayList<Integer> ret = getArrayList(middleMax, numCnt);
                        rets.add(ret);
                    }
                } 
            }
        }
        
        //这边是为了调整返回值的顺序,与实现逻辑无关
        ArrayList<ArrayList<Integer>> newRets = new ArrayList<>(rets.size());
        if(0!=rets.size()) {
            Stack<ArrayList<Integer>> stack = new Stack<>();
            for (ArrayList<Integer> arrayList : rets) {
                stack.add(arrayList);
            }
            
            while(!stack.isEmpty()) {
                newRets.add(stack.pop());
            }
        }
        
        return newRets;
    }
    
    /**
     * 
     * @param num
     * @return
     */
    boolean isOdd(int num) {
        return num % 2 == 1;
    }
    
    /**
     * 
     * @param middle
     * @param numCnt
     * @return
     */
    public ArrayList<Integer> getArrayList(int middle, int numCnt) {
        ArrayList<Integer> retList = new ArrayList<>();
        int firstNum = 0;
        int lastNum = 0;
        if(isOdd(numCnt)) {
            firstNum = middle - ((numCnt - 1) / 2);
            lastNum = middle + ((numCnt - 1) / 2);
        } else {
            firstNum = middle - (numCnt / 2);
            lastNum = middle + (numCnt / 2) - 1;
        }
        
        for(int i=firstNum; i<=lastNum; i++) {
            retList.add(i);
        }
        
        return retList;
    }
}
