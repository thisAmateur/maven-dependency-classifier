package com.thisamateur.beans;

import java.util.ArrayList;
import java.util.List;

import com.thisamateur.utils.Utils;

/**
 * 默认的原始依赖文件解析类
 * created by thisAmateur at 2018/2/23
 */
public class DefaultRawLineParser implements IRawLineParser{
    private String dependencyFilePath;

    /**
     * 默认构造函数
     * @param path 原始依赖文件的路径
     */
    public DefaultRawLineParser(String path) {
        this.dependencyFilePath = path;
    }

    /**
     * 执行解析动作
     * @return JarLine列表
     */
    public List<JarLine> parse() {
        List<JarLine> result = new ArrayList<JarLine>();
        List<String> rawLineList = Utils.readLine(dependencyFilePath);
        boolean isValid = false;
        for (String rawLine : rawLineList) {
            if (!isValid && rawLine.startsWith("[INFO] --- maven-dependency-plugin")) {
                isValid = true;
                continue;
            }
            if (isValid && rawLine.startsWith("[INFO] ------------------------------")) {
                isValid = false;
                continue;
            }
            if (isValid && rawLine.startsWith("[INFO]                               ")) {
                isValid = false;
                continue;
            }
            if (isValid) {
                JarLine tempJar = new JarLine(rawLine);
                if (!("jar".equalsIgnoreCase(tempJar.getFileType()))) {
                    continue;
                }
                result.add(new JarLine(rawLine));
            }
        }
        return result;
    }
}
