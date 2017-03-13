package com.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by artem on 12.03.17.
 */
public class Data {

    private  String fileName;
    public Data(String fileName) {
        this.fileName= fileName;
    }

    public  Collection<String[]> getTestData()
            throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(";");
            records.add(fields);
        }
        file.close();
        return records;
    }
}
