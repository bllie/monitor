package com.vladwelt.monitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerStatm {
    private File file;
    private String[] values;
    public ScannerStatm(File file) {
        this.file = new File(file, "statm");
        parser();
    }

    private void parser() {
        try {
            Scanner scanner = new Scanner(file);
            this.values = scanner.nextLine().split(" ");
        } catch (FileNotFoundException ex) {
        }
    }
    
    public String getValue(int index) {
        return this.values[index];
    }
}
