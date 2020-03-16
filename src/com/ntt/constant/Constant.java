package com.ntt.constant;

/*
 * Declare constants used in the project
 */
public interface Constant {

    interface COUPLE {
        String FILE_PATH = System.getProperty("user.dir") + "/data_bai_2.txt";
        int LINE_NUMBER = 1000;
        int SUM = 11;
        interface RANDOM_RANGER {
            int MIN = 1;
            int MAX = 10;
        }
    }
}
