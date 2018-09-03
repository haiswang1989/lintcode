package com.lintcode.t201807;

import java.util.LinkedHashMap;

public class Pnum0134 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

class LRUCache {
    
    private int capacity;
    
    LinkedHashMap<Integer, Integer> cache;
    
    /*
    * @param capacity: An integer
    */
    public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        final int maxSize = this.capacity;
        float loadFactor = 0.75f;
        int cacheSize = (int)(this.capacity / loadFactor); 
        cache = new LinkedHashMap<Integer, Integer>(cacheSize, loadFactor, true) {
            private static final long serialVersionUID = 1L;
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
                return size() > maxSize;
            }
        };
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        Integer result = cache.get(key);
        return null==result ? -1 : result;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        cache.put(key, value);
    }
}