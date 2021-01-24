package com.magicliang.engine.memory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * project name: lsm-tree-demo
 * <p>
 * description: 内存表，要注意内存安全编程
 *
 * @author magicliang
 * <p>
 * date: 2021-01-24 19:53
 */
public class MemTable<V> extends ConcurrentHashMap<String, V> implements Map<String, V> {

    /**
     * 缺省容量
     */
    public static final int DEFAULT_CAPACITY = 16;

    /**
     * 构造器
     */
    public MemTable() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 构造器
     *
     * @param capacity 容量
     */
    public MemTable(int capacity) {
        super(capacity);
    }
}
