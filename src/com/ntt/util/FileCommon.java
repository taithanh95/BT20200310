package com.ntt.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCommon {


    public static ArrayList<String> readStringFromTextFile(String filePath) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        String line = null;

        try {
            LineNumberReader reader = new LineNumberReader(new FileReader(filePath));
            while (!StringCommon.isNullOrBlank(line = reader.readLine())) {
                list.add(line);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return list;
    }

    public static String writeTextFile(String filePath, List<String> data) {
        if (filePath == null || "".equals(filePath.trim()) || data == null || data.isEmpty()) {
            return "Data input is null";
        }
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < data.size(); i++) {
                bw.write(data.get(i));
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception when write file";
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return "OK";
    }
}
