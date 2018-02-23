package com.thisamateur.beans;

import java.util.List;

/**
 * 原始依赖输出文件解析接口
 * created by thisAmateur at 2018/2/23
 */
public interface IRawLineParser {
    /**
     * 执行解析动作
     * @return JarLine对象列表
     */
    List<JarLine> parse();
}
