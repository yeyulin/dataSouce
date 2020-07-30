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
        if (lruCacheMap.containsKey(key)) {
            Object value = lruCacheMap.get(key);
            //先删除，然后重新移除
            lruCacheMap.remove(key);
            lruCacheMap.put(key, value);
            return value;
        }
        return null;
    }

    public void set(Object key, Object value) {
        lruCacheMap.put(key, value);
    }

    public void entrySet() {
        Set<Map.Entry> set = lruCacheMap.entrySet();

        for (Map.Entry entry : set) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "====" + value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set("1", "1");
        cache.set("2", "2");
        cache.set("3", "3");

        Object o = cache.get("4");
        cache.get("1");
        cache.get("2");
        cache.entrySet();
        //3-1-2
        //1-2-4
        cache.set("4", "4");

        cache.entrySet();
    }
}
