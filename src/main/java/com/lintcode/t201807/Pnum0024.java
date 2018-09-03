package com.lintcode.t201807;

/**
 * LFU缓存
 * 
 * LFU是一个著名的缓存算法,实现LFU中的set 和 get
 * 
 * capacity = 3
 * set(2,2)
 * set(1,1)
 * get(2)
 * >> 2
 * get(1)
 * >> 1
 * get(2)
 * >> 2
 * set(3,3)
 * set(4,4)
 * get(3)
 * >> -1 //这边3删除了,因为3一次都没有访问,LFU是按照访问频率来删除的,如果是LRU那么就是1被删除,LRU是安装"最近最少"被访问来删除的
 * get(2)
 * >> 2
 * get(1)
 * >> 1
 * get(4)
 * >> 4
 * 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月5日 上午11:04:11
 */
public class Pnum0024 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int capacity = 3;
        LFUCache lfuCache = new LFUCache(capacity);
        lfuCache.set(1, 1);
        lfuCache.set(-1, -1);
        lfuCache.set(0, 0);
        
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(-1));
        System.out.println(lfuCache.get(0));
    }

}

/**
 * LFU 最少访问频率 
 * <p>Description:</p>
 * @author hansen.wang
 * @date 2018年7月5日 上午11:04:07
 */
class LFUCache {
    
    private int capacity;
    
    /**
     * 
     * @param capacity: An integer
     */
    public LFUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
    }

    /**
     * 
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
    }

    /**
     * 
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        return -1;
    }
}
