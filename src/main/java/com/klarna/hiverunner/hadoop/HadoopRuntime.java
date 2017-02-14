package com.klarna.hiverunner.hadoop;

import java.io.IOException;

public class HadoopRuntime {
    public void setHadoopHome() throws HadoopHomeNotFoundException {
        try {
            AbsolutePath hadoopHome = getHadoopHomePath();
            System.setProperty("hadoop.home.dir", hadoopHome.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AbsolutePath getHadoopHomePath() throws IOException, HadoopHomeNotFoundException {
        String hadoopHome = System.getProperty("hadoop.home.dir");

        if(hadoopHome != null) {
            return new AbsolutePath(hadoopHome);
        }

        hadoopHome = System.getenv("HADOOP_HOME");

        if(hadoopHome != null) {
            return new AbsolutePath(hadoopHome);
        }

        throw new HadoopHomeNotFoundException("hadoop.home.dir", "HADOOP_HOME");
    }
}
