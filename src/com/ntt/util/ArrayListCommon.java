package com.ntt.util;

import java.util.List;
import java.util.Objects;

public class ArrayListCommon {

    public static boolean isNullOrEmpty(List lst) {
        return Objects.isNull(lst) || lst.isEmpty();
    }

    public static boolean isNullOrEmpty(Object[] arrObj) {
        return Objects.isNull(arrObj) || arrObj.length == 0;
    }

    public static Object[] convertList2Array(List list) {
        return list.toArray(new Object[list.size()]);
    }
}
