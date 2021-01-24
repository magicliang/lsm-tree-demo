package com.magicliang.engine.disk;

import com.magicliang.common.enums.OperationEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * project name: lsm-tree-demo
 * <p>
 * description: WAL 日志项
 *
 * @author magicliang
 * <p>
 * date: 2021-01-24 20:35
 */
@Getter
@RequiredArgsConstructor
public class WalLogEntry {

    /**
     * 键
     */
    private final String key;

    /**
     * 键操作
     * {@link OperationEnum}
     */
    private final String operation;

    /**
     * 值
     */
    private final String value;
}
