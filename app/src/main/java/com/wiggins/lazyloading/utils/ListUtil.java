package com.wiggins.lazyloading.utils;

import java.util.List;

/**
 * @Description List工具类
 * @Author 一花一世界
 */
public class ListUtil {

    private ListUtil() {
        throw new AssertionError();
    }

    /**
     * 数据源大小
     *
     * @param sourceList 数据源
     */
    public static <V> int getSize(List<V> sourceList) {
        return sourceList == null ? 0 : sourceList.size();
    }

    /**
     * 数据源是否为空
     *
     * @param sourceList 数据源
     */
    public static <V> boolean isEmpty(List<V> sourceList) {
        return (sourceList == null || sourceList.size() == 0);
    }
}
