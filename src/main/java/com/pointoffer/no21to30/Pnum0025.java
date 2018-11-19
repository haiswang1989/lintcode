package com.pointoffer.no21to30;

import java.util.HashMap;
import java.util.Map;

import com.pointoffer.common.RandomListNode;

/**
 * 复杂链表的复制
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：251386
 * 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年10月31日 下午2:26:51
 */
public class Pnum0025 {

    public static void main(String[] args) {
        
        RandomListNode randomListNode1 = new RandomListNode(1);
        RandomListNode randomListNode2 = new RandomListNode(2);
        RandomListNode randomListNode3 = new RandomListNode(3);
        RandomListNode randomListNode4 = new RandomListNode(4);
        RandomListNode randomListNode5 = new RandomListNode(5);
        
        randomListNode1.next = randomListNode2;
        randomListNode2.next = randomListNode3;
        randomListNode3.next = randomListNode4;
        randomListNode4.next = randomListNode5;
        
        randomListNode1.random = randomListNode3;
        randomListNode2.random = randomListNode4;
        randomListNode3.random = randomListNode5;
        randomListNode4.random = randomListNode1;
        randomListNode5.random = randomListNode2;
        
        Pnum0025 pnum0025_ = new Pnum0025();
        RandomListNode newNode = pnum0025_.Clone(randomListNode1);
        System.out.println(newNode);
    }
    
    public RandomListNode Clone(RandomListNode pHead) {
        if(null==pHead) {
            return null;
        }
        
        Map<RandomListNode, RandomListNode> old2New = new HashMap<>();
        Map<RandomListNode, RandomListNode> new2Old = new HashMap<>();
        
        RandomListNode loopNode = pHead;
        
        RandomListNode newHead = null;
        RandomListNode beforeLoopNode = null;
        while(null!=loopNode) {
            RandomListNode newRandomListNode = new RandomListNode(loopNode.label);
            
            if(newHead==null) {
                beforeLoopNode = newRandomListNode;
                newHead = beforeLoopNode;
            } else {
                beforeLoopNode.next = newRandomListNode;
                beforeLoopNode = newRandomListNode;
            }
            
            new2Old.put(newRandomListNode, loopNode);
            old2New.put(loopNode, newRandomListNode);
            loopNode = loopNode.next;
        }
        
        RandomListNode newLoopNode = newHead;
        while(null!=newLoopNode) {
            RandomListNode oldNode = new2Old.get(newLoopNode);
            RandomListNode oldRandom = oldNode.random;
            RandomListNode newRandom = old2New.get(oldRandom);
            newLoopNode.random = newRandom;
            newLoopNode = newLoopNode.next;
        }
        
        
        return newHead;
    }
}
