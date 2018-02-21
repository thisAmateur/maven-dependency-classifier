package com.thisamateur.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.thisamateur.beans.JarLine;

public class Utils {
    public static final String SPT = System.getProperty("file.separator");
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
