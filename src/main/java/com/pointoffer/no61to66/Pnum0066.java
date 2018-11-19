package com.pointoffer.no61to66;

/**
 * 
 * 机器人的运动范围
 * 
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 * 
 * 
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年11月6日 下午3:15:18
 */
public class Pnum0066 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        Pnum0066 pnum0066_ = new Pnum0066();
        int count = pnum0066_.movingCount(15,20,20);
        System.out.println(count);
        
    }
    
    public int movingCount(int threshold, int rows, int cols) {
        boolean[] hasVisit = new boolean[rows*cols];
        int step = movingCount(threshold, rows, cols, 0, 0, hasVisit);
        return step;
    }
    
    /**
     * 
     * @param threshold
     * @param rows
     * @param cols
     * @param yIndex
     * @param xIndex
     * @param hasVisit
     * @return
     */
    public int movingCount(int threshold, int rows, int cols, int yIndex, int xIndex, boolean[] hasVisit) {
        if(yIndex>=0 && yIndex<rows && xIndex>=0 && xIndex<cols && canVisit(xIndex, yIndex, threshold) && !hasVisit[yIndex*cols+xIndex]) {
            hasVisit[yIndex*cols+xIndex] = true;
            int stepCnt = 1;
            stepCnt += movingCount(threshold, rows, cols, yIndex+1, xIndex, hasVisit);
            stepCnt += movingCount(threshold, rows, cols, yIndex-1, xIndex, hasVisit);
            stepCnt += movingCount(threshold, rows, cols, yIndex, xIndex+1, hasVisit);
            stepCnt += movingCount(threshold, rows, cols, yIndex, xIndex-1, hasVisit);
            return stepCnt;
        }
        
        return 0;
    }
    
    /**
     * 
     * @param xIndex
     * @param yIndex
     * @param threshold
     * @return
     */
    public boolean canVisit(int xIndex, int yIndex, int threshold) {
        int sum = 0;
        while(xIndex > 0) {
            sum += xIndex % 10;
            xIndex /= 10;
        }
        
        while(yIndex > 0) {
            sum += yIndex % 10;
            yIndex /= 10;
        }
        
        return sum <= threshold;
    }
}
