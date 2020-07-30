package com.datasouce.timbersaw.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yeyulin
 * @description:
 * @date 2020/7/30 14:46
 **/
public class LRUCacheMap extends LinkedHashMap {
    private int MAX;

    public LRUCacheMap(int MAX) {
        this.MAX = MAX;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>MAX;
    }
}
