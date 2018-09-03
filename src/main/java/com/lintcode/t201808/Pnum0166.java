package com.lintcode.t201808;

import com.lintcode.common.ListNode;

/**
 * 链表倒数第n个节点
 * 
 * 找到单链表倒数第n个节点，保证链表中节点的最少数量为n。
 * 
 * 给出链表 3->2->1->5->null和n = 2，返回倒数第二个节点的值1.
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月6日 下午5:32:03
 */
public class Pnum0166 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode ln3 = new ListNode(3);
        ListNode ln2 = new ListNode(2);
        ListNode ln1 = new ListNode(1);
        ListNode ln5 = new ListNode(5);
        
        ln3.next = ln2;
        ln2.next = ln1;
        ln1.next = ln5;
        
        Pnum0166 pnum0166 = new Pnum0166();
        ListNode re = pnum0166.nthToLast(ln3, 2);
        System.out.println(re.val);
        
    }
    
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        
        if(null == head || 0 == n) {
            return null;
        }
        
        ListNode fastNode = head;
        ListNode slowNode = head;
        
        while(--n > 0) {
            fastNode = fastNode.next;
        }
        
        while(null!=(fastNode=fastNode.next)) {
            slowNode = slowNode.next;
        }
        
        return slowNode; 
    }

}
