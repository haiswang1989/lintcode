package com.lintcode.t201807;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lintcode.common.ListNode;

/**
 * Merge K Sorted Lists
 * 
 * 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
 * 
 * 给出3个排序链表[2->4->null,null,-1->null]，返回 -1->2->4->null
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月27日 下午2:42:24
 */
public class Pnum0104 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln6 = new ListNode(6);
        ListNode ln10 = new ListNode(10);
        
        ln6.next = ln10;
        
        ListNode ln_1 = new ListNode(-1);
        ListNode ln5 = new ListNode(5);
        ListNode ln11 = new ListNode(11);
        ln_1.next = ln5;
        ln5.next = ln11;
        
        List<ListNode> lists = new ArrayList<>();
        lists.add(ln6);
        lists.add(null);
        lists.add(ln_1);
        lists.add(null);
        
        Pnum0104 pnum0104 = new Pnum0104();
        ListNode ln = pnum0104.mergeKLists(lists);
        ln.print();
    }
    
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if(null == lists || 0 == lists.size()) {
            return null;
        }
        
        if(1 == lists.size()) {
            return lists.get(0);
        }
        
        Queue<ListNode> listQueues = new LinkedList<>(lists);
        
        while(true) {
            if(listQueues.size() == 1) {
                break;
            }
            
            ListNode ln1 = listQueues.poll();
            ListNode ln2 = listQueues.poll();
            
            ListNode mergedList = mergeTwoList(ln1, ln2);
            listQueues.offer(mergedList);
        }
        
        return listQueues.poll();
    }
    
    /**
     * 
     * @param ln1
     * @param ln2
     * @return
     */
    public ListNode mergeTwoList(ListNode ln1, ListNode ln2) {
        if(null == ln1) {
            return ln2;
        } else if(null == ln2) {
            return ln1;
        }
        
        ListNode ln1Node = ln1;
        ListNode ln2Node = ln2;
        ListNode newLn = null;
        ListNode loopNewLn = null;
        
        while(null!=ln1Node && null!=ln2Node) {
            if(ln1Node.val <= ln2Node.val) {
                if(null == newLn) {
                    newLn = ln1Node;
                    loopNewLn = newLn;
                } else {
                    loopNewLn.next = ln1Node;
                    loopNewLn = loopNewLn.next;
                }
                ln1Node = ln1Node.next;
            } else {
                if(null == newLn) {
                    newLn = ln2Node;
                    loopNewLn = newLn;
                } else {
                    loopNewLn.next = ln2Node;
                    loopNewLn = loopNewLn.next;
                }
                ln2Node = ln2Node.next;
            }
        }
        
        if(null == ln1Node) {
            loopNewLn.next = ln2Node;
        } else {
            loopNewLn.next = ln1Node;
        }
        
        return newLn;
    }
}