package com.thisamateur.beans;

public class JarLine {
    private String groupId;
    private String artifactId;
    private String version;
    private String fileType;
    private int indexOfFirstCharactor;
    private int level;

    // EXAMPLE:[INFO] | \- org.hamcrest:hamcrest-core:jar:1.3:test
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
        groupId = jarInfoArray[0];
        artifactId = jarInfoArray[1];
        fileType = jarInfoArray[2];
        version = jarInfoArray[3];
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
    
    public String getFileName() {
        return artifactId + "-" + version + "." + fileType;
    }
    
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
