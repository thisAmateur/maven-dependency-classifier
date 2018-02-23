package com.thisamateur.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.thisamateur.beans.JarLine;

/**
 * ���߷�����
 * created by thisAmateur at 2018/2/23
 */
public class Utils {
    public static final String SPT = System.getProperty("file.separator");

    /**
     * ��jar�ֿ��и���ĳ��jar��Ŀ��·��
     * @param jarLine JarLine����
     * @param jarRepoPath jar�ֿ��·��
     * @param targetDir Ŀ��·��
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
     * ����jar����Ϣ���ڵ�ǰ·���´���һ���µ��ļ���
     * �ļ���������artifactId-version
     * example��junit-4.12
     * @param jarLine JarLine����
     * @param nowDir ��ǰ·��
     * @return �µ��ļ��е�·��
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
     * ���ص�ǰ·���ĸ�Ŀ¼·��
     * @param nowDir ��ǰ·��
     * @return ��Ŀ¼·��
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
     * ��ȡ�ļ������н�����String�б�
     * @param filePath �ļ�·��
     * @return String�б�
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
