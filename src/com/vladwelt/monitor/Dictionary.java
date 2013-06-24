package com.vladwelt.monitor;

public class Dictionary {
    private String[] keys;
    private String[] values;
    public Dictionary() {
        keys = new String[0];
        values = new String[0];
    }
    public boolean put(String key, String value) {
        keys = copy(keys, key);
        values = copy(values, value);
        return true;
    }
    private String[] copy(String[] data, String datum) {
        String[] auxData = new String[data.length + 1];
        System.arraycopy(data, 0, auxData, 0, data.length);
        auxData[auxData.length-1] = datum;
        return auxData;
    }

    public String get(String key) {
        int index = -1;
        for (int i = 0; i < keys.length; i++) {
            if (key.equals(keys[i])) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        }
        return values[index];
    }
}
