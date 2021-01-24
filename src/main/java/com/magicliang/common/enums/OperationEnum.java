package com.magicliang.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * project name: lsm-tree-demo
 * <p>
 * description: 操作枚举
 *
 * @author magicliang
 * <p>
 * date: 2021-01-24 20:37
 */
@Getter
@RequiredArgsConstructor
public enum OperationEnum {

    /**
     * 设值
     */
    PUT(1, "put"),
    ;

    private final int code;
    private final String desc;


}
