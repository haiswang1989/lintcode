package com.lintcode.t201808;

import java.util.Stack;

import com.lintcode.common.TreeNode;

/**
 * 
 * 二叉树的序列化和反序列化
 * 
 * 设计一个算法，并编写代码来序列化和反序列化二叉树。将树写入一个文件被称为“序列化”，读取文件后重建同样的二叉树被称为“反序列化”。
 * 如何反序列化或序列化二叉树是没有限制的，你只需要确保可以将二叉树序列化为一个字符串，并且可以将字符串反序列化为原来的树结构
 * 
 * 对二进制树进行反序列化或序列化的方式没有限制，LintCode将您的serialize输出作为deserialize的输入，它不会检查序列化的结果。
 * 
 * 给出一个测试数据样例， 二叉树{3,9,20,#,#,15,7}，表示如下的树结构：
 * 
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 
 * 我们的数据是进行BFS遍历得到的。当你测试结果wrong answer时，你可以作为输入调试你的代码。
 * 你可以采用其他的方法进行序列化和反序列化
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年8月15日 上午10:43:17
 */
public class Pnum0007 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode tn3  = new TreeNode(3);
        TreeNode tn9  = new TreeNode(9);
        TreeNode tn20  = new TreeNode(20);
        TreeNode tn15  = new TreeNode(15);
        TreeNode tn7  = new TreeNode(7);
        
        tn3.left = tn9;
        tn3.right = tn20;
        
        tn20.left = tn15;
        tn20.right = tn7;
        
        
        Pnum0007 pnum0007 = new Pnum0007();
        String result = pnum0007.serialize(tn3);
        System.out.println(result);
    }
    
    /**
     * 
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder builder = new StringBuilder();
        serializeNode(root, builder);
        return builder.toString();
    }
    
    /**
     * 递归序列化(先根遍历)
     * @param node
     * @param builder
     */
    private void serializeNode(TreeNode node, StringBuilder builder) {
        if(null==node) {
            builder.append("#!");
        } else {
            builder.append(node.val + "!");
            serializeNode(node.left, builder);
            serializeNode(node.right, builder);
        }
    }
    
    /**
     * 
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String[] nodeValues = data.split("!", -1);
        
        Stack<TreeNode> parentTreeNodes = new Stack<>();
        TreeNode parentNode = null;
        
        for (String treeVal : nodeValues) {
            if("#".equals(treeVal)) {
                parentNode = parentTreeNodes.pop();
            } else {
                
            }
            
        }
        
        return null;
    }

}
