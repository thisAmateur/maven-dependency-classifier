package com.thisamateur.example;

import java.util.List;

import com.thisamateur.beans.DefaultClassifier;
import com.thisamateur.beans.DefaultRawLineParser;
import com.thisamateur.beans.IClassifier;
import com.thisamateur.beans.IRawLineParser;
import com.thisamateur.beans.JarLine;
import com.thisamateur.utils.Config;

/**
 * demo
 * created by thisAmateur at 2018/2/23
 */
public class MainThread {

    // D:\eclipse\WORKSPACE\springguide\target\jarRepo
    
    public static void main(String[] args) {
        System.out.println("Start");
        String jarRepoPath = Config.getProperty(Config.JAR_REPO_PATH);
        String targetBasePath = Config.getProperty(Config.TARGET_BASE_PATH);
        String dependencyFilePath = Config.getProperty(Config.DEPENDENCY_FILE_PATH);
        // step1：解析原始依赖文件
        IRawLineParser parser = new DefaultRawLineParser(dependencyFilePath);
        List<JarLine> jarLineList = parser.parse();
        // step2：执行分类
        IClassifier classifier = new DefaultClassifier(targetBasePath, jarRepoPath, jarLineList);
        classifier.classify();
        System.out.println("end");
    }

}
