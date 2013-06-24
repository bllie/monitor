package com.vladwelt.monitor;

import java.io.File;

public class DirectoryProccess implements Proccess {

    private File file;
    public DirectoryProccess(String name) {
        this.file = new File(name);
    }

    @Override
    public boolean isDirectoryProccess() {
        if (!file.exists()) {
            return false;
        }
        if (!file.isDirectory()) {
            return false;
        }
        if (!file.getName().matches("([0-9])+")) {
            return false;
        }
        return true;
    }

    @Override
    public String nameProccess() {
        ScannerStatus scannerStatus = new ScannerStatus(file);
        return scannerStatus.getValue("Name");
    }

    @Override
    public String proccesId() {
        ScannerStatus scannerStatus = new ScannerStatus(file);
        return scannerStatus.getValue("Pid");
    }

    @Override
    public String useMemory() {
        ScannerStatm scanner = new ScannerStatm(this.file);
        return scanner.getValue(5);
    }
}
