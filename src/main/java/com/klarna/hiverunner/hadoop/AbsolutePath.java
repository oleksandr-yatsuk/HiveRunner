package com.klarna.hiverunner.hadoop;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

public class AbsolutePath {
    private final File root;

    public AbsolutePath(String path) {
        this(new File(path));
    }

    public AbsolutePath(File root) {
        this.root = root;
    }

    public AbsolutePath with(String appendPath) {
        return new AbsolutePath(new File(root, appendPath));
    }

    @Override
    public String toString() {
        try {
            String path = root.getCanonicalPath();
            return FilenameUtils.separatorsToUnix(path);
        }
        catch (IOException e) {
            return null;
        }
    }
}
