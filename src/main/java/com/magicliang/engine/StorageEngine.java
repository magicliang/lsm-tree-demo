package com.magicliang.engine;

import com.magicliang.engine.memory.MemTable;
import org.springframework.stereotype.Service;

/**
 * project name: lsm-tree-demo
 * <p>
 * description: 存储引擎
 *
 * @author magicliang
 * <p>
 * date: 2021-01-24 20:22
 */
@Service
public class StorageEngine {

    /**
     * 缺省阈值
     */
    public static final int DEFAULT_THRESHHOLD = 16;

    /**
     * 本内存表的阈值
     */
    private final Integer threshHold;

    /**
     * 当前内存表
     */
    private volatile MemTable<String> currentMemTable;

    // 缺一个后台线程池，进行 compact，然后把数据写入到一个终极的段上

    // wal 队列，选择 queue 还是 blockingqueue 还是 linkedhashmap，只支持追加写，在 compact 的时候会触发删除操作

    // sstables 队列，选择 queue 还是 blockingqueue 还是 linkedhashmap，queue 支持基本的出入队操作，blockingqueue
    // 支持并发安全的出入队操作，linkedhashmap 可以用来实现 lrucache（支持插入顺序和访问顺序两种构造方法），支持按照链表的 tail 和 head 操作。

    // 引入稀疏索引

    /**
     * 缺省构造器
     */
    public StorageEngine() {
        this.currentMemTable = new MemTable<>();
        this.threshHold = DEFAULT_THRESHHOLD;
    }

    /**
     * TODO：优化这个 synchronized，这里之所以要用 synchronized，是为了确保，写操作、计数操作和切换操作在一个原子操作里，这样写对计数的影响不会丢失，
     * 锁相关性对象相关的对象是什么？
     * <p>
     * 计数成功产生的切换操作的内存表的大小也是准确的。
     * 这是一种 eager 方案，另一种异步线程方案难度比较大。
     *
     * @param key   键
     * @param value 值
     */
    public synchronized void put(final String key, final String value) {
        currentMemTable.put(key, value);
        if (threshHold == currentMemTable.size()) {
            swapMemTable();
        }
    }

    /**
     * @param key
     * @return
     */
    public String get(final String key) {
        // 0. 先遍历布隆过滤器
        // 1. 先遍历 mem table
        // 2. 如果找不到，按顺序遍历 sstables
        // 3. 再找不到则返回 null
        return "";
    }

    /**
     * 交换内存表
     */
    private void swapMemTable() {
        // 1. 创建新的内存表，替换当前的内存表。
        // 2. 把当前的内存表转化为 SSTable，转到 SSTable 数组里。
    }
}
