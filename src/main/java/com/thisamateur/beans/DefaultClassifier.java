package com.thisamateur.beans;

import java.util.List;

import com.thisamateur.utils.Utils;

public class DefaultClassifier implements IClassifier{
    private List<JarLine> jarLineList;
    private String basePath;
    private String jarRepoPath;

    public DefaultClassifier(String basePath, String jarRepoPath, List<JarLine> jarLineList) {
        this.basePath = basePath;
        this.jarRepoPath = jarRepoPath;
        this.jarLineList = jarLineList;
    }

    public void classify() {
        JarLine now = null;
        int lastLevel = 0;
        String nowPath = basePath;

        for (int i = 0; i < jarLineList.size(); i++) {
            now = jarLineList.get(i);
            
            if (now.getLevel() == 0) {
                continue;
            }

            if (lastLevel < now.getLevel()) {
                nowPath = Utils.mkDirOfJarInNowDir(jarLineList.get(i-1), nowPath);
                Utils.copyJarFromRepoToDir(now, jarRepoPath, nowPath);

            }else if (lastLevel > now.getLevel()) {
                int levelDiff = lastLevel - now.getLevel();
                for (int j = levelDiff; j > 0; j--) {
                    nowPath = Utils.backToParentDir(nowPath);
                }
            }
            Utils.copyJarFromRepoToDir(now, jarRepoPath, nowPath);
            lastLevel = now.getLevel();
        }
    }
}
