//package com.bof.thfile.main;
//
//import com.bof.thfile.FileManager;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    //So dong dau vao trong file data_bai_2.txt
//    public static int line = 1;
//
//    //Random so int trong file data_bai_2.txt tu min --> max
//    public static int min = 1;
//    public static int max = 10000000;
//
//    //Sum N la tong cua cac cap so
//    public static int sum = 12000000;
//
//    public static void main(String[] args) throws IOException {
//        FileManager test = new FileManager("E:/data_bai_2.txt");
//
//        List<String> data = new ArrayList<>();
//
//        for (int i = 0; i < line; i++) {
//            data.add(test.getRandomBetweenRange(min, max) + "");
//        }
//
//        test.writeTextFile(System.getProperty("user.dir") + "/data_bai_2.txt", data);
//        test.readText();
////        final String dir = System.getProperty("user.dir");
////        System.out.println("current dir = " + dir);
//
//    }
//}
