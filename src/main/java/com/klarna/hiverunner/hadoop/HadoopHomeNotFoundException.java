package com.klarna.hiverunner.hadoop;

public class HadoopHomeNotFoundException extends Throwable {

    public HadoopHomeNotFoundException(String hadoopDirSysProperty, String hadoopDirEnvProperty) {
        super("Hadoop home directory not found in System property [" + hadoopDirSysProperty + "] neither in Environment variable [" + hadoopDirEnvProperty + "]");
    }
}
