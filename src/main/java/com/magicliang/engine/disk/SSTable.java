package com.magicliang.engine.disk;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * project name: lsm-tree-demo
 * <p>
 * description: 排序字符串表，这个数据结构尽量不会并发写，所以不需要继承 ConcurrentHashMap。它本质上是一种 log segment。
 *
 * @author magicliang
 * <p>
 * date: 2021-01-24 20:31
 */
@Getter
@RequiredArgsConstructor
public class SSTable {

    /**
     * 是否被删除
     */
    private final Boolean deleted;

    /**
     * 键
     */
    private final String key;


    /**
     * 值
     */
    private final String value;
}
