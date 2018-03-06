package com.thisamateur.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.thisamateur.beans.JarLine;

/**
 * 工具方法类
 * created by thisAmateur at 2018/2/23
 */
public class Utils {
    public static final String SPT = System.getProperty("file.separator");

    /**
     * 从jar仓库中复制某个jar到目标路径
     * @param jarLine JarLine对象
     * @param jarRepoPath jar仓库的路径
     * @param targetDir 目标路径
     */
    public static void copyJarFromRepoToDir(JarLine jarLine, String jarRepoPath, String targetDir) {
        String jarFilePath = null;
        if (jarRepoPath.endsWith(Utils.SPT)) {
            jarFilePath = jarRepoPath + jarLine.getFileName();
        }else {
            jarFilePath = jarRepoPath + Utils.SPT + jarLine.getFileName();
        }
        try {
            FileUtils.copyFileToDirectory(new File(jarFilePath), new File(targetDir));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 根据jar的信息，在当前路径下创建一个新的文件夹
     * 文件夹命名：artifactId-version
     * example：junit-4.12
     * @param jarLine JarLine对象
     * @param nowDir 当前路径
     * @return 新的文件夹的路径
     */
    public static String mkDirOfJarInNowDir(JarLine jarLine, String nowDir) {
        String jarDirPath = null;
        if (nowDir.endsWith(Utils.SPT)) {
            jarDirPath = nowDir + jarLine.getDirName();
        }else {
            jarDirPath = nowDir + Utils.SPT + jarLine.getDirName();
        }
        try {
            FileUtils.forceMkdir(new File(jarDirPath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jarDirPath;
    }

    /**
     * 返回当前路径的父目录路径
     * @param nowDir 当前路径
     * @return 父目录路径
     */
    public static String backToParentDir(String nowDir) {
        File parentDir = new File(nowDir).getParentFile();
        String path = null;
        try {
            path = parentDir.getCanonicalPath();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 读取文件，按行解析成String列表
     * @param filePath 文件路径
     * @return String列表
     */
    public static List<String> readLine(String filePath) {
        List<String> result = null;
        try {
            result = FileUtils.readLines(new File(filePath), "UTF-8");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
