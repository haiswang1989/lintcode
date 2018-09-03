package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 链表求和
 * 
 * 你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和
 * 
 * 给出两个链表 3->1->5->null 和 5->9->2->null，返回 8->0->8->null
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月6日 下午5:48:53
 */
public class Pnum0167 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode ln3 = new ListNode(3);
        ListNode ln1 = new ListNode(1);
        ListNode ln5 = new ListNode(5);
        
        ListNode ln15 = new ListNode(5);
        ListNode ln19 = new ListNode(9);
        ListNode ln12 = new ListNode(2);
        ListNode ln11 = new ListNode(1);
        
        ln3.next = ln1;
        ln1.next = ln5;
        
        ln15.next = ln19;
        ln19.next = ln12;
        ln12.next = ln11;
        
        Pnum0167 punm0167 = new Pnum0167();
        ListNode re = punm0167.addLists(ln3, ln15);
        re.print();
        
    }
    
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if(null == l1) {
            return l2;
        } else if(null == l2) {
            return l1;
        }
        
        ListNode newListHead = null;
        ListNode newListLoop = null;
        
        ListNode l1LoopNode = l1;
        ListNode l2LoopNode = l2;
        
        boolean hasCarry = false;
        while(null!=l1LoopNode && null!=l2LoopNode) {
            int sum = l1LoopNode.val + l2LoopNode.val;
            if(hasCarry) {
                ++sum;
            }
            
            if(sum >= 10) {
                sum %= 10;
                hasCarry = true;
            } else {
                hasCarry = false;
            }
            
            ListNode newNode = new ListNode(sum);
            if(null == newListHead) {
                newListHead = newNode;
                newListLoop = newListHead;
            } else {
                newListLoop.next = newNode;
                newListLoop = newNode;
            }
            
            l1LoopNode = l1LoopNode.next;
            l2LoopNode = l2LoopNode.next;
        }
        
        if(null != l1LoopNode) {
            addRemainderList(l1LoopNode, newListLoop, hasCarry);
        } else {
            addRemainderList(l2LoopNode, newListLoop, hasCarry);
        }
        
        return newListHead;
    }
    
    /**
     * 
     * @param lsn 剩下的结点
     * @param newListHead
     * @param newListLoop
     * @param hasCarry
     */
    private void addRemainderList(ListNode lsn, ListNode newListLoop, boolean hasCarry) {
        //如果没有进位,那么就直接把剩下的结点拼接到新的链表下面
        //如果没有进位,那么就不会再出现进位了
        if(!hasCarry) {
            newListLoop.next = lsn;
            return;
        }
        
        //如果有进位那么就一直计算 + 1 取余的操作
        //直到没有进位了就可以退出了
        while(null!=lsn && hasCarry) {
            int currNodeVal = lsn.val;
            if(hasCarry) {
                ++currNodeVal;
            }
            
            if(currNodeVal >= 10) {
                currNodeVal %= 10;
                hasCarry = true;
            } else {
                hasCarry = false;
            }
            
            ListNode newNode = new ListNode(currNodeVal);
            newListLoop.next = newNode;
            newListLoop = newNode;
            lsn = lsn.next;
        }
        
        //上面的while循环跳出来只有如下三种可能
        //lns==null && hasCarry==false
        //lns==null && hasCarry==true
        //lns!=null && hasCarry==false
        if(null != lsn) {
            newListLoop.next = lsn;
        } else if(hasCarry) {
            ListNode newNode = new ListNode(1);
            newListLoop.next = newNode;
        } 
    }
}

