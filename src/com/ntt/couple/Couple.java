package com.ntt.couple;

import com.ntt.constant.Constant;
import com.ntt.util.ArrayListCommon;
import com.ntt.util.FileCommon;
import com.ntt.util.NumberCommon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Couple {

    public void findCoupleNumber(int sum, List<Integer> dataNumberList) {
        boolean checkFind = false;
        for (int i = 1; i < dataNumberList.size(); i++) {
            if (dataNumberList.get(0) + dataNumberList.get(i) == sum) {
                checkFind = true;
                System.out.println(dataNumberList.get(0) + "," + dataNumberList.get(i));
                dataNumberList.remove(i);
                dataNumberList.remove(0);
                break;
            }
        }
        if (!checkFind)
            dataNumberList.remove(0);
        if (dataNumberList.size() >= 2)
            findCoupleNumber(sum, dataNumberList);
    }

    public String createInputData() {
        return FileCommon.writeTextFile(Constant.COUPLE.FILE_PATH, NumberCommon.getListRandom(Constant.COUPLE.LINE_NUMBER, Constant.COUPLE.RANDOM_RANGER.MIN, Constant.COUPLE.RANDOM_RANGER.MAX));
    }

    public static void main(String[] args) {
        Couple couple = new Couple();
        //Tao mang du lieu data
        String rs = couple.createInputData();
        if (!rs.equals("OK")) {
            System.out.println("Co loi xay ra khi tao file du lieu dau vao. Chi tiet: " + rs);
            return;
        }

        List<String> data = new ArrayList<>();
        //Doc file du lieu ra list
        try {
            data = FileCommon.readStringFromTextFile(Constant.COUPLE.FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Co loi xay ra khi doc file du lieu dau vao. Chi tiet: " + e.getMessage());
            return;
        }

        //Kiem tra danh sach du lieu lay ra co bi null
        if (ArrayListCommon.isNullOrEmpty(data)) {
            System.out.println("File du lieu doc ra khong co phan tu nao");
            return;
        }

        //validate du lieu dau vao co phai deu la so
        List<String> dataErr = new ArrayList<>();
        List<Integer> dataNumber = new ArrayList<>();
        for (String line : data) {
            Integer numberOfLine = NumberCommon.convertToInteger(line);
            if (Objects.isNull(numberOfLine)) dataErr.add(line);
            else dataNumber.add(numberOfLine);
        }

        //In cac dong bi loi ra khi co dong khong phai la so
        if (!ArrayListCommon.isNullOrEmpty(dataErr)){
            System.out.println("Du lieu dau vao co nhung dong sau khong phai la " + dataErr);
            return;
        }

        //Buoc cuoi cung: Tim ra cac cap so thoa man dieu kien
        couple.findCoupleNumber(Constant.COUPLE.SUM, dataNumber);
    }
}
