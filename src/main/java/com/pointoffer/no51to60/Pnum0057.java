package com.pointoffer.no51to60;

import com.pointoffer.common.TreeLinkNode;

/**
 * 
 * 二叉树的下一个结点
 * 
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月5日 上午10:08:37
 */
public class Pnum0057 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        TreeLinkNode tlNode5 = new TreeLinkNode(5);
        TreeLinkNode tlNode6 = new TreeLinkNode(6);
        TreeLinkNode tlNode7 = new TreeLinkNode(7);
        TreeLinkNode tlNode8 = new TreeLinkNode(8);
        TreeLinkNode tlNode9 = new TreeLinkNode(9);
        TreeLinkNode tlNode10 = new TreeLinkNode(10);
        TreeLinkNode tlNode11 = new TreeLinkNode(11);
        
        
        tlNode8.left = tlNode6;
        tlNode8.right = tlNode10;
        tlNode6.next = tlNode8;
        tlNode10.next = tlNode8;
        
        tlNode6.left = tlNode5;
        tlNode6.right = tlNode7;
        tlNode5.next = tlNode6;
        tlNode7.next = tlNode6;
        
        tlNode10.left = tlNode9;
        tlNode10.right = tlNode11;
        tlNode9.next = tlNode10;
        tlNode11.next = tlNode10;
        
        
        
        Pnum0057 pnum0057 = new Pnum0057();
        TreeLinkNode ret = pnum0057.GetNext(tlNode7);
        System.out.println(ret);
        
    }
    
    
    /**
     * 
     * 1:当前结点的右结点不为NULL
     * 那么返回值就在右子树上(准确的说,就是右子树的左结点的左结点...)
     * 但是如果右结点的左结点为NULL,那么就直接返回右结点,否则就不停的递归右结点的左结点,直到叶子结点
     * 
     * 
     * 2:当前结点的右节点为NULL
     * 找他的父结点ParentNode
     * ParentNode==NULL
     * 自己就是头结点,按照1的逻辑check ParentNode的rightChild,
     * ParentNode.rightChild==NULL
     * 即Head结点的right子树为NULL,那么Head结点就是中序遍历的最后一个结点,他的后面一个结点即为NULL
     * ParentNode.rightChild!=NULL
     * 
     * 
     * ParentNode!=NULL
     * 当前结点是ParentNode的left结点
     * 如果是左结点,那么ParentNode就是当前结点的Next结点
     * 
     * 当前结点是ParentNode的right结点
     * 递归check ParentNode的父结点,直到ParentNode结点是父结点的left结点,那么返回ParentNode,否则返回NULL
     * 
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(null == pNode) {
            return null;
        }
        
        TreeLinkNode currNode = null;
        //当前结点的右结点不为null
        //遍历右节点的左结点,直到叶子结点
        if(null!=pNode.right) {
            currNode = pNode.right;
            while(null!=currNode.left) {
                currNode = currNode.left;
            }
            
            return currNode;
        }
        
        //右结点为null
        //如果该结点存在不存在Parent结点,那么pNode即为中序遍历的最后一个结点
        if(null==pNode.next) {
            return null;
        }
        
        //右结点为NULL且该结点存在Parnent结点
        //如果pNode是该Parent结点的左结点,那么parent几点就是pNode的后面一个结点
        if(pNode == pNode.next.left){
            return pNode.next;
        }
        
        //右结点为NULL且该结点存在Parnent结点,并且pNode为Parent结点的右结点
        //那么一直往上遍历,直到currNode为parent的left结点
        currNode = pNode.next;
        while(currNode.next != null){
            if(currNode == currNode.next.left){
                return currNode.next;
            }
            //继续向上找父节点
            currNode = currNode.next;
        }
        
        return null;
    }
    
    /*
    public TreeLinkNode mySolution(TreeLinkNode pNode) {
        
        if(null == pNode) {
            return null;
        }
        
        TreeLinkNode rightChild = pNode.right;
        if(null!=rightChild) { 
            TreeLinkNode rightChildLeft = rightChild.left;
            if(null!=rightChildLeft) {
                while(null!=rightChildLeft.left) {
                    rightChildLeft = rightChildLeft.left;
                }
                
                return rightChildLeft;
            } else {
                return rightChild;
            }
            
        } else {
            TreeLinkNode parentNode = pNode.next;
            if(null==parentNode) { //自己就是头结点
                TreeLinkNode rightChildLeft = pNode.right;
                if(null!=rightChildLeft) {
                    while(null!=rightChildLeft.left) {
                        rightChildLeft = rightChildLeft.left;
                    }
                    
                    return rightChildLeft;
                } else {
                    return null;
                }
            } else {
                if(parentNode.left == pNode) { //自己是左结点
                    return parentNode;
                } else {
                    TreeLinkNode tmp = parentNode;
                    while(null!=parentNode.next) {
                        tmp = parentNode;
                        parentNode = parentNode.next;
                        if(parentNode.left == tmp) {
                            return parentNode;
                        }
                    }
                    
                    //自己是右结点
                    return null;
                }
            }
        }
    }
    */
}
