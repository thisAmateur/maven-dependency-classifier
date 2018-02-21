package com.thisamateur.utils;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String JAR_REPO_PATH = "jarRepoPath";
    public static final String TARGET_BASE_PATH = "targetBasePath";
    public static final String DEPENDENCY_FILE_PATH = "dependencyFilePath";
    private static Properties prop = new Properties();
    
    static {
        try {
            InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(is);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getProperty(String key) {
        return Config.prop.getProperty(key);
    }
}
