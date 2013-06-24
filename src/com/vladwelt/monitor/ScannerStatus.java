package com.vladwelt.monitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerStatus {
    private File fileStatus;
    private Dictionary dictionary;
    public ScannerStatus(File file) {
        fileStatus = new File(file, "status");
        dictionary = new Dictionary();
        parser();
    }
    private void parser() {
        try {
            Scanner scanner = new Scanner(fileStatus);
            String key,value;String[] line;
            while (scanner.hasNext()) {
                line = scanner.nextLine().split(":");
                key = line[0].trim();
                value = line[1].trim();
                dictionary.put(key, value);
            }
        } catch (FileNotFoundException ex) {
        }
    }
    
    public String getValue(String key) {
        return dictionary.get(key);
    }
}
