package com.bof.thfile.main;

import com.bof.thfile.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager test = new FileManager("E:/data_bai_2.txt");

        test.writeText(" 3\n 4\n 5\n 6\n 1\n 4\n 7\n 8\n", true);
        test.readText();
        

    }
}
