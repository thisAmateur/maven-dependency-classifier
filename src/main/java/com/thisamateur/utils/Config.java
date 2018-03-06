package com.thisamateur.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置项
 * created by thisAmateur at 2018/2/23
 */
public class Config {
    /** 文件夹路径，该路径存储了所有 mvn dependency:copy-dependencies 得到的项目依赖的jar包*/
    public static final String JAR_REPO_PATH = "jarRepoPath";

    /** 所有jar包归类后的基路径 */
    public static final String TARGET_BASE_PATH = "targetBasePath";

    /** mvn dependency:tree 生成的工程依赖文件的路径 */
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
     * 根据配置项的key获取对应的value
     * @param key 配置项的key值
     * @return 配置项的value
     */
    public static String getProperty(String key) {
        return Config.prop.getProperty(key);
    }
}
