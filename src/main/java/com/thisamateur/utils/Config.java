package com.thisamateur.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * ��ȡ������
 * created by thisAmateur at 2018/2/23
 */
public class Config {
    /** �ļ���·������·���洢������ mvn dependency:copy-dependencies �õ�����Ŀ������jar��*/
    public static final String JAR_REPO_PATH = "jarRepoPath";

    /** ����jar�������Ļ�·�� */
    public static final String TARGET_BASE_PATH = "targetBasePath";

    /** mvn dependency:tree ���ɵĹ��������ļ���·�� */
    public static final String DEPENDENCY_FILE_PATH = "dependencyFilePath";

    private static Properties prop = new Properties();

    static {
        try {
            InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * �����������key��ȡ��Ӧ��value
     * @param key �������keyֵ
     * @return �������value
     */
    public static String getProperty(String key) {
        return Config.prop.getProperty(key);
    }
}
