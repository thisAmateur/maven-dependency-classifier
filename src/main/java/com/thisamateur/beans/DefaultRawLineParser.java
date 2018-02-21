package com.thisamateur.beans;

import java.util.ArrayList;
import java.util.List;

import com.thisamateur.utils.Utils;

public class DefaultRawLineParser implements IRawLineParser{
    private String dependencyFilePath;
    public DefaultRawLineParser(String path) {
        this.dependencyFilePath = path;
    }

    public List<JarLine> parse() {
        List<JarLine> result = new ArrayList<JarLine>();
        List<String> rawLineList = Utils.readLine(dependencyFilePath);
        boolean isValid = false;
        for (String rawLine : rawLineList) {
            if (!isValid && rawLine.startsWith("[INFO] --- maven-dependency-plugin")) {
                isValid = true;
                continue;
            }
            if (isValid && rawLine.startsWith("[INFO] ------------------------------")) {
                isValid = false;
                continue;
            }
            if (isValid) {
                result.add(new JarLine(rawLine));
            }
        }
        return result;
    }
}
