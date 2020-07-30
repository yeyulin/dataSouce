package com.datasouce.timbersaw.cache;

import java.util.Map;
import java.util.Set;

/**
 * @author yeyulin
 * @description: 9
 * @date 2020/7/30 14:46
 **/
public class LRUCache {
    private LRUCacheMap lruCacheMap;

    public LRUCache(int size) {
        this.lruCacheMap = new LRUCacheMap(size);
    }

    public Object get(Object key) {
        return lruCacheMap.get(key);
    }

    public void set(Object key, Object value) {
        lruCacheMap.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lrucache = new LRUCache(4);
        lrucache.set(1, 100);
        lrucache.set(10, 99);
        lrucache.set(15, 98);
        lrucache.set(12, 96);
        lrucache.set(18, 95);
        lrucache.set(1, 94);

        Set<Map.Entry> set = lrucache.lruCacheMap.entrySet();
        for (Map.Entry entry : set) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "====" + value);
        }
    }
}
