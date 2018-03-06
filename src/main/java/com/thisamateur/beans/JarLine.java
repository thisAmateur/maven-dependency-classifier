package com.thisamateur.beans;

/**
 * 对原始依赖文件中jar信息的抽象
 * created by thisAmateur at 2018/2/23
 */
public class JarLine {
    private String groupId;
    private String artifactId;
    private String version;
    private String fileType;
    private int indexOfFirstCharactor;

    /** 层级 */
    private int level;

    /**
     * 默认构造函数
     * EXAMPLE:[INFO] | \- org.hamcrest:hamcrest-core:jar:1.3:test
     * groupId=org.hamcrest
     * artifactId=hamcrest-core
     * version=1.3
     * fileType=jar
     * level=2
     * @param rawLine 原始依赖信息
     */
    public JarLine(String rawLine) {
        rawLine = rawLine.substring("[INFO] ".length());
        indexOfFirstCharactor = 0;
        for (char ch : rawLine.toCharArray()) {
            if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                break;
            }
            indexOfFirstCharactor++;
        }
        String jarInfo = rawLine.substring(indexOfFirstCharactor);
        String[] jarInfoArray = jarInfo.split(":");
        if (jarInfoArray.length < 6) {
            groupId = jarInfoArray[0];
            artifactId = jarInfoArray[1];
            fileType = jarInfoArray[2];
            version = jarInfoArray[3];
        }else if (jarInfoArray.length == 6) {
            groupId = jarInfoArray[0];
            artifactId = jarInfoArray[1];
            fileType = jarInfoArray[2];
            version = jarInfoArray[4] + "-" + jarInfoArray[3];
        }else {
            throw new RuntimeException("rawLine format error");
        }
        level = indexOfFirstCharactor/ 3;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.groupId).append(":")
        .append(this.artifactId).append(":")
        .append(this.version).append(":")
        .append(this.fileType);
        return sb.toString();
    }

    /**
     * 获取jar实体文件的文件名
     * @return jar的文件名
     */
    public String getFileName() {
        return artifactId + "-" + version + "." + fileType;
    }

    /**
     * 当该jar存在间接依赖时，其间接依赖jar都会被归类在以该jar命名的文件夹下
     * @return jar的文件夹名
     */
    public String getDirName() {
        return artifactId + "-" + version;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getVersion() {
        return version;
    }
    
    public String getFileType() {
        return fileType;
    }

    public int getLevel() {
        return level;
    }
}
