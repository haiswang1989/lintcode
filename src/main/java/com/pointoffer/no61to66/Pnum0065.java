package com.pointoffer.no61to66;

/**
 * 
 * 矩阵中的路径
 * 
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
 * 例如: 
 * a b c e 
 * s f c s 
 * a d e e 
 * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月6日 下午3:14:03
 */
public class Pnum0065 {

    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'a','b','c','b'};
        //char[] str = {'b','c','c','e','d'};
        
        Pnum0065 pnum0065_ = new Pnum0065();
        boolean hasPath = pnum0065_.hasPath(matrix, 3, 4, str);
        System.out.println(hasPath);
    }
    
    /**
     * 
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(null==matrix || null==str || matrix.length<str.length) {
            return false;
        }
        
        boolean[] hasVisit = new boolean[rows * cols];
        boolean hasPath = false;
        for(int y=0; y<rows; y++) {
            for(int x=0; x<cols; x++) {
                hasPath = hasPath(matrix, rows, cols, str, y, x, hasVisit, 0);
                if(hasPath) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * 
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @param yIndex
     * @param xIndex
     * @param hasVisit
     * @param currLength
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str, int yIndex, int xIndex, boolean[] hasVisit, int currLength) {
        if(currLength == str.length) {
            return true;
        }
        
        boolean hasPath = false;
        if(yIndex>=0 && yIndex<rows && xIndex>=0 && xIndex<cols && !hasVisit[yIndex*cols + xIndex] && matrix[yIndex*cols + xIndex]==str[currLength]) {
            ++currLength;
            hasVisit[yIndex*cols + xIndex] = true;
            hasPath = hasPath(matrix, rows, cols, str, yIndex-1, xIndex, hasVisit, currLength) ||
                        hasPath(matrix, rows, cols, str, yIndex+1, xIndex, hasVisit, currLength) ||
                        hasPath(matrix, rows, cols, str, yIndex, xIndex+1, hasVisit, currLength) ||
                        hasPath(matrix, rows, cols, str, yIndex, xIndex-1, hasVisit, currLength);
            if(!hasPath) {
                hasVisit[yIndex*cols + xIndex] = false;
            }
        }
        
        return hasPath;
    }
}
