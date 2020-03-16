package com.ntt.util;

import java.util.Objects;

public class StringCommon {
    public static boolean isNullOrBlank(String str) {
        return Objects.isNull(str) || str.trim().equals("");
    }
}
