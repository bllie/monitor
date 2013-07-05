package com.vladwelt.monitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerMemInfo {
    private File fileParser;
    private Dictionary dictionary;
    public ScannerMemInfo(File file) {
        fileParser = file;
        dictionary = new Dictionary();
        parser();
    }
    private void parser() {
        try {
            Scanner scanner = new Scanner(fileParser);
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
